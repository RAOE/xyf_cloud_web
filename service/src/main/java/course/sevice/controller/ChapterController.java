package course.sevice.controller;

import com.google.common.collect.Maps;
import course.server.model.Chapter;
import course.server.service.ChapterService;
import course.service.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;


/**
 * @author xuyuanfeng
 * @date 2020/6/11
 **/
@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @PostMapping(value = "/queryAll")
    public Map<String, Object> queryAll(Integer page, Integer size) {
        Map<String, Object> resultMap = Maps.newHashMap();
        if (size == null || size == 0) {
            throw new RuntimeException("分页参数不正确");
        }
        page = Optional.ofNullable(page).orElse(1);
        resultMap.put("list", chapterService.queryAll(page, size));
        return resultMap;
    }

    @PostMapping(value = "/save")
    public void save(Chapter chapter) {
        chapterService.save(chapter);
    }

    @PostMapping(value = "/delete")
    public JsonResult delete(String id) {
        chapterService.deleteById(id);
        return JsonResult.ok();
    }
}
