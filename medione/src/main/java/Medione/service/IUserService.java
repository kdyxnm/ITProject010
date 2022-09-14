package Medione.service;

import com.baomidou.mybatisplus.extension.service.IService;
import Medione.pojo.User;
import org.springframework.stereotype.Service;


public interface IUserService extends IService<User> {
    User getByName(String name);
}
