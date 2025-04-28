package com.example.flat.com;


public class DataTraveller<T> {

	public DataTraveller() {
		// TODO Auto-generated constructor stub
	}

	private Object data, dataList;
	private boolean isSuccess = true;
	private String error = "", description = "", successMessage = "";
	private int responseCode;

	public DataTraveller(Object cdata, Object cdataList, boolean cisSuccess, String cerror, String cdescription,
			String csuccessMessage, int cresCode) {
		this.data = cdata;
		this.dataList = cdataList;
		this.isSuccess = cisSuccess;
		this.error = cerror;
		this.description = cdescription;
		this.successMessage = csuccessMessage;
		this.responseCode = cresCode;
	}

	
	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}

	public Object getDataList() {
		return dataList;
	}

	public void setDataList(Object dataList) {
		this.dataList = dataList;
	}

	
	public boolean isSuccess() {
		return isSuccess;
	}

	
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	
	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getSuccessMessage() {
		return successMessage;
	}

	
	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}


	public int getResponseCode() {
		return responseCode;
	}

	
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
}
