package course.server.model;
import lombok.Data;

/**
 * @author xuyuanfeng
 * @date 2020/6/11
 **/
@Data
public class Chapter {
    private Long id;
    private String courseId;
    private String name;
}