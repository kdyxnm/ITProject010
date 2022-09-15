package Medione.controller;

import Medione.pojo.Medicine;
import Medione.service.IMedicineService;
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

    /**create a new medicine
     * @param medicine a medicine object
     * @return creation result
     */
    @PostMapping
    public boolean create(@RequestBody Medicine medicine){
        return service.saveMedicine(medicine);
    }

   // @PostMapping("upload")
    //public R createImage(@RequestBody Blob image){

    }


