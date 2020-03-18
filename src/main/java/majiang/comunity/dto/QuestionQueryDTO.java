package majiang.comunity.dto;

import lombok.Data;

/**
 * Created by lenovo on 2020/3/17.
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private Integer page;
    private Integer size;
}
