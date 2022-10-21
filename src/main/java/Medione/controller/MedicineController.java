package Medione.controller;

import Medione.pojo.DetailMessage;
import Medione.pojo.Medicine;
import Medione.pojo.Note;
import Medione.service.ILocationService;
import Medione.service.IMedicineService;
import Medione.utils.BaseContext;
import Medione.utils.R;
import Medione.utils.RDashboard;
import Medione.utils.RMedicine;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
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
    @Autowired
    private ILocationService locationService;

    /**create a new medicine
     * @param medicine a medicine object
     * @return creation result
     */
    @PostMapping
    public RMedicine create(@RequestBody Medicine medicine){
        service.saveMedicine(medicine);

        return new RMedicine(200, medicine.getId());
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
    public RMedicine setImage(@RequestParam("image") MultipartFile file,HttpServletRequest request) throws Exception {
        if (file.isEmpty()) {

            throw new Exception();
        }
        String filePath = System.getProperty("user.dir");
        String type = file.getContentType();
        assert type != null;
        String username = (String) request.getSession().getAttribute("username");
        type = type.replace("image/","");
        Integer id = service.list().size() + 1;
        String imagePath = "/"+username+"_"+ id + "." + type;
        System.out.println("size: " + file.getSize());

        File upload = new File(filePath + File.separator + "view" + File.separator);
        if (!upload.exists()) {
            upload.mkdirs();
        }
        File dest = new File(filePath + File.separator +  "view" +  File.separator + imagePath);
        try {
            file.transferTo(dest);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("================================================");
        System.out.println("directory: "+upload);
        System.out.println("userImage can write? " + upload.canWrite());
        System.out.println("userImage all file: " );
        for (File f:upload.listFiles()
        ) {
            System.out.println(f);
        }
        System.out.println("================================================");



        return new RMedicine(200, dest.getAbsolutePath(), "success!");
    }

//    @PostMapping("/uploadImage")
//    public RMedicine setImage(@RequestParam("image") MultipartFile image,HttpServletRequest request) throws IOException {
////        String path = "target/classes/static/userImage/";   //server
//        //String path = ""; //local
//        String type = image.getContentType();
//        assert type != null;
//
//        //find path
//        ApplicationHome h = new ApplicationHome(getClass());
//        File jarF = h.getSource();
//
//        String dirPath = jarF.getParentFile().toString()+"/medicine/";
////        File userImage = new File("/app/target/classes/static/userImage/");
//        File targetDir = new File(dirPath);
//        File baseUrl = new File("/app/");
//
//        boolean res = targetDir.mkdir();
//        System.out.println("================================================");
//        System.out.println("baseUrl: "+baseUrl);
//        System.out.println("baseUrl can write? " + baseUrl.canWrite());
//        System.out.println("baseUrl all file: " );
//        for (File f:baseUrl.listFiles()
//        ) {
//            System.out.println(f);
//        }
//        System.out.println("================================================");
//
//
////        File directory = new File(dirPath);
////        boolean res = directory.mkdir();
////        System.out.println("================================================");
////        System.out.println("directory: "+directory);
////        System.out.println("userImage can write? " + directory.canWrite());
////        System.out.println("userImage all file: " + directory.listFiles());
////        System.out.println("================================================");
////
////
////        if(res) {
////            System.out.println("The directory has been created.");
////        }
////        else {
////            System.out.println("The directory already exists.");
////        }
//
//        if (!type.contains("image")) {
//            return new RMedicine(404, null, "file type error");
//        }
//        //naming
//        String username = (String) request.getSession().getAttribute("username");
//        type = type.replace("image/","");
//        Integer id = service.list().size() + 1;
//        String imagePath = "/"+username+"_"+ id + "." + type;
//        System.out.println("size: " + image.getSize());
//
//        //put in
//        System.out.println("image path: "+ targetDir+imagePath);
//        //===
//        File output = new File(targetDir+imagePath);
//        OutputStream outputStream = new FileOutputStream(output);
//        outputStream.write(image.getBytes());
//        outputStream.close();
//        //==
//
//
//        System.out.println("upload success");
//        for (File f:targetDir.listFiles()
//             ) {
//            System.out.println(f);
//        }
//        System.out.println("================================================");
//        File newFile = new File(targetDir+imagePath);
//        System.out.println("new file: "+newFile);
//        System.out.println("can read? "+newFile.canRead());
//        System.out.println("absolute :"+newFile.getAbsolutePath());
//        System.out.println("length: "+ newFile.length());
//        System.out.println("hidden? " + newFile.isHidden());
//        newFile.getAbsolutePath();
//        System.out.println("================================================");
//        return new RMedicine(200, "medicine"+imagePath, "success!");
//    }

    @GetMapping("/detail/{id}")
    public RDashboard getDetail(@PathVariable Integer id){
        Medicine medicine = service.getById(id);
        String brandname = medicine.getBrandname();
        String image = medicine.getImage();
        Integer quantity = medicine.getQuantity();
        String validity  = medicine.getValidity();
        Integer dosage = medicine.getDosage();
        String dosagetype = medicine.getDosagetype();
        String quantitytype = medicine.getQuantitytype();
        String manufacturername = medicine.getManufacturername();
        String genericname = medicine.getGenericname();
        String producttype = medicine.getProducttype();
        String route = medicine.getRoute();
        String description = medicine.getDescription();
        String usage = medicine.getUsage();
        String warnings = medicine.getWarnings();
        String contraindications = medicine.getContraindications();
        String adversereaction = medicine.getAdversereaction();
        String overdosage = medicine.getOverdosage();
        String username = medicine.getUsername();
        Integer locationid = medicine.getLocationid();
        String note = medicine.getNote();
        String location = locationService.getLocation(locationid).getAddress();
        DetailMessage detailMessage = new DetailMessage(id,brandname,image,quantity,validity,dosage,
                dosagetype,quantitytype,manufacturername,genericname,producttype,route,description,
                usage,warnings,contraindications,adversereaction,overdosage,username,locationid,note,
                location);
        if(detailMessage != null){
            return new RDashboard(200, detailMessage, "success!");
        }
        else {
            return new RDashboard(404, null, "error.");
        }

    }

}


