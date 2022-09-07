package Medione.utils;

import lombok.Data;

@Data
public class R<T> {
    private static final int CREATE_ACCOUNT_ERROR = 800;
    int status = 200;
    String msg = "success";
    T data = null;

    public R(int status){
        this.status = status;
    }

    public R(T data){
        this.data = data;
        if (data==null|| data.equals(false)){
            status = 404;
        }
    }
    public R(CreateAccountError error){
        this.status = CREATE_ACCOUNT_ERROR;
        msg = error.toString();


    }


}