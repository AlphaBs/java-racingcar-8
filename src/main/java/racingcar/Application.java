package racingcar;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.InputViewImpl;
import racingcar.view.OutputView;
import racingcar.view.OutputViewImpl;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputViewImpl(System.out);
        OutputView outputView = new OutputViewImpl(System.out);

        List<String> carNames = inputView.readCarNames();
        List<RacingCar> cars = carNames.stream()
            .map(RacingCars::createRandomlyMovingCar)
            .toList();
        Participants participants = new Participants(cars);

        int rounds = inputView.readRounds();
        RacingGame game = new RacingGame(participants, rounds);
        outputView.printGameStart();

        while (!game.isGameOver()) {
            game.nextRound();
            outputView.printRoundResult(participants.toList());
        }

        outputView.printGameResult(game);
    }
}
