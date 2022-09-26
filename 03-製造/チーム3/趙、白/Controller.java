package com.example.demo;

import java.util.ArrayList;
import java.util.List;


import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;

@RestController
@RequestMapping("user")
public class Controller {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("/getallattendance")
	@ResponseBody

	

	public List<User> findAll(){
		List<User> biao = new ArrayList<User>();
		biao = userRepository.findAll();
		return biao;
		
		
		
		
	}
}


