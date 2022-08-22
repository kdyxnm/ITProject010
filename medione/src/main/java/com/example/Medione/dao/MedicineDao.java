package com.example.Medione.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.Medione.pojo.Medicine;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MedicineDao extends BaseMapper<Medicine> {
}
