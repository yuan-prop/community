package majiang.comunity.dto;

import lombok.Data;

/**
 * Created by lenovo on 2020/3/12.
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
