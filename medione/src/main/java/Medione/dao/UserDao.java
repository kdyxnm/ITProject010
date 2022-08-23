package Medione.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import Medione.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
