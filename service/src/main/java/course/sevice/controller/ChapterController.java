package course.sevice.controller;
import com.google.common.collect.Maps;
import course.server.dto.PageDTO;
import course.server.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


/**
 * @author xuyuanfeng
 * @date 2020/6/11
 **/
@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("/queryAll")
    public Map<String,Object> queryAll(PageDTO pageDTO) {
        Map<String,Object> resultMap = Maps.newHashMap();
        resultMap.put("list",chapterService.queryAll(pageDTO));
        return resultMap;
    }
}
