package majiang.comunity.exception;

/**
 * Created by lenovo on 2020/3/12.
 */
public class CustomizeException extends RuntimeException{

    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode){
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
