package Medione.utils;

import Medione.pojo.User;

import javax.servlet.http.HttpSession;

public class BaseContext {
    private static ThreadLocal<User> threadLocal = new ThreadLocal<>();

    /**
     * 设置值
     * @param session
     */
    public static void setCurrentUser(User user){
        threadLocal.set(user);
    }



    public static User getCurrentUser(){
        return threadLocal.get();
    }
}