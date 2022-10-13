package Medione.controller;

import Medione.pojo.Medicine;
import Medione.pojo.Note;
import Medione.service.IMedicineService;
import Medione.utils.BaseContext;
import Medione.utils.R;
import Medione.utils.RMedicine;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;


/**
 * @ClassName MedicineController
 * @Description API regarding medicine define here
 **/
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
    public RMedicine getAll(@PathVariable Integer currentPage, @PathVariable Integer pageSize, HttpServletRequest request){
        IPage<Medicine> page = service.getPage(currentPage, pageSize, (String) request.getSession().getAttribute("username"));
        if(page != null){
            return new RMedicine(200,page,"success!");
        }else {
            return new RMedicine(404,null,"Wrong page range.");
        }
    }

    @GetMapping("/search/{brandname}/{locationid}")
    public RMedicine SearchOne(@PathVariable String brandname, @PathVariable Integer locationid, HttpServletRequest request){


        List<Medicine> searchData = service.getOne(brandname, locationid,(String) request.getSession().getAttribute("username"));
        if(searchData != null){
            return new RMedicine(200,searchData,"success!");
        }else {
            return new RMedicine(404,null,"No such item.");
        }

    }

    @GetMapping("/search/{brandname}")
    public RMedicine SearchList(@PathVariable String brandname, HttpServletRequest request){
        List<Medicine> searchData = service.getList(brandname, (String) request.getSession().getAttribute("username"));
        if(searchData != null){
            return new RMedicine(200,searchData,"success!");
        }else {
            return new RMedicine(404,null,"No such item.");
        }

    }

    @GetMapping("/note/{id}")
    public RMedicine getNote(@PathVariable Integer id){
        Note note = new Note();
        note.setNote(service.getNote(id));
        if(note!=null){
            return new RMedicine(200, note, "success!");
        }else {
            return new RMedicine(404, null, "error.");
        }
    }

    @PutMapping("/note/{id}")
    public RMedicine modifyNote(@RequestBody Note note, @PathVariable Integer id){
        String noteMsg = note.getNote();
        if(service.modifyNote(id, noteMsg)){
            return new RMedicine(200, null, "success!");
        }else {
            return new RMedicine(404, null, "error.");
        }
    }

    @GetMapping("/take/{id}/{amount}")
    public RMedicine takeMedicine(@PathVariable Integer id, @PathVariable Integer amount){
        if(service.takeMedicine(id, amount)){
            return new RMedicine(200, null, "success!");
        }else{
            return new RMedicine(404, null, "cannot take that much.");
        }
    }

    @PostMapping("/uploadImage")
    public RMedicine setImage(@RequestParam("image") MultipartFile image,HttpServletRequest request,
                              @RequestParam("id") Integer id) throws IOException {
        String path = "src/main/resources/static/userImage/";
        String type = image.getContentType();
        assert type != null;
        Medicine medicine = service.getMedicine(id);
        if (!type.contains("image")) {
            return new RMedicine(404, null, "file type error");
        }
        String username = (String) request.getSession().getAttribute("username");
        type = type.replace("image/","");
        String imagePath = username+"_"+medicine.getBrandname() + "." + type;

        File output = new File(path+imagePath);
        OutputStream outputStream = new FileOutputStream(output);
        outputStream.write(image.getBytes());
        outputStream.close();

        medicine.setImage("userImage/"+imagePath);
        service.modifyMedicine(medicine);
        return new RMedicine(200, medicine, "success!");
    }

}


