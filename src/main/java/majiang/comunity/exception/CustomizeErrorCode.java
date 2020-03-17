package majiang.comunity.exception;

/**
 * Created by lenovo on 2020/3/12.
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {

    QUESTION_NOT_FOUND(2001, "你找的问题不存在"),
    TARGET_PARAM_NOT_FOUND(2002, "未选中任何问题或评论"),
    NO_LOGIN(2003, "未登录，请先登录"),
    SYS_ERROR(2004, "服务器冒烟了，请稍等下再试试"),
    TYPE_PARAM_WRONG(2005, "评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006, "回复的评论不存在"),
    COMMENT_IS_EMPTY(2007, "输入内容不能为空"),
    READ_NOTIFICATION_FAILED(2008, "你无权限读取别人信息"),
    NOTIFICATION_NOT_FOUND(2009, "通知不存在吧")
    ;

    private Integer code;
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
