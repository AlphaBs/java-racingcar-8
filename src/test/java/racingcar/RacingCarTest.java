package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import racingcar.moving.ConstantSpeedMovingStrategy;

class RacingCarTest {
    @Test
    void 이름을_5자_초과하는_자동차를_만들수_없다() {
        assertThatThrownBy(() -> new RacingCar("123456", new ConstantSpeedMovingStrategy(1)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
