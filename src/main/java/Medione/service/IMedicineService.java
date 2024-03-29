package Medione.service;

import Medione.pojo.Medicine;
import Medione.pojo.SimpleMessage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.File;
import java.util.List;

/**
 * @ClassName IMedicineService
 * @Description service for medicine
 **/
public interface IMedicineService extends IService<Medicine> {
    Boolean saveMedicine(Medicine medicine);
    Boolean deleteMedicine(Integer id);
    Boolean modifyMedicine(Medicine medicine);
    Medicine getMedicine(Integer id);
    IPage<Medicine> getPage(int currentPage, int pageSize, String username);

    IPage<Medicine> getPage(int currentPage, int pageSize, Medicine medicine, String username);

    List<Medicine> getOne(String brandname, Integer locationid, String username);

    List<Medicine> getList(String brandname, String username);

    List<SimpleMessage> getSimpleMsgs(String username);

    String getNote(Integer id);

    Boolean modifyNote(Integer id, String note);

    Boolean takeMedicine(Integer id, Integer amount);

    void changeLocation(Integer locationid);


    List<Medicine> getListByLocation(Integer id);

}
