package course.server.model;

import lombok.Data;

/**
 * @author xuyuanfeng
 * @date 2020/6/10
 **/
@Data
public class User {
    private Long id;
    private String name;
    private String age;
    private String email;
}
