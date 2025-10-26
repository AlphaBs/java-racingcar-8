package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<RacingCar> cars = List.of(RacingCar.createRandomlyMovingCar("hi"));
        RacingGame game = new RacingGame(cars, 5);
        while (!game.isGameOver()) {
            game.nextRound();
            System.out.println(cars.getFirst().getPosition());
        }
        List<RacingCar> winners = game.findWinners();
        for (RacingCar winner : winners) {
            System.out.println(winner.getName());
        }
    }
}
