package majiang.comunity.service;

import majiang.comunity.mapper.UserMapper;
import majiang.comunity.model.User;
import majiang.comunity.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2020/3/11.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询数据库中AccountId，校验当前登录用户是否当前存在
     * 如果存在就更新该用户的Token
     * 不存在就将当前用户存放到db
     */

    public void createOrUpdate(User user) {
        //User dbUser = userMapper.findByAccountId(user.getAccountId());
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size() == 0){
            //插入
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }else{
            //更新
//            dbUser.setGmtModified(System.currentTimeMillis());
//            dbUser.setAvatarUrl(user.getAvatarUrl());
//            dbUser.setName(user.getName());
//            dbUser.setToken(user.getToken());
//            userMapper.update(dbUser);
            User dbUser = users.get(0);
            User updateUser = new User();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            UserExample example = new UserExample();
            example.createCriteria()
                    .andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(updateUser, example);
        }
    }
}
