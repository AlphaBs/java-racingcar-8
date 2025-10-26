package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.moving.MovingStrategy;
import racingcar.moving.RandomlyMovingStrategy;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomlyMovingStrategyTest {
    @Test
    void 무작위_값이_4이상이면_한칸_전진한다() {
        // given
        MovingStrategy strategy = new RandomlyMovingStrategy();

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    int result = strategy.moveForward();
                    
                    // then
                    assertThat(result).isEqualTo(1);
                },
                4
        );
    }

    @Test
    void 무작위_값이_4미만이면_움직이지_않는다() {
        // given
        MovingStrategy strategy = new RandomlyMovingStrategy();

        assertRandomNumberInRangeTest(
                () -> {
                    // when
                    int result = strategy.moveForward();

                    // then
                    assertThat(result).isEqualTo(0);
                },
                3
        );
    }
}
