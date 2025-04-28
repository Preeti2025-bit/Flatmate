package com.example.flat.com.RestDao;

public class RMDQueries {

    public static String loginQuery(String name) {
        // TODO Auto-generated method stub
        return "select * from user where name='"+name+"'";    
    }

}
