package Medione.controller;


import Medione.pojo.Location;
import Medione.pojo.Medicine;
import Medione.service.impl.LocationImpl;
import Medione.service.impl.MedicineImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @ClassName DataGeneratorController
 * @Description generate random testing data
 **/
@RestController
@RequestMapping("/generator")
public class DataGeneratorController {
    @Autowired
    MedicineImpl service;

    @Autowired
    LocationImpl locationService;

    Random random = new Random();

    @PostMapping("medicine")
    public void generateMedicine() {
        for (int i = 1; i < 20; i++) {
            Medicine medicine = new Medicine();
            medicine.setBrandname("brand " + i);
            medicine.setQuantity(i);
            medicine.setUsername("zisu1");
            medicine.setLocationid(random.nextInt(4));
            service.saveMedicine(medicine);
        }
    }

    @PostMapping("location")
    public void generateLocation() {
        for (int i = 1; i < 10; i++) {
            Location location = new Location();
            location.setAddress(String.valueOf(i));
            location.setEmail("570636077@qq.com");
            locationService.saveLocation(location);
        }
    }
}
