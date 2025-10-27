package racingcar;

import racingcar.moving.MovingStrategy;

public class RacingCar {
    private static final int MAX_CAR_NAME = 5;

    private final MovingStrategy movingStrategy;
    private final String name;
    private int position;

    public RacingCar(String name, MovingStrategy movingStrategy) {
        this.name = name;
        if (name.length() > MAX_CAR_NAME) {
            throw new IllegalArgumentException("자동차 이름의 길이는 " + MAX_CAR_NAME + "자 까지만 설정할 수 있습니다.");
        }

        this.movingStrategy = movingStrategy;
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
