package com.example.flat.com.RestDao;

import com.example.flat.com.DataTraveller;
import com.example.flat.com.RestModels.Users;
import com.example.flat.com.model.User;

public interface IRestMobileDao {

	public DataTraveller<Users> login(Users restMobilerequestModel);
}