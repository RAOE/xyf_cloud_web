package course.server.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import course.server.dto.PageDTO;
import course.server.mapper.ChapterMapper;
import course.server.model.Chapter;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuyuanfeng
 * @date 2020/6/11
 **/
@Service
public class ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    public PageDTO<Chapter> queryAll() {
        PageHelper.startPage(1,2);
        val queryWrapper = Wrappers.<Chapter>lambdaQuery();
        val list =  chapterMapper.selectList(queryWrapper);
        PageInfo<Chapter> pageInfo = new PageInfo<Chapter>(list);
        PageDTO pageDTO = new PageDTO();
        pageDTO.setTotal(pageInfo.getTotal());
        pageDTO.setList(list);
        return pageDTO;
    }
}
