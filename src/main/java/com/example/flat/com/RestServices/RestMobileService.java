package com.example.flat.com.RestServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flat.com.DataTraveller;
import com.example.flat.com.MyCustomLogger;
import com.example.flat.com.RestDao.RestMobileDao;
import com.example.flat.com.RestModels.Users;
import com.example.flat.com.model.User;

import jakarta.transaction.Transactional;


@Service("restMobileService")
@Transactional
public class RestMobileService extends MyCustomLogger {

	private String error = "", description = "";
	private int code;
	@Autowired
	RestMobileDao restMobileDao;

	//@Autowired
	//GlobalResponseModel grm;

	public DataTraveller<Users> getLogin(Users model) {
		log("inside RestMobileService().getQualificationDetails()", LogType.Function);
		DataTraveller<Users> bean = new DataTraveller<Users>();
		if (model.getName() == null || model.getName().isEmpty()) {
			log("Invalid Roll Number", LogType.Function);
			bean.setSuccess(false);
			bean.setError("Credentails Invalid");
			bean.setDescription("Kindly Check your credentials.");
			return bean;
		}
		return restMobileDao.login(model);


}
}