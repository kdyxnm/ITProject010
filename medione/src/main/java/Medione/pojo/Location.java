package Medione.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("location")
public class Location {
    private Integer locationId;
    private String email;
    private String location;
}
