package racingcar;

import racingcar.moving.ConstantSpeedMovingStrategy;
import racingcar.moving.RandomlyMovingStrategy;

public class RacingCars {
    public static RacingCar createRandomlyMovingCar(String name) {
        return new RacingCar(name, new RandomlyMovingStrategy());
    }

    public static RacingCar createConstantSpeedCar(String name, int speed) {
        return new RacingCar(name, new ConstantSpeedMovingStrategy(speed));
    }
}
