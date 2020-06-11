package course.server.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import course.server.mapper.ChapterMapper;
import course.server.model.Chapter;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuyuanfeng
 * @date 2020/6/11
 **/
@Service
public class ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    public List<Chapter> queryAll() {
        val queryWrapper = Wrappers.<Chapter>lambdaQuery().eq(Chapter::getId,"1");
        return chapterMapper.selectList(queryWrapper);
    }
}
