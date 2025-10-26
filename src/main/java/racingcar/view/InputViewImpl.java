package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class InputViewImpl implements InputView {
    private final PrintStream promptOutput;

    public InputViewImpl(PrintStream promptOutput) {
        this.promptOutput = promptOutput;
    }

    public List<String> readCarNames() {
        promptOutput.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().split(",");
        return Arrays.asList(names);
    }

    public int readRounds() {
        try {
            promptOutput.println("시도할 횟수는 몇 회인가요?");
            return Integer.parseInt(Console.readLine());
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수로 정수를 입력하세요.");
        }
    }
}
