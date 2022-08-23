package Medione.dao;

import Medione.pojo.Medicine;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MedicineDao extends BaseMapper<Medicine> {
}
