package hello.mall.mpvue.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import hello.mall.mpvue.controller.utils.utils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/user/proinfouser")
public class DetailController {
	
	@Value("${pro.classify}")
    private String file;
	
    @RequestMapping
    public String detail(@RequestParam(value = "proId") String proId) throws Exception {
    	
    	File f = new File(file);
    	String printgoods=null;
    	if(!f.exists()) {
    		throw new Exception("no file:"+f.toString());
    	}
    	
    	String strJon=utils.FileToString(f);
    	 List<Goods> goodsList = new ArrayList<Goods>();
    	 JSONArray jsonArray = JSONArray.fromObject(strJon);
         for (int i = 0; i < jsonArray.size(); i++ )
         {
             JSONObject jsonObject = jsonArray.getJSONObject(i);
             Goods goods = (Goods)JSONObject.toBean(jsonObject, Goods.class);
             goodsList.add(goods);
         }
 
		  for (Goods goods : goodsList) {
		      if(goods.getProId().equals(proId)) { 
		    	  printgoods=JSON.toJSONString(goods); 
			      break;
		      }else {		 
		    	  printgoods=""; 
			  }
		  }
         return printgoods;
    }

}
