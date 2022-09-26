package Medione.pojo;

import lombok.Data;

import java.util.List;
/**
 * @ClassName DashboardMessage
 * @Description simple java class for dashboard message
 **/
@Data
public class DashboardMessage {
    private String username;
    private String nickname;
    private String email;
    private List<Location> location;
    private List<SimpleMessage> simplemsg;


    public DashboardMessage(String username, String nickname, String email, List<Location> location, List<SimpleMessage> simplemsg){
        this.username = username;
        this.nickname = nickname;
        this.email = email;
        this.location = location;
        this.simplemsg = simplemsg;
    }
}
