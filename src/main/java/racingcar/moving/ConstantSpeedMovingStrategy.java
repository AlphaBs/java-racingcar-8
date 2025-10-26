package racingcar.moving;

public class ConstantSpeedMovingStrategy implements MovingStrategy {
    private final int speed;

    public ConstantSpeedMovingStrategy(int speed) {
        this.speed = speed;
    }

    @Override
    public int moveForward() {
        return speed;
    }
}
