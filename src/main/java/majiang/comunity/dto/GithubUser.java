package majiang.comunity.dto;

import lombok.Data;

/**
 * Created by lenovo on 2020/3/5.
 */
@Data //自动生成get set方法
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;
}
