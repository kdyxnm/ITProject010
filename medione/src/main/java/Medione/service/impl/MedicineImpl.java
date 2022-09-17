package Medione.service.impl;

import Medione.dao.MedicineDao;
import Medione.pojo.Medicine;
import Medione.service.IMedicineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
