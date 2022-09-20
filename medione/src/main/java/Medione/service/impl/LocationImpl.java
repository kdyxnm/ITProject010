package Medione.service.impl;

import Medione.dao.LocationDao;
import Medione.pojo.Location;
import Medione.service.ILocationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationImpl extends ServiceImpl<LocationDao, Location> implements ILocationService {
    @Autowired
    private  LocationDao locationDao;

    @Override
    public Boolean saveLocation(Location location) {
        return locationDao.insert(location) >0;
    }

    @Override
    public Boolean deleteLocation(Integer locationid) {
        return locationDao.deleteById(locationid) >0;
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
