package majiang.comunity.dto;

import lombok.Data;

/**
 * Created by lenovo on 2020/3/5.
 */
@Data //自动生成get set方法
public class AccessTokenDTO {

    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
