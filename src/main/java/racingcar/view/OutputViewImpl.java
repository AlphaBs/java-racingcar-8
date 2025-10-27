package racingcar.view;

import java.io.PrintStream;
import java.util.List;
import racingcar.RacingCar;
import racingcar.RacingGame;

public class OutputViewImpl implements OutputView {
    private final PrintStream out;

    public OutputViewImpl(PrintStream out) {
        this.out = out;
    }

    @Override
    public void printGameStart() {
        out.println("\n실행 결과");
    }

    @Override
    public void printRoundResult(List<RacingCar> cars) {
        StringBuilder builder = new StringBuilder();
        for (RacingCar car : cars) {
            appendCarLine(builder, car);
        }
        out.println(builder);
        out.println();
    }

    @Override
    public void printGameResult(RacingGame game) {
        List<String> winnerNames = game.findWinners().stream()
            .map(RacingCar::getName)
            .toList();
        String winnersLine = String.join(", ", winnerNames);
        out.println("\n최종 우승자 : " + winnersLine);
    }

    private void appendCarLine(StringBuilder buffer, RacingCar car) {
        buffer.append(car.getName());
        buffer.append(" : ");
        buffer.append("-".repeat(car.getPosition()));
        buffer.append('\n');
    }
}
