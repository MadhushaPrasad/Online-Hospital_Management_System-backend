package ik.ijse.hms.handler;


public class AppException extends RuntimeException {
    private int code;
    private String error;

    public AppException(String error) {
        super(error);
        this.error = error;
    }

    public AppException(int code, String error) {
        this.code = code;
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "AppException{" +
                "code=" + code +
                ", error='" + error + '\'' +
                '}';
    }
}
