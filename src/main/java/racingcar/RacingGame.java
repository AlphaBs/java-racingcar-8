package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RacingGame {
    private final List<RacingCar> cars;
    private final int totalRounds; // 시도할 횟수
    private int currentRounds; // 시도한 횟수

    public RacingGame(List<RacingCar> cars, int totalRounds) {
        this.cars = cars;
        this.totalRounds = totalRounds;
        validateStates();
    }

    private void validateStates() {
        if (this.totalRounds < 1) {
            throw new IllegalArgumentException("시도할 횟수는 양수이여야 합니다.");
        }
        if (this.cars.isEmpty()) {
            throw new IllegalArgumentException("경주할 차가 하나도 없습니다.");
        }
    }

    public void nextRound() {
        if (isGameOver()) {
            throw new IllegalStateException("게임이 종료되었습니다.");
        }

        for (RacingCar car : cars) {
            car.moveForward();
        }

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
        int maxPosition = findMaxPosition();
        return findCarsByPosition(maxPosition);
    }

    private int findMaxPosition() {
        // cars 는 반드시 하나 이상의 자동차를 가지기에, orElseThrow 가 발생할 일이 없음
        return this.cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("잘못된 게임 상태"));
    }

    private List<RacingCar> findCarsByPosition(int position) {
        return this.cars.stream()
                .filter(car -> car.getPosition() == position)
                .toList();
    }
}
