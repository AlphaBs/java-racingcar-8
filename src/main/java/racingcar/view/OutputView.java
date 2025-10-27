package racingcar.view;

import java.util.List;
import racingcar.RacingCar;
import racingcar.RacingGame;

public interface OutputView {
    void printGameStart();

    void printRoundResult(List<RacingCar> cars);

    void printGameResult(RacingGame game);
}
