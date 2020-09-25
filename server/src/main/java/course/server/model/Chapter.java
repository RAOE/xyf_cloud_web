package course.server.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author xuyuanfeng
 * @date 2020/6/11
 **/
@Data
public class Chapter {
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    private String courseId;
    private String name;
}
