package com.example.flat.com.restMobileController;

import org.springframework.web.bind.annotation.RestController;

import com.example.flat.com.DataTraveller;
import com.example.flat.com.GlobalResponseModel;
import com.example.flat.com.MyConstants.ResponseCode;
import com.example.flat.com.MyConstants.StringRes;
import com.example.flat.com.MyCustomLogger;
import com.example.flat.com.RestModels.Users;
import com.example.flat.com.RestServices.RestMobileService;
import com.example.flat.com.model.Signup;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;




@RestController
@RequestMapping("/user")
public class RestMobileController extends MyCustomLogger {
	private String error, description;
	private int code;
    	@Autowired
	private RestMobileService restMobileService;
@Autowired
	private GlobalResponseModel grm;
    // @GetMapping("/test")
    // public String test() {
    //     return "HelloPreeti";
    // }

    	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public Map<String, Object> getQualificationDetails(@RequestBody String requestBody, HttpServletRequest request,
			HttpServletResponse response) {
		try {
	
			Users restmrm = new Gson().fromJson(requestBody, Users.class);
			DataTraveller<Users> dtrmrm = new DataTraveller<Users>();
			dtrmrm.setData(restmrm);
			log("json Parced Successfully");
			log("returning response");
			return returnData(restMobileService.getLogin(restmrm), response);

		} catch (Exception e) {
			log("i am in catch");
			log(e.getLocalizedMessage(), LogType.Error);
			log("Error in RestAuthController  getQualificationDetails Method--->>>" + e.getMessage(), LogType.Error);
			return grm.returnResponse(e.getMessage(), StringRes.DESC_MSG, response, ResponseCode.UNPROCESSABLE_ENTITY);
		}
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public Map<String, Object> signup(@RequestBody String requestBody, HttpServletRequest request,
			HttpServletResponse response) {
		try {
	
			Signup restmrm = new Gson().fromJson(requestBody, Signup.class);
			DataTraveller<Signup> dtrmrm = new DataTraveller<Signup>();
			dtrmrm.setData(restmrm);
			log("json Parced Successfully");
			return returnData(restMobileService.signUp(restmrm), response);

		} catch (Exception e) {
			log("i am in catch");
			log(e.getLocalizedMessage(), LogType.Error);
			log("Error in RestAuthController  SignUp Method--->>>" + e.getMessage(), LogType.Error);
			return grm.returnResponse(e.getMessage(), StringRes.DESC_MSG, response, ResponseCode.UNPROCESSABLE_ENTITY);
		}
	}
    public <T> Map<String, Object> returnData(DataTraveller<T> object, HttpServletResponse response) {
		if (object.isSuccess()) {
			if (object.getData() != null)
				return grm.returnResponse(object.getData());
			else
				return grm.returnResponseList(object.getDataList());
		}
		String m = object.getDescription() != null || object.getDescription().isEmpty() == false
				? object.getDescription()
				: "Something went wrong";
		return grm.returnResponse(object.getError(), m, response, ResponseCode.OK);
	}

 
}
