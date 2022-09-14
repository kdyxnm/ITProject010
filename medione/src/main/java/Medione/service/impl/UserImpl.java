package Medione.service.impl;

import Medione.dao.UserDao;
import Medione.pojo.User;
import Medione.service.IMedicineService;
import Medione.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserImpl extends ServiceImpl<UserDao, User> implements IUserService {
    @Autowired
    UserDao userDao;

    @Cacheable(value="session", key = "#user")
    public String setSession(User user, HttpSession session){
        return session.getId();
    }

    public User getByName(String name){
        QueryWrapper<User>  userWrapper = new QueryWrapper<>();
        userWrapper.eq("username",name);
        return userDao.selectOne(userWrapper);
    }
}
