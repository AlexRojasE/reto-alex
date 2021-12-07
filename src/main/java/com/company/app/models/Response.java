package com.company.app.models;

import java.util.List;

public class Response {
	private List<UserResponse> data;
	
	public Response() {}

	public Response(List<UserResponse> data) {
		this.data = data;
	}

	public List<UserResponse> getData() {
		return data;
	}

	public void setData(List<UserResponse> data) {
		this.data = data;
	}	
}
