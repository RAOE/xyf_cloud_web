package course.server.dto;

import lombok.Data;

import java.util.List;

/**
 * @author xuyuanfeng
 * @date 2020/6/11
 **/
@Data
public class PageDTO<T> {
    private Integer page;
    private Long total;
    private Integer size;
    private List<T> list;
}
