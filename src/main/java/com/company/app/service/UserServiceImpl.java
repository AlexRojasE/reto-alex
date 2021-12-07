package com.company.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.company.app.models.Response;
import com.company.app.models.User;
import com.company.app.models.UserRequest;
import com.company.app.models.UserResponse;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private RestTemplate restTemplate;
	@Value("${url.name}")
	private String url;
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public Response listar() {
		UserRequest userRequest = restTemplate.getForObject("https://reqres.in/api/users", UserRequest.class);
		
		List<UserResponse> listResponse = new ArrayList<UserResponse>();
		Response response = new Response();
		
		
			for (User user : userRequest.getData()) {
				UserResponse userResponse = new UserResponse();
				userResponse.setId(user.getId());
				userResponse.setLast_name(user.getLast_name());
				userResponse.setEmail(user.getEmail());
				listResponse.add(userResponse);
					
		}
		
		response.setData(listResponse);
		
		return response;
	}
}
