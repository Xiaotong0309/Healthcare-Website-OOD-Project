package com.test.health.info;

import com.test.health.model.User;

/**
 * ThreadLocal class store current login user's information
 */
public class UserInfo {

    private static ThreadLocal<User> userInfo = new ThreadLocal<>();

    public static void put(User user){
        userInfo.set(user);
    }

    public static User get(){
        return userInfo.get();
    }

    public static void clear(){
        userInfo.remove();
    }

}
