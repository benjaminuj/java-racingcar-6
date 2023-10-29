package racingcar.domain;

public class UserInput {
    private String nameOfCars;
    private String[] carArray;

    public UserInput(String nameOfCars) {
        this.nameOfCars = nameOfCars;
    }

    public String[] getCarArray() {
        return carArray;
    }

    public void checkValidity() {
        if (isStringEmpty(nameOfCars)) {
            throw new IllegalArgumentException("Input value cannot be blank.");
        }

        if (!isContainComma(nameOfCars)) {
            throw new IllegalArgumentException(
                    "There must be two or more cars, and each car must be separated by a comma.");
        }

        for (int i = 0; i < carArray.length; i++) {
            String name = carArray[i];

            if (isStringEmpty(name)) {
                throw new IllegalArgumentException("None of the names can be blank.");
            }

            if (name.length() >= 6) {
                throw new IllegalArgumentException("The length of the name must be 5 or less.");
            }

            for (int c = 0; c < name.length(); c++) {
                if (isAlphabet(name.charAt(c)) || isNumber(name.charAt(c)) || isHyphenSign(name.charAt(c))) {
                    continue;
                }

                throw new IllegalArgumentException(
                        "Only English letters, numbers, and '-' symbol are allowed in the name.");
            }
        }
    }

    private boolean isStringEmpty(String string) {
        return string == null || string.isBlank();
    }

    private boolean isContainComma(String input) {
        carArray = input.split(",", -1);

        if (carArray.length == 1) {
            return false;
        }

        return true;
    }

    private boolean isAlphabet(char c) {
        if ((65 <= c && c <= 90) || (97 <= c && c <= 122)) {
            return true;
        }

        return false;
    }

    private boolean isNumber(char c) {
        if (48 <= c && c <= 57) {
            return true;
        }

        return false;
    }

    private boolean isHyphenSign(char c) {
        if (c == 45) {
            return true;
        }

        return false;
    }
}