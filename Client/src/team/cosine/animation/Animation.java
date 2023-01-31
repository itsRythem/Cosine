package team.cosine.animation;

import team.cosine.Cosine;

public class Animation {

	public static double DELTA;
	
    private double state, value;
    private Ease ease;
    
    public Animation()
    {
    	this(0, Ease.LINEAR);
    }
    
    public Animation(final double state, final Ease ease)
    {	
    	this.state = state;
    	this.ease = ease;
    }
    
    public double setState(final double state)
    {
    	return this.state = state;
    }
    
    public double animate(final double target)
    {
        return this.animate(target, this.ease, 60);
    }

    public double animate(final double target, final double speed)
    {
        return this.animate(target, this.ease, speed);
    }

    public double animate(final double target, final Ease ease)
    {
        return this.animate(target, ease, 60);
    }
    
    public double animate(final double target, final Ease ease, final double speed)
    {
        if (target > state)
        {
            this.state += speed * DELTA;
            if(this.state > target) this.state = target;
        }
        else
        {
            this.state -= speed * DELTA;
            if(this.state < target) this.state = target;
        }
        
        return this.value = this.ease.func(this.state);
    }
    
    /**
     * WARNING | This will re-evaluate the easing and can affect performance
     */
    public double getValue(final Ease ease)
    {
        return this.ease.func(this.state);
    }
    
    public double getValue() {return this.value;}
    public void setEase(final Ease ease) {this.ease = ease;}
    
}