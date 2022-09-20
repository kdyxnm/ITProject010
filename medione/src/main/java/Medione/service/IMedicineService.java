package Medione.service;

import Medione.pojo.Medicine;
import Medione.pojo.SimpleMessage;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface IMedicineService extends IService<Medicine> {
    Boolean saveMedicine(Medicine medicine);
    Boolean deleteMedicine(Integer id);
    Boolean modifyMedicine(Medicine medicine);
    Medicine getMedicine(Integer id);
    IPage<Medicine> getPage(int currentPage, int pageSize, String username);

    IPage<Medicine> getPage(int currentPage, int pageSize, Medicine medicine, String username);

    List<Integer> getOne(String brandname, Integer locationid, String username);

    List<Integer> getList(String brandname, String username);

    List<SimpleMessage> getSimpleMsgs(String username);

    String getNote(Integer id);

    Boolean modifyNote(Integer id, String note);
}
