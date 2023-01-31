package team.cosine.animation;

import team.cosine.Cosine;

public class Animator {

    private double state = 0;
    private Ease ease;

    public double animate(double target) {
        return animate(target, this.ease, 60);
    }

    public double animate(double target, double speed) {
        return animate(target, this.ease, speed);
    }

    public double animate(double target, Ease ease) {
        return animate(target, ease, 60);
    }

    public double animate(double target, Ease ease, double speed) {
        if (target > state) {
            state += speed*Cosine.get().frameDelta;
            if (state > target) state = target;
        } else {
            state -= speed*Cosine.get().frameDelta;
            if (state < target) state = target;
        }
        return value(ease);
    }

    public double value(Ease ease) {
        return ease.func(this.state);
    }

    public double value() {
        return value(this.ease);
    }

    public void setEase(Ease ease) {
        this.ease = ease;
    }

}
