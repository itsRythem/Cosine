package team.cosine.animation;

import team.cosine.Cosine;

public class Animation {

	public static double DELTA;
	
    private double state, value, starting, target;
    private Easing easing = Easing.LINEAR;
    
    public Animation()
    {
    }
    
    public Animation(final double state, final Easing easing)
    {	
    	this.state = state;
    	this.easing = easing;
    }
    
    public double setState(final double state)
    {
    	return this.state = state;
    }
    
    public double animate(final double target)
    {
        return this.animate(target, 60, this.easing);
    }

    public double animate(final double target, final double speed)
    {
        return this.animate(target, speed, this.easing);
    }

    public double animate(final double target, final Easing easing)
    {
        return this.animate(target, 60, easing);
    }
    
    public double animate(final double target, double speed, final Easing easing)
    {
        if(this.target != target)
        {
        	this.target = target;
        	this.starting = this.state;
        }
        
    	speed = speed *= Math.abs(this.target - this.starting);

        if(target > state)
        {
            this.state += speed * DELTA;
            if(this.state > target) this.state = target;
        }
        else
        {
            this.state -= speed * DELTA;
            if(this.state < target) this.state = target;
        }
        
        return getValue(easing);
    }
    
    /**
     * WARNING | This will re-evaluate the animations position with a new easing
     */
    public double getValue(final Easing easing)
    {
    	return this.value = (easing.compute(Math.abs(this.state - this.starting) / Math.abs(this.target - this.starting)) * (this.target - this.starting)) + this.starting;
    }
    
    public double getValue() {return this.value;}
    public Easing getEasing(final Easing easing) {return this.easing;}
    public void setEasing(final Easing easing) {this.easing = easing;}
    
}