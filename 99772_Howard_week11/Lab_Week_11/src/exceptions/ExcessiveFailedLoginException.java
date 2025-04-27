package exceptions;

public class ExcessiveFailedLoginException extends Exception{
    public ExcessiveFailedLoginException() {
        super("anda mencapai jumlah batas login");
    }

    public ExcessiveFailedLoginException(String msg) {
        super(msg);
    }


}
