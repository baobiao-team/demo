package hello.mall.mpvue.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import hello.mall.mpvue.controller.utils.utils;

@RestController
@RequestMapping("/proinfouser")
public class DetailController {
	
	@Value("${pro.goods}")
    private String file;
	
	private String proString = "goods.json";
	
    @RequestMapping(path = "{proId}", method = RequestMethod.GET)
    public String detail(@PathVariable(value = "proId") String proId) throws Exception {
    	
    	String fname = file +proString;
    	File f = new File(fname);
    	String printgoods=null;
    	if(!f.exists()) {
    		throw new Exception("no file:"+f.toString());
    	};
    	
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
			  printgoods="无此商品！"; 
			  }
		  }
         System.out.println(printgoods);
         return printgoods;
    }

}
