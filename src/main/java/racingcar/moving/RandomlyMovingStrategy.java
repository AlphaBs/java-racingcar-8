package racingcar.moving;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomlyMovingStrategy implements MovingStrategy {
    private static final int THRESHOLD = 4;

    @Override
    public int moveForward() {
        int value = Randoms.pickNumberInRange(0, 9);
        if (value < THRESHOLD) {
            return 0;
        }
        return 1;
    }
}
