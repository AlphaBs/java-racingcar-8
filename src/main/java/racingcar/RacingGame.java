package racingcar;

import java.util.List;

public class RacingGame {
    private final Participants participants;
    private final int totalRounds; // 시도할 횟수
    private int currentRounds; // 시도한 횟수

    public RacingGame(Participants participants, int totalRounds) {
        this.participants = participants;
        this.totalRounds = totalRounds;
        validateStates();
    }

    private void validateStates() {
        if (this.totalRounds < 1) {
            throw new IllegalArgumentException("시도할 횟수는 양수이여야 합니다.");
        }
    }

    public void nextRound() {
        if (isGameOver()) {
            throw new IllegalStateException("게임이 종료되었습니다.");
        }

        participants.forEach(RacingCar::moveForward);
        currentRounds++;
    }

    public boolean isGameOver() {
        return currentRounds >= totalRounds;
    }

    public List<RacingCar> findWinners() {
        if (!isGameOver()) {
            throw new IllegalStateException("게임이 아직 끝나지 않았습니다");
        }

        // 가장 멀리 간 자동차랑 똑같은 위치의 모든 자동차 찾기
        int maxPosition = participants.findMaxPosition();
        return participants.findByPosition(maxPosition);
    }
}
