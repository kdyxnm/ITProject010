package Medione.controller;

import Medione.pojo.Medicine;
import Medione.service.IMedicineService;
import Medione.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private IMedicineService service;

    @PostMapping
    public R create(@RequestBody Medicine medicine){
        return new R(service.save(medicine));
    }

}
