package Medione.utils;


import lombok.Data;
/**
 * @ClassName
 * @Description
 **/
@Data
public class RDashboard {
    private Integer status;
    private String msg;
    private Object data;


    public RDashboard() {}

    public RDashboard(Integer status){
        this.status = status;
        if (status == 200){
            msg = "success!";
        }else{
            msg = "error.";
        }
    }

    public RDashboard(Integer status, Object data){
        this.status = status;
        this.data = data;
        if (status == 200){
            msg = "success!";
        }else{
            msg = "error.";
        }
    }

    public RDashboard(Integer status, Object data, String msg){
        this.status = status;
        this.data = data;
        this.msg = msg;
    }
}
