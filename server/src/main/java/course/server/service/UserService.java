package course.server.service;
import course.server.mapper.UserMapper;
import course.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author xuyuanfeng
 * @date 2020/6/10
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> queryAll() {
        return userMapper.selectList(null);
    }
}
