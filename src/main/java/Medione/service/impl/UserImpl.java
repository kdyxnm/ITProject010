package Medione.service.impl;

import Medione.dao.UserDao;
import Medione.pojo.User;
import Medione.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @ClassName UserImpl
 * @Description implementation for user's service
 **/
@Service
public class UserImpl extends ServiceImpl<UserDao, User> implements IUserService {
    @Autowired
    UserDao userDao;


    public User getByName(String name){
        QueryWrapper<User>  userWrapper = new QueryWrapper<>();
        userWrapper.eq("username",name);
        return userDao.selectOne(userWrapper);
    }

    @Override
    public User getByEmail(String email) {
        QueryWrapper<User>  userWrapper = new QueryWrapper<>();
        userWrapper.eq("email",email);
        return userDao.selectOne(userWrapper);
    }

    public User blockPassword(User user){
        User noPassword = new User();
        noPassword.setEmail(user.getEmail());
        noPassword.setNickname(user.getNickname());
        noPassword.setUsername(user.getUsername());
        return noPassword;
    }


}

