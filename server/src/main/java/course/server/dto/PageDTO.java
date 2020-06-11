package course.server.dto;

import lombok.Data;

import java.util.List;

/**
 * @author xuyuanfeng
 * @date 2020/6/11
 **/
@Data
public class PageDTO<T> {
    private int page;
    private Long total;
    private List<T> list;
}
