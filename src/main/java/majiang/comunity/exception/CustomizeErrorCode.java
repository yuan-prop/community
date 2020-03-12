package majiang.comunity.exception;

/**
 * Created by lenovo on 2020/3/12.
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND("你找的问题不存在");

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    CustomizeErrorCode(String message){
        this.message = message;
    }
}
