package com.example.flat.com;

/**
 * Created GlobalResponseModel.java by sanchitverma on 13-Mar-2024 at 10:59:16 am
 */

import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.servlet.http.HttpServletResponse;

/**
 * @author sanchitverma created on 13-Mar-2024 10:59:16 am
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@Component("globalResponse")
public class GlobalResponseModel {
	private final static String RESPONSE_STATUS = "status";
	private final static String RESPONSE_MSG = "msg";
	private final static String RESPONSE_MSGDESC = "msgDesc";
	private final static String RESPONSE_DATA = "data";
	private final static String RESPONSE_DATA_LIST = "datalist";
	private final static String RESPONSE_SUCCESS_MSG = "successmessage";
	private Map<String, Object> map = new HashMap<String, Object>();

	/// Created By Sanchit Verma 7th-Feb-23
	public Map<String, Object> returnResponse(Object data) {
		map = new HashMap<String, Object>();
		map.put(RESPONSE_STATUS, "0");
		map.put(RESPONSE_MSG, "success");
		map.put(RESPONSE_DATA, data);
		return map;
	}

	public Map<String, Object> returnResponse(Object data, String successmessage) {
		map = new HashMap<String, Object>();
		map.put(RESPONSE_STATUS, "0");
		map.put(RESPONSE_MSG, "success");
		map.put(RESPONSE_DATA, data);
		map.put(RESPONSE_SUCCESS_MSG, successmessage);
		return map;
	}

	public Map<String, Object> returnResponseList(Object data) {
		map = new HashMap<String, Object>();
		map.put(RESPONSE_STATUS, "0");
		map.put(RESPONSE_MSG, "success");
		map.put(RESPONSE_DATA_LIST, data);
		return map;
	}

	public Map<String, Object> returnResponseList(Object data, String successmessage) {
		map = new HashMap<String, Object>();
		map.put(RESPONSE_STATUS, "0");
		map.put(RESPONSE_MSG, "success");
		map.put(RESPONSE_DATA_LIST, data);
		map.put(RESPONSE_SUCCESS_MSG, successmessage);
		return map;
	}

	/// Created By Sanchit Verma 7th-Feb-23
	/// For error occures then it will Called and response will sent back
	public Map<String, Object> returnResponse(String err, String desc, HttpServletResponse res, int responseCode) {
		map = new HashMap<String, Object>();
		map.put(RESPONSE_STATUS, "1");
		map.put(RESPONSE_MSG, err);
		map.put(RESPONSE_MSGDESC, desc);
		res.setStatus(responseCode);
		return map;
	}

	public Map<String, Object> returnResponse(Object err, String desc, HttpServletResponse res, int responseCode) {
		map = new HashMap<String, Object>();
		map.put(RESPONSE_STATUS, "1");
		map.put(RESPONSE_MSG, err);
		map.put(RESPONSE_MSGDESC, desc);
		res.setStatus(responseCode);
		return map;

	}
}
