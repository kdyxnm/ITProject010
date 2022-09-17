package Medione.service;

import Medione.pojo.Medicine;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;


public interface IMedicineService extends IService<Medicine> {
    Boolean saveMedicine(Medicine medicine);
    Boolean deleteMedicine(Integer id);
    Boolean modifyMedicine(Medicine medicine);
    Medicine getMedicine(Integer id);
}
