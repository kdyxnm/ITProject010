package Medione.service.impl;

import Medione.dao.MedicineDao;
import Medione.pojo.Medicine;
import Medione.pojo.SimpleMessage;
import Medione.service.IMedicineService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MedicineImpl
 * @Description implementation for medicine's service
 **/
@Service
public class MedicineImpl extends ServiceImpl<MedicineDao, Medicine> implements IMedicineService {
    @Autowired
    private MedicineDao medicineDao;
    @Override
    public Boolean saveMedicine(Medicine medicine) {

        return medicineDao.insert(medicine) > 0;
    }

    @Override
    public Boolean deleteMedicine(Integer id) {
        return medicineDao.deleteById(id) > 0;
    }

    @Override
    public Boolean modifyMedicine(Medicine medicine) {
        return medicineDao.updateById(medicine) > 0;
    }

    @Override
    public Medicine getMedicine(Integer id) {
        return medicineDao.selectById(id);
    }

    @Override
    public IPage<Medicine> getPage(int currentPage, int pageSize, String username) {
        IPage<Medicine> page = new Page<>(currentPage,pageSize);
        medicineDao.selectPage(page,new QueryWrapper<Medicine>().eq("username", username));
        return page;
    }

    @Override
    public IPage<Medicine> getPage(int currentPage, int pageSize, Medicine medicine, String username) {
        return null;
    }

    @Override
    public List<Medicine> getOne(String brandname, Integer locationid, String username) {
        List<Medicine> list;
        List<Integer> ans  = new ArrayList<Integer>();
        QueryWrapper<Medicine> queryWrapper  = new QueryWrapper<Medicine>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("brandname", brandname);
        queryWrapper.eq("locationid", locationid);
        list = medicineDao.selectList(queryWrapper);
        return list;
    }

    @Override
    public List<Medicine> getList(String brandname, String username) {
        List<Medicine> list;
        List<Integer> ans  = new ArrayList<Integer>();
        QueryWrapper<Medicine> queryWrapper  = new QueryWrapper<Medicine>();
        queryWrapper.eq("username", username);
        queryWrapper.like("brandname", brandname);
        list  = medicineDao.selectList(queryWrapper);

        if(list.size() <= 5) {
            return list;
        }else{
            return list.subList(0,5);
        }
    }

    @Override
    public List<SimpleMessage> getSimpleMsgs(String username) {
        List<Medicine> list;
        QueryWrapper<Medicine> queryWrapper = new QueryWrapper<Medicine>();
        queryWrapper.eq("username", username);
        list = medicineDao.selectList(queryWrapper);

        List<SimpleMessage> simpleMessages = new ArrayList<SimpleMessage>();
        for(Medicine medicine : list){
            SimpleMessage simpleMessage = new SimpleMessage(medicine.getId(), medicine.getBrandname(),medicine.getLocationid());
            System.out.println(simpleMessage);
            simpleMessages.add(simpleMessage);
        }
        return simpleMessages;
    }

    @Override
    public String getNote(Integer id) {
        Medicine medicine = medicineDao.selectById(id);
        return medicine.getNote();
    }

    @Override
    public Boolean modifyNote(Integer id, String note) {
        Medicine medicine = medicineDao.selectById(id);
        medicine.setNote(note);
        return medicineDao.updateById(medicine)>0;
    }

    @Override
    public Boolean takeMedicine(Integer id, Integer amount) {
        Medicine medicine = medicineDao.selectById(id);
        Integer remain = medicine.getQuantity() - amount;
        if(remain >= 0){
            medicine.setQuantity(remain);
            medicineDao.updateById(medicine);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public void changeLocation(Integer locationid) {
        List<Medicine> list;
        QueryWrapper<Medicine> queryWrapper = new QueryWrapper<Medicine>();
        queryWrapper.eq("locationid", locationid);
        list = medicineDao.selectList(queryWrapper);

        for(Medicine medicine: list){
            medicine.setLocationid(-2);
            medicineDao.updateById(medicine);
        }
    }


}
