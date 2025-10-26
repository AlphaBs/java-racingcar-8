package racingcar.view;

import racingcar.RacingCar;
import racingcar.RacingGame;

import java.util.List;

public interface OutputView {
    void printGameStart();

    void printRoundResult(List<RacingCar> cars);

    void printGameResult(RacingGame game);
}
