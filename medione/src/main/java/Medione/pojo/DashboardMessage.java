package Medione.pojo;

import lombok.Data;

import java.util.List;

@Data
public class DashboardMessage {
    private String username;
    private String nickname;
    private String email;
    private List<SimpleMessage> simplemsg;
}
