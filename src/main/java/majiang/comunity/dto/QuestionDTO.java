package majiang.comunity.dto;

import lombok.Data;
import majiang.comunity.model.User;

/**
 * Created by lenovo on 2020/3/9.
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
