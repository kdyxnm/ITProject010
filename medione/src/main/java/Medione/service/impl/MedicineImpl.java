package Medione.service.impl;

import Medione.dao.MedicineDao;
import Medione.pojo.Medicine;
import Medione.service.IMedicineService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Override
    public IPage<Medicine> getPage(int currentPage, int pageSize, String username) {
        IPage page = new Page(currentPage,pageSize);
        medicineDao.selectPage(page,new QueryWrapper<Medicine>().eq("username", username));
        return page;
    }

    @Override
    public IPage<Medicine> getPage(int currentPage, int pageSize, Medicine medicine, String username) {
        return null;
    }
}
