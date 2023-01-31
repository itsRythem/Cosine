package team.cosine.module.impl.combat;

import team.cosine.event.api.EventHook;
import team.cosine.event.impl.MotionUpdateEvent;
import team.cosine.module.api.Module;
import team.cosine.module.api.ModuleCategory;

public class CrystalAura extends Module {

	public CrystalAura()
	{
		super("Crystal Aura", "Automatically places and explodes crystals near your enemy", 0, ModuleCategory.COMBAT);
	}

	@Override
	public void onToggle(final boolean state)
	{
		
	}
	
	@EventHook
	public void onMotionUpdate(final MotionUpdateEvent event)
	{
		
	}

}
