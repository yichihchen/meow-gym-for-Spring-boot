package tw.idv.ingrid.web.chat.controller;

import java.util.HashMap;
import java.util.Map;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.idv.ingrid.web.user.pojo.User;


//Spring MVC
@Controller
@RequestMapping("chat")
public class UserInfo{

	Map<String, Object> body = new HashMap<>();
	
	@GetMapping("userinfo")
	@ResponseBody
	public Map<String, Object> getUserInfo(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		User loginUser = (User) session.getAttribute("user");
		
		body.put("loginUser", loginUser);
		return body; //Jackson 序列化成 JSON
	}
}


