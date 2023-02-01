package team.cosine.animation;

import java.util.function.Function;

public enum Easing {

	LINEAR(x -> x),
	
	SINE_IN(x -> 1 - Math.cos((x * Math.PI) / 2)),
    SINE_OUT(x -> Math.sin((x * Math.PI) / 2)),
    SINE_IN_OUT(x -> -(Math.cos(Math.PI * x) - 1) / 2),
    
    CUBIC_IN(x -> x * x * x),
    CUBIC_OUT(x -> 1 - Math.pow(1 - x, 3)),
    CUBIC_IN_OUT(x -> x < 0.5 ? 4 * x * x * x : 1 - Math.pow(-2 * x + 2, 3) / 2),

    CIRC_IN(x -> 1 - Math.sqrt(1 - Math.pow(x, 2))),
    CIRC_OUT(x -> Math.sqrt(1 - Math.pow(x - 1, 2))),
    CIRC_IN_OUT(x -> x < 0.5 ? (1 - Math.sqrt(1 - Math.pow(2 * x, 2))) / 2 : (Math.sqrt(1 - Math.pow(-2 * x + 2, 2)) + 1) / 2),

    ELASTIC_IN(x -> x == 0 ? 0 : x == 1 ? 1 : -Math.pow(2, 10 * x - 10) * Math.sin((x * 10 - 10.75) * ((2 * Math.PI) / 3))),
    ELASTIC_OUT(x -> x == 0 ? 0 : x == 1 ? 1 : Math.pow(2, -10 * x) * Math.sin((x * 10 - 0.75) * ((2 * Math.PI) / 3)) + 1),
    ELASTIC_IN_OUT(x -> x == 0 ? 0 : x == 1 ? 1 : x < 0.5 ? -( Math.pow( 2, 20 * x - 10 ) * Math.sin( ( 20 * x - 11.125 ) * ((2 * Math.PI) / 4.5))) / 2 : Math.pow( 2, -20 * x + 10 ) * Math.sin( ( 20 * x - 11.125 ) * ((2 * Math.PI) / 4.5)) / 2 + 1);
	
    private final Function<Double, Double> function;
    Easing(final Function<Double, Double> function)
    {
        this.function = function;
    }
    
    public double compute(final double in)
    {
        return this.function.apply(in);
    }

}