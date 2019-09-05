package hello.mall.mpvue.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/consumer")
public class OrderController {
	
	@Value("${pro.order}")
	private String typeFile;
	
	
  @RequestMapping(path = "orderinfo", method = RequestMethod.GET)
   public String pro(@RequestParam(value = "userid") String userid,
		   @RequestParam(value = "orderStatus") String orderStatus) throws Exception {
	  
	        File f = new File(typeFile);
	    	String printorder=null;
	    	if(!f.exists()) {
	    		throw new Exception("no file:"+f.toString());
	    	};
	    	
	    	
	    	 String strJon1=utils.FileToString(f);
	    	 List<Order> orderList = new ArrayList<Order>();
	    	 JSONArray jsonArray1 = JSONArray.fromObject(strJon1);
	        for (int i = 0; i < jsonArray1.size(); i++ )
	        {
	            JSONObject jsonObject = jsonArray1.getJSONObject(i);
	            Order  order = (Order)JSONObject.toBean(jsonObject, Order.class);
	            orderList.add(order);
	        }
       
	    	  for (Order order : orderList) {
	    	      if(order.getUserId().equals(userid)&&order.getOrderStatus().equals(orderStatus)) { 
	    		     printorder=JSON.toJSONString(order); 
	    		      break;
	    	      }else {		 
	    	    	  printorder="未查询到相关订单"; 
	    		  }
	    	  }
	    	  System.out.println(printorder);
	        return printorder;

	    }
  
  
}
