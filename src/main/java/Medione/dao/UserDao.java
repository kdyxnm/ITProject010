package Medione.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import Medione.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName UserDao
 * @Description mapper for data regarding user
 **/
@Mapper
public interface UserDao extends BaseMapper<User> {
}
