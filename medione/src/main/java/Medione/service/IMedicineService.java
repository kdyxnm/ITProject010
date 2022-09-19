package Medione.service;

import Medione.pojo.Medicine;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;


public interface IMedicineService extends IService<Medicine> {
    Boolean saveMedicine(Medicine medicine);
    Boolean deleteMedicine(Integer id);
    Boolean modifyMedicine(Medicine medicine);
    Medicine getMedicine(Integer id);
    IPage<Medicine> getPage(int currentPage, int pageSize, String username);

    IPage<Medicine> getPage(int currentPage, int pageSize, Medicine medicine, String username);

}
