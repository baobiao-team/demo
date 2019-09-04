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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.mall.mpvue.been.Pro;

@RestController
@RequestMapping("/user/proinfouser")
public class TestController {

	@Value("${pro.classify}")
    private String file;
	@Value("${pro.type}")
    private String typeFile;
	
    @RequestMapping(path = "findall", method = RequestMethod.GET)
    public String pro(String proType) throws Exception {
    	File f = new File(file);
    	if(!f.exists()) {
    		throw new Exception("no file:"+f.toString());
    	};
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	Pro[] pros = objectMapper.readValue(FileToString(f), Pro[].class);
    	
    	List<Pro> list = new ArrayList<Pro>();
    	if(!"000".equals(proType)) {
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
    	};
    	return FileToString(f);
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

        return result;
    }

}