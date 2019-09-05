package hello.mall.mpvue.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.mall.mpvue.been.Cart;

@RestController
@RequestMapping("/user")
public class CardController {
	
	@Value("${pro.card}")
    private String typeFile;
	

   
    @RequestMapping(path = "cartinfo")
    public String typePro(String UserId) throws Exception {
    	File f = new File(typeFile);
    	if(!f.exists()) {
    		throw new Exception("no file:"+f.toString());
    	};
    	ObjectMapper objectMapper = new ObjectMapper();
    	Cart[] cart = objectMapper.readValue(FileToString(f), Cart[].class);
    	
    	List<Cart> list = new ArrayList<Cart>();
    	for (Cart g : cart) {
    		if(g.getUserId().equals(UserId)) {
    			list.add(g);
    		}
        }
    	
    	return objectMapper.writeValueAsString(list);
    }
    public String FileToString(File f){

        BufferedReader br = null;
        String result = null;
        try {

//            br = new BufferedReader(new InputStreamReader(getInputStream(path)));
        	FileInputStream fin = new FileInputStream(f);
            br = new BufferedReader(new InputStreamReader(fin,"UTF-8"));
            StringBuffer message=new StringBuffer();
            String line = null;
            while((line = br.readLine()) != null) {
                message.append(line);
            }
            if (br != null) {
                br.close();
            }
            String defaultString=message.toString();
            result=defaultString.replace("\r\n", "").replaceAll(" +", "");

        } catch (IOException e) {
            

        }
        System.out.println("-------------------------------------");
        System.out.println(result);
        return result;
    }


}
