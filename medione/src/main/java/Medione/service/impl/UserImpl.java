package Medione.service.impl;

import Medione.dao.UserDao;
import Medione.pojo.User;
import Medione.service.IMedicineService;
import Medione.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserImpl extends ServiceImpl<UserDao, User> implements IUserService {
}
