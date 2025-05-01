package com.example.flat.com.RestDao;

public class RMDQueries {

    public static String loginQuery(String name) {
        // TODO Auto-generated method stub
        return "select * from user where name='"+name+"'";    
    }

    public static String signUpQuery(String mobileNumber, String firstname, String lastname, String emailId) {
        return " INSERT INTO `flat_mate1`.`sign_up` (`firstname`, `lastname`, `emailId`, `mobileNumber`) VALUES ('"+firstname+"', '"+lastname+"', '"+emailId+"', '"+emailId+"')";
    }

}
