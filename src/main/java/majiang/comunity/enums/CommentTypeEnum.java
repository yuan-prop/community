package majiang.comunity.enums;

/**
 * Created by lenovo on 2020/3/13.
 */
public enum CommentTypeEnum {

    QUESTION(1),
    CONTENT(2);

    public Integer getType() {
        return type;
    }

    private Integer type;

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for(CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()){
            if(commentTypeEnum.getType() == type){
                return true;
            }
        }
        return false;
    }
}
