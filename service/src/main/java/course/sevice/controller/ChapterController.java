package course.sevice.controller;

import course.server.service.ChapterService;
import course.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String queryAll() {
        return chapterService.queryAll().toString();
    }

}
