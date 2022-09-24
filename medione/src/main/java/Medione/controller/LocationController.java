package Medione.controller;

import Medione.pojo.Location;
import Medione.service.ILocationService;
import Medione.utils.RLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName
 * @Description
 **/
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private ILocationService service;

    @PutMapping
    public RLocation update(@RequestBody Location location){
        Boolean flag = service.modifyLocation(location);
        if(flag){
            return new RLocation(200);
        }else{
            return new RLocation(404);
        }

    }

    @DeleteMapping("/{locationid}")
    public RLocation delete(@PathVariable Integer locationid){
        Boolean flag  = service.deleteLocation(locationid);
        if(flag){
            return new RLocation(200);
        }else{
            return new RLocation(404);
        }
    }

    @GetMapping("/{locationid}")
    public RLocation getByLocationId(@PathVariable Integer locationid){
        Location location = service.getLocation(locationid);
        if(location != null){
            return new RLocation(200,location,"success!");
        }else {
            return new RLocation(404,null,"failed found location.");
        }
    }

    @PostMapping
    public RLocation create(@RequestBody Location location){
        return new RLocation(200,service.saveLocation(location));
    }

}
