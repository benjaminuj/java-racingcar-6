package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Game {
    private final UserInput userInput;

    private static final int MIN_RUNNABLE_VALUE = 4;

    public Game(UserInput userInput) {
        this.userInput = userInput;
    }

    public void run(int attempsNumber) {
        for (int i = 0; i < attempsNumber; i++) {

            int randomNumber = Randoms.pickNumberInRange(0, 9);

            isRunnable(randomNumber);
        }

    }

    private boolean isRunnable(int randomNumber) {
        if (randomNumber >= MIN_RUNNABLE_VALUE) {
            return true;
        }
        return false;
    }


}
