package Medione.pojo;

import lombok.Data;
import org.apache.ibatis.cache.decorators.BlockingCache;
@Data
public class SimpleMassage {
    private Integer id;
    private String brandname;
    private Integer locationid;
    private String location;
}
