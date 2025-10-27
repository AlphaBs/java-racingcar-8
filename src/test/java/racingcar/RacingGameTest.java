package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameTest {
    @Test
    void 자동차가_없는_게임은_불가능하다() {
        List<RacingCar> cars = List.of();
        assertThatThrownBy(() -> new Participants(cars))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도횟수를_음수로_설정한_게임은_불가능하다() {
        List<RacingCar> cars = List.of(
            RacingCars.createConstantSpeedCar("pobi", 1),
            RacingCars.createConstantSpeedCar("woni", 1)
        );
        Participants participants = new Participants(cars);
        assertThatThrownBy(() -> new RacingGame(participants, -1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 한_라운드_진행() {
        // given
        List<RacingCar> cars = List.of(
            RacingCars.createConstantSpeedCar("pobi", 2),
            RacingCars.createConstantSpeedCar("woni", 4)
        );
        Participants participants = new Participants(cars);
        RacingGame game = new RacingGame(participants, 1);

        // when
        game.nextRound();

        // then
        assertThat(cars.get(0).getPosition()).isEqualTo(2);
        assertThat(cars.get(1).getPosition()).isEqualTo(4);
    }

    @Test
    void 여러_라운드_진행() {
        // given
        List<RacingCar> cars = List.of(
            RacingCars.createConstantSpeedCar("pobi", 2),
            RacingCars.createConstantSpeedCar("woni", 4)
        );
        Participants participants = new Participants(cars);
        RacingGame game = new RacingGame(participants, 3);

        // when
        game.nextRound();
        game.nextRound();

        // then
        assertThat(cars.get(0).getPosition()).isEqualTo(4);
        assertThat(cars.get(1).getPosition()).isEqualTo(8);
    }

    @Test
    void 게임종료_후_라운드진행_불가() {
        // given
        List<RacingCar> cars = List.of(RacingCars.createConstantSpeedCar("pobi", 1));
        Participants participants = new Participants(cars);
        RacingGame game = new RacingGame(participants, 1);

        // when
        game.nextRound();

        // then
        assertThatThrownBy(game::nextRound)
            .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 횟수만큼_진행하기_전까지_게임진행상태를_유지한다() {
        // given
        List<RacingCar> cars = List.of(RacingCars.createConstantSpeedCar("pobi", 1));
        Participants participants = new Participants(cars);
        RacingGame game = new RacingGame(participants, 2);

        // when
        game.nextRound();

        // then
        assertThat(game.isGameOver()).isFalse();
    }

    @Test
    void 횟수만큼_진행후_게임을_종료한다() {
        // given
        List<RacingCar> cars = List.of(RacingCars.createConstantSpeedCar("pobi", 1));
        Participants participants = new Participants(cars);
        RacingGame game = new RacingGame(participants, 2);

        // when
        game.nextRound();
        game.nextRound();

        // then
        assertThat(game.isGameOver()).isTrue();
    }

    @Test
    void 게임종료후_단일_우승자_결정() {
        // given
        List<RacingCar> cars = List.of(
            RacingCars.createConstantSpeedCar("pobi", 1),
            RacingCars.createConstantSpeedCar("woni", 0),
            RacingCars.createConstantSpeedCar("juni", 0)
        );
        Participants participants = new Participants(cars);
        RacingGame game = new RacingGame(participants, 1);

        // when
        game.nextRound();
        List<RacingCar> winners = game.findWinners();

        // then
        assertThat(winners).hasSize(1);
        assertThat(winners.getFirst().getName()).isEqualTo("pobi");
    }

    @Test
    void 게임종료후_여러_우승자_결정() {
        // given
        List<RacingCar> cars = List.of(
            RacingCars.createConstantSpeedCar("pobi", 1),
            RacingCars.createConstantSpeedCar("woni", 0),
            RacingCars.createConstantSpeedCar("juni", 1)
        );
        Participants participants = new Participants(cars);
        RacingGame game = new RacingGame(participants, 1);

        // when
        game.nextRound();
        List<RacingCar> winners = game.findWinners();

        // then
        assertThat(winners).extracting(RacingCar::getName)
            .containsExactlyInAnyOrder("pobi", "juni");
    }

    @Test
    void 게임종료전_우승자결정은_불가능하다() {
        // given
        List<RacingCar> cars = List.of(RacingCars.createConstantSpeedCar("pobi", 1));
        Participants participants = new Participants(cars);
        RacingGame game = new RacingGame(participants, 2);

        // when
        game.nextRound();

        // then
        assertThatThrownBy(game::findWinners)
            .isInstanceOf(IllegalStateException.class);
    }
}
