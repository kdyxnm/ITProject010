package Medione.service.impl;

import Medione.dao.LocationDao;
import Medione.pojo.Location;
import Medione.pojo.Medicine;
import Medione.service.ILocationService;
import Medione.service.IMedicineService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @ClassName LocationImpl
 * @Description implementation for location's service
 **/
@Service
public class LocationImpl extends ServiceImpl<LocationDao, Location> implements ILocationService {
    @Autowired
    private  LocationDao locationDao;
    @Autowired
    private IMedicineService medicineService;

    @Override
    public Boolean saveLocation(Location location) {
        return locationDao.insert(location) >0;
    }

    @Override
    public Boolean deleteLocation(Integer locationid) {
        Location location = locationDao.selectById(locationid);
        location.setEmail(" ");
        location.setAddress(" ");
        return locationDao.updateById(location)>0;
    }

    @Override
    public Boolean modifyLocation(Location location) {
        return locationDao.updateById(location) > 0;
    }

    @Override
    public Location getLocation(Integer locationid) {
        return locationDao.selectById(locationid);
    }

    @Override
    public List<Location> getAll(String email) {
        return locationDao.selectList(new QueryWrapper<Location>().eq("email", email));
    }



}
