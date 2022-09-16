package Medione.controller;

import Medione.pojo.Medicine;
import Medione.service.IMedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public List<Medicine> getAll (){
        return service.list();
    }
   // @PostMapping("upload")
    //public R createImage(@RequestBody Blob image){

    }


