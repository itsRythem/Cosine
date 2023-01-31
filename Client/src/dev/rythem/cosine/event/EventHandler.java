package dev.rythem.cosine.event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import dev.rythem.cosine.event.api.Event;
import dev.rythem.cosine.event.api.EventHook;
import dev.rythem.cosine.event.api.Priority;
import dev.rythem.cosine.integrated.Handler;

public final class EventHandler extends Handler {
	
	private final Map<Class<? extends Event>, List<MethodData>> REGISTRY_MAP = new HashMap<Class<? extends Event>, List<MethodData>>();
	
	public EventHandler()
	{
	}
	
	@Override
	public void load()
	{
	}

	@Override
	public void unload()
	{
		REGISTRY_MAP.clear();
	}
	
    public void register(final Object object)
    {
        for (final Method method : object.getClass().getDeclaredMethods())
        {
            if (isMethodBad(method))
                continue;
                
            register(method, object);
        }
    }
    
    public void register(final Object object, final Class<? extends Event> eventClass)
    {
        for(final Method method : object.getClass().getDeclaredMethods())
        {
            if(isMethodBad(method, eventClass))
                continue;
            
            register(method, object);
        }
    }
    
    public void unregister(final Object object)
    {
        for (final List<MethodData> dataList : REGISTRY_MAP.values())
        {
            for (final MethodData data : dataList)
            {
                if (data.getSource().equals(object))
                    dataList.remove(data);
            }
        }

        cleanMap(true);
    }
    
    public void unregister(final Object object, final Class<? extends Event> eventClass)
    {
        if(REGISTRY_MAP.containsKey(eventClass))
        {
            for(final MethodData data : REGISTRY_MAP.get(eventClass))
            {
                if (data.getSource().equals(object))
                	REGISTRY_MAP.get(eventClass).remove(data);
            }

            cleanMap(true);
        }
    }
    
    private void register(final Method method, final Object object)
    {
    	Class<? extends Event> indexClass = (Class<? extends Event>) method.getParameterTypes()[0];
    	final MethodData data = new MethodData(object, method, method.getAnnotation(EventHook.class).value());
    	if(!data.getTarget().isAccessible())
    		data.getTarget().setAccessible(true);
	
    	if(REGISTRY_MAP.containsKey(indexClass))
    	{
    		if(!REGISTRY_MAP.get(indexClass).contains(data))
    		{
    			REGISTRY_MAP.get(indexClass).add(data);
    			sortListValue(indexClass);
    		}
    	}
    	else
    	{
    		REGISTRY_MAP.put(indexClass, new CopyOnWriteArrayList<MethodData>()
    		{
    			private static final long serialVersionUID = 666L; {
    				add(data);
    			}
    		});
    	}
    }
    
    public void removeEntry(final Class<? extends Event> indexClass)
    {
        Iterator<Map.Entry<Class<? extends Event>, List<MethodData>>> mapIterator = REGISTRY_MAP.entrySet().iterator();

        while (mapIterator.hasNext())
        {
            if (mapIterator.next().getKey().equals(indexClass))
            {
                mapIterator.remove();
                break;
            }
        }
    }
    
    public void cleanMap(final boolean onlyEmptyEntries)
    {
        Iterator<Map.Entry<Class<? extends Event>, List<MethodData>>> mapIterator = REGISTRY_MAP.entrySet().iterator();

        while (mapIterator.hasNext())
        {
            if(!onlyEmptyEntries || mapIterator.next().getValue().isEmpty())
                mapIterator.remove();
        }
    }
    
    private void sortListValue(final Class<? extends Event> indexClass)
    {
        List<MethodData> sortedList = new CopyOnWriteArrayList<MethodData>();

        for (final byte priority : Priority.VALUE_ARRAY)
        {
            for (final MethodData data : REGISTRY_MAP.get(indexClass))
            {
                if (data.getPriority() == priority)
                    sortedList.add(data);
            }
        }
        
        REGISTRY_MAP.put(indexClass, sortedList);
    }
    
    private boolean isMethodBad(final Method method)
    {
        return method.getParameterTypes().length != 1 || !method.isAnnotationPresent(EventHook.class);
    }
    
    private boolean isMethodBad(final Method method, final Class<? extends Event> eventClass)
    {
        return isMethodBad(method) || !method.getParameterTypes()[0].equals(eventClass);
    }
    
    public final Event call(final Event event)
    {
        List<MethodData> dataList = REGISTRY_MAP.get(event.getClass());

        if (dataList != null)
        {
            for(final MethodData data : dataList)
            	invoke(data, event);
        }

        return event;
    }
    
    private void invoke(final MethodData data, final Event argument)
    {
        try
        {
        	data.getTarget().invoke(data.getSource(), argument);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
        {
        	e.printStackTrace();
        }
    }
	
	private final class MethodData {
		
	    private final Object source;
	    private final Method target;
	    private final byte priority;
	    
	    public MethodData(final Object source, final Method target, final byte priority)
	    {
	        this.source = source;
	        this.target = target;
	        this.priority = priority;
	    }
	    
	    public Object getSource() {return source;}
	    
	    public Method getTarget() {return target;}
	    
	    public byte getPriority() {return priority;}

	}

}
