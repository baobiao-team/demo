package hello.mall.mpvue.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import hello.mall.mpvue.been.Cart;
import hello.mall.mpvue.controller.utils.utils;

@RestController
@RequestMapping("/user/cartinfo")
public class CardController {

	@Value("${pro.card}")
	private String typeFile;

	@RequestMapping
	public String typePro(String userId) throws Exception {
		File f = new File(typeFile);
		if (!f.exists()) {
			throw new Exception("no file:" + f.toString());
		}
		ObjectMapper objectMapper = new ObjectMapper();
		Cart[] cart = objectMapper.readValue(utils.FileToString(f), Cart[].class);

		List<Cart> list = new ArrayList<Cart>();
		for (Cart g : cart) {
			if (g.getUserId().equals(userId)) {
				list.add(g);
			}
		}

		return objectMapper.writeValueAsString(list);
	}

	@RequestMapping(path = "order", method = RequestMethod.POST)
	public String submitOrder(@RequestBody Object order) {
		return JSON.toJSONString(order);
	}
}
