package Medione.utils;

import Medione.pojo.User;

import javax.servlet.http.HttpSession;

public class BaseContext {
    private static ThreadLocal<User> threadLocal = new ThreadLocal<>();


    public static void setCurrentUser(User user){
        System.out.println(Thread.currentThread().getId());
        threadLocal.set(user);
    }

    public static User getCurrentUser(){
        System.out.println(Thread.currentThread().getId());
        return threadLocal.get();
    }
}