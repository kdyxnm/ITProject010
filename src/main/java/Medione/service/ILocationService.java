package Medione.service;

import Medione.pojo.Location;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
/**
 * @ClassName ILocationService
 * @Description service for location
 **/
public interface ILocationService extends IService<Location> {
    Boolean saveLocation(Location location);
    Boolean deleteLocation(Integer locationid);
    Boolean modifyLocation(Location location);
    Location getLocation(Integer locationid);
    List<Location> getAll(String email);

}
