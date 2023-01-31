package team.cosine.animation;

import java.util.function.Function;

public enum Ease {

	LINEAR(x -> x),
	
    SineIn(x -> 1 - Math.cos((x * Math.PI) / 2)),
    SineOut(x -> Math.sin((x * Math.PI) / 2)),
    SineInOut(x -> -(Math.cos(Math.PI * x) - 1) / 2),

    CubicIn(x -> x * x * x),
    CubicOut(x -> 1 - Math.pow(1 - x, 3)),
    CubicInOut(x -> x < 0.5 ? 4 * x * x * x : 1 - Math.pow(-2 * x + 2, 3) / 2),

    CircIn(x -> 1 - Math.sqrt(1 - Math.pow(x, 2))),
    CircOut(x -> Math.sqrt(1 - Math.pow(x - 1, 2))),
    CircInOut(x -> x < 0.5 ? (1 - Math.sqrt(1 - Math.pow(2 * x, 2))) / 2 : (Math.sqrt(1 - Math.pow(-2 * x + 2, 2)) + 1) / 2),

    ElasticIn(x -> x == 0 ? 0 : x == 1 ? 1 : -Math.pow(2, 10 * x - 10) * Math.sin((x * 10 - 10.75) * ((2 * Math.PI) / 3))),
    ElasticOut(x -> x == 0 ? 0 : x == 1 ? 1 : Math.pow(2, -10 * x) * Math.sin((x * 10 - 0.75) * ((2 * Math.PI) / 3)) + 1),
    ElasticInOut(x -> x == 0 ? 0 : x == 1 ? 1 : x < 0.5 ? -( Math.pow( 2, 20 * x - 10 ) * Math.sin( ( 20 * x - 11.125 ) * ((2 * Math.PI) / 4.5))) / 2 : Math.pow( 2, -20 * x + 10 ) * Math.sin( ( 20 * x - 11.125 ) * ((2 * Math.PI) / 4.5)) / 2 + 1);

    private final Function<Double, Double> function;

    Ease(final Function<Double, Double> function)
    {
        this.function = function;
    }

    public double func(final double in)
    {
        return function.apply(in);
    }

}