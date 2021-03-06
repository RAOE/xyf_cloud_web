package course.server.service;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import course.server.dto.PageDTO;
import course.server.mapper.ChapterMapper;
import course.server.model.Chapter;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xuyuanfeng
 * @date 2020/6/11
 **/
@Service
public class ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    public PageDTO<Chapter> queryAll(Integer page, Integer size) {
        //测试
        PageHelper.startPage(page, size);
        val queryWrapper = Wrappers.<Chapter>lambdaQuery();
        val list = chapterMapper.selectList(queryWrapper);
        PageInfo<Chapter> pageInfo = new PageInfo<Chapter>(list);
        PageDTO pageDTO = new PageDTO();
        pageDTO.setList(list);
        pageDTO.setPage(page);
        pageDTO.setSize(size);
        pageDTO.setTotal(pageInfo.getTotal());
        return pageDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void save(Chapter chapter) {
        if (!StringUtils.isEmpty(chapter.getId())) {
            update(chapter);
        } else {
            chapterMapper.insert(chapter);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void update(Chapter chapter) {
        chapterMapper.updateById(chapter);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(String id) {
        chapterMapper.deleteById(id);
    }
}
