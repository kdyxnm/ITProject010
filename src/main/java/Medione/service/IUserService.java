package Medione.service;

import com.baomidou.mybatisplus.extension.service.IService;
import Medione.pojo.User;

/**
 * @ClassName IUserService
 * @Description service for user
 **/
public interface IUserService extends IService<User> {
    User getByName(String name);

    User blockPassword(User user);
}
