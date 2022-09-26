package Medione.dao;

import Medione.pojo.Location;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName LocationDao
 * @Description mapper for data regarding location
 **/
@Mapper
public interface LocationDao extends BaseMapper<Location> {
}
