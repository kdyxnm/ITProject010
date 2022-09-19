package Medione.pojo;

import lombok.Data;

import java.util.List;

@Data
public class DashboardMassage {
    private String username;
    private String nickname;
    private String email;
    private List<SimpleMassage> simplemsg;
}
