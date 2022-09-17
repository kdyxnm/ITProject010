package Medione.utils;

import lombok.Data;

@Data
public class RMedicine {
    private Boolean status;
    private String msg;
    private Object data;


    public RMedicine() {}

    public RMedicine(Boolean status){
        this.status = status;
        if (status == true){
            msg = "success!";
        }else{
            msg = "error.";
        }
    }

    public RMedicine(Boolean status, Object data){
        this.status = status;
        this.data = data;
        if (status == true){
            msg = "success!";
        }else{
            msg = "error.";
        }
    }
}
