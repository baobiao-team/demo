package hello.mall.mpvue.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.mall.mpvue.been.Pro;
import hello.mall.mpvue.controller.utils.utils;

@RestController
@RequestMapping("/user/proinfouser")
public class TestController {

	@Value("${pro.classify}")
    private String file;
	@Value("${pro.type}")
    private String typeFile;
	
    @RequestMapping(path = "search", method = RequestMethod.GET)
    public String pro(@RequestParam(value = "proType") String proType) throws Exception {
    	File f = new File(file);
    	if(!f.exists()) {
    		throw new Exception("no file:"+f.toString());
    	}
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	Pro[] pros = objectMapper.readValue(utils.FileToString(f), Pro[].class);
    	
    	List<Pro> list = new ArrayList<Pro>();
    	if((!"".equals(proType)) && (proType != null)) {
        	for (Pro pro : pros) {
        		if(pro.getProType().equals(proType)) {
        			list.add(pro);
        		}
            }
    	}else {
    		for (Pro pro : pros) {
        		list.add(pro);
            }
    	}

    	return objectMapper.writeValueAsString(list);
    }
    
    @RequestMapping(path = "findprotype")
    public String typePro(String name) throws Exception {
    	File f = new File(typeFile);
    	if(!f.exists()) {
    		throw new Exception("no file:"+f.toString());
    	}
    	return utils.FileToString(f);
    }

}