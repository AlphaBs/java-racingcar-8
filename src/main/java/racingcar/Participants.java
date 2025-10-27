package racingcar;

import java.util.List;
import java.util.function.Consumer;

public class Participants {
    private final List<RacingCar> participants;

    public Participants(List<RacingCar> participants) {
        if (participants.isEmpty()) {
            throw new IllegalArgumentException("경주할 차가 하나도 없습니다.");
        }
        this.participants = participants;
    }

    public void forEach(Consumer<RacingCar> action) {
        participants.forEach(action);
    }

    public int findMaxPosition() {
        return participants.stream()
            .mapToInt(RacingCar::getPosition)
            .max()
            .orElseThrow(() -> new IllegalStateException("잘못된 게임 상태"));
    }

    public List<RacingCar> findByPosition(int position) {
        return participants.stream()
            .filter(car -> car.getPosition() == position)
            .toList();
    }

    public List<RacingCar> toList() {
        return participants;
    }
}
