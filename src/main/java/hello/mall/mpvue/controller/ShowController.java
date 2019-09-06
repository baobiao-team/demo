package hello.mall.mpvue.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")
public class ShowController {

	@Value("${pro.show}")
	private String filePath;

	@RequestMapping(path = "all")
	public String typePro(String name) throws Exception {
		File f = new File(filePath);
		if (!f.exists()) {
			throw new Exception("no file:" + f.toString());
		}
		;
		return FileToString(f);
	}

	public String FileToString(File f) {

		BufferedReader br = null;
		String result = null;
		try {

//            br = new BufferedReader(new InputStreamReader(getInputStream(path)));
			FileInputStream fin = new FileInputStream(f);
			br = new BufferedReader(new InputStreamReader(fin, "UTF-8"));
			StringBuffer message = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				message.append(line);
			}
			if (br != null) {
				br.close();
			}
			String defaultString = message.toString();
			result = defaultString.replace("\r\n", "").replaceAll(" +", "");

		} catch (IOException e) {

		}

		return result;
	}

}