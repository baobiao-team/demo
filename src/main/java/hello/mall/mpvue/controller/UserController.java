package hello.mall.mpvue.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;


import hello.mall.mpvue.controller.utils.utils;
import hello.mall.mpvue.dao.Order;
import hello.mall.mpvue.dao.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/store/storeuserinfo")
public class UserController {

	@Value("${pro.classify}")
    private String file;
	@Value("${pro.user}")
    private String typeFile;
	@Value("${pro.order}")
	private String typeFile1;
	private String proString = "pro.json";
	
	  @RequestMapping(path = "login", method = RequestMethod.POST)
	    public String pro(@RequestParam(value = "username") String username,
	    		@RequestParam(value = "password") String password) throws Exception {
	    	//String fname = file + proUser +File.separator+proString;
	    	File f = new File(typeFile);
	    	String printuser=null;
	    	if(!f.exists()) {
	    		throw new Exception("no file:"+f.toString());
	    	};
	    	
	    	 User userc=new User();
	    	 String strJon=utils.FileToString(f);
	    	 List<User> userList = new ArrayList<User>();
	    	 JSONArray jsonArray = JSONArray.fromObject(strJon);
	        for (int i = 0; i < jsonArray.size(); i++ )
	        {
	            JSONObject jsonObject = jsonArray.getJSONObject(i);
	            User  user = (User)JSONObject.toBean(jsonObject, User.class);
	            userList.add(user);
	        }
              
	    	  for (User user : userList) {
	    	      if(user.getUsername().equals(username)&&user.getPassword().equals(password)) { 
	    		     printuser=JSON.toJSONString(user); 
	    		     userc=user;
	    		      break;
	    	      }else {		 
	    	    	  printuser="用户名或密码错误"; 
	    		  }
	    	  }
	        System.out.println(printuser);
	        return printuser;
	  }   

}