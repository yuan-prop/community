package majiang.comunity.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by lenovo on 2020/3/16.
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
