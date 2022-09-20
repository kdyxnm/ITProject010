package Medione.controller;

import Medione.pojo.Medicine;
import Medione.service.IMedicineService;
import Medione.utils.BaseContext;
import Medione.utils.RMedicine;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080/")
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
    public RMedicine create(@RequestBody Medicine medicine){
        return new RMedicine(200,service.saveMedicine(medicine));
    }
    @GetMapping
    public RMedicine getAll (){
        return new RMedicine(200,service.list());
    }
   // @PostMapping("upload")
    //public R createImage(@RequestBody Blob image){

    @PutMapping
    public RMedicine update(@RequestBody Medicine medicine){
        Boolean flag = service.modifyMedicine(medicine);
        if(flag){
            return new RMedicine(200);
        }else{
            return new RMedicine(404);
        }
    }

    @DeleteMapping("/{id}")
    public RMedicine delete(@PathVariable Integer id){
        Boolean flag  = service.deleteMedicine(id);
        if(flag){
            return new RMedicine(200);
        }else{
            return new RMedicine(404);
        }
    }

    @GetMapping("/{id}")
    public RMedicine getById(@PathVariable Integer id){
        Medicine medicine = service.getMedicine(id);
        if(medicine != null){
            return new RMedicine(200,medicine,"success!");
        }else {
            return new RMedicine(404,null,"failed found medicine.");
        }
    }

    @GetMapping("/page/{currentPage}/{pageSize}")
    public RMedicine getAll(@PathVariable Integer currentPage, @PathVariable Integer pageSize){
        IPage<Medicine> page = service.getPage(currentPage, pageSize, BaseContext.getCurrentUser().getUsername());
        if(page != null){
            return new RMedicine(200,page,"success!");
        }else {
            return new RMedicine(404,null,"Wrong page range.");
        }
    }

    @GetMapping("/search/{brandname}/{locationid}")
    public RMedicine SearchOne(@PathVariable String brandname, @PathVariable Integer locationid){


        List<Integer> searchData = service.getOne(brandname, locationid, BaseContext.getCurrentUser().getUsername());
        if(searchData != null){
            return new RMedicine(200,searchData,"success!");
        }else {
            return new RMedicine(404,null,"No such item.");
        }

    }

    @GetMapping("/search/{brandname}")
    public RMedicine SearchList(@PathVariable String brandname){
        List<Integer> searchData = service.getList(brandname, BaseContext.getCurrentUser().getUsername());
        if(searchData != null){
            return new RMedicine(200,searchData,"success!");
        }else {
            return new RMedicine(404,null,"No such item.");
        }

    }

}


