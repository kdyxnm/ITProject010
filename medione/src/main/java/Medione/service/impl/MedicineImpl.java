package Medione.service.impl;

import Medione.dao.MedicineDao;
import Medione.pojo.Medicine;
import Medione.service.IMedicineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MedicineImpl extends ServiceImpl<MedicineDao, Medicine> implements IMedicineService {
}
