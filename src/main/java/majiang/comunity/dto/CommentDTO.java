package majiang.comunity.dto;

import lombok.Data;
import majiang.comunity.model.User;

/**
 * Created by lenovo on 2020/3/14.
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Integer commentCount;
    private String content;
    private User user;
}
