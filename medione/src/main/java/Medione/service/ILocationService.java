package Medione.service;

import Medione.pojo.Location;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ILocationService extends IService<Location> {
    Boolean saveLocation(Location location);
    Boolean deleteLocation(Integer id);
    Boolean modifyLocation(Location location);
    Location getLocation(Integer id);
}
