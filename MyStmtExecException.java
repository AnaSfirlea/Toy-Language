package Exceptions;

public class MyStmtExecException extends RuntimeException {
    private String message;

    public MyStmtExecException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "MyStmtExecException{" +
                "message='" + message + '\'' +
                '}';
    }
}
