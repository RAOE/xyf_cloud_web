package course.system.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuyuanfeng
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String test() {
        return "success";
    }
}
