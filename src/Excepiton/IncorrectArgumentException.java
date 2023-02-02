package Excepiton;

public class IncorrectArgumentException extends Exception {
    private final String arg;

    public IncorrectArgumentException(String arg) {
        this.arg = arg;
    }

    @Override
    public String getMessage() {
        return "Некорректные данные: " + arg;
    }
}
