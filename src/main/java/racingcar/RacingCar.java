package racingcar;

import racingcar.moving.ConstantSpeedMovingStrategy;
import racingcar.moving.MovingStrategy;
import racingcar.moving.RandomlyMovingStrategy;

public class RacingCar {
    public static RacingCar createRandomlyMovingCar(String name) {
        return new RacingCar(name, new RandomlyMovingStrategy());
    }

    public static RacingCar createConstantSpeedCar(String name, int speed) {
        return new RacingCar(name, new ConstantSpeedMovingStrategy(speed));
    }

    private final MovingStrategy movingStrategy;
    private final String name;
    private int position;

    public RacingCar(String name, MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void moveForward() {
        this.position += movingStrategy.moveForward();
    }
}
