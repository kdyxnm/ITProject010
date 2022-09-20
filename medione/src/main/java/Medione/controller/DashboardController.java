package Medione.controller;


import Medione.pojo.DashboardMessage;
import Medione.pojo.Location;
import Medione.pojo.Medicine;
import Medione.pojo.SimpleMessage;
import Medione.service.ILocationService;
import Medione.service.IMedicineService;
import Medione.service.IUserService;
import Medione.utils.BaseContext;
import Medione.utils.RDashboard;
import Medione.utils.RLocation;
import Medione.utils.RMedicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    @Autowired
    private ILocationService locationService;
    @Autowired
    private IMedicineService medicineService;
    @Autowired
    private IUserService userService;


    @GetMapping
    public RDashboard getDashboardMsg(HttpServletRequest request){
//        String username = "zisu1";  //写死测试
        String username = (String) request.getSession().getAttribute("username");
        String email = userService.getByName(username).getEmail();
        String nickname = userService.getByName(username).getNickname();
        List<Location> locations = locationService.getAll(email);
        List<SimpleMessage> simpleMessages = medicineService.getSimpleMsgs(username);
        DashboardMessage dashboardMessage = new DashboardMessage(username, nickname, email, locations, simpleMessages);
        System.out.println("==================================");
        System.out.println("dashboardmsg: "+ dashboardMessage);
        if(dashboardMessage != null){
            return new RDashboard(200, dashboardMessage, "success!");
        }
        else {
            return new RDashboard(404, null, "error.");
        }
    }


}
