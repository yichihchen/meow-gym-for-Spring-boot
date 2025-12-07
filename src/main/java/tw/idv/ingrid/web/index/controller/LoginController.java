package tw.idv.ingrid.web.index.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import tw.idv.ingrid.web.coach.pojo.CoachProfiles;
import tw.idv.ingrid.web.coach.service.CoachService;
import tw.idv.ingrid.web.user.pojo.User;

@RestController
@RequestMapping("index/loginData")
public class LoginController {
	@Autowired
	private CoachService service;
	
	@GetMapping
	public Map<String, Object> getLoginData (@SessionAttribute(value = "user", required = false) User user) {
		Map<String, Object> respbody = new HashMap<>();
		if (user == null) {
			respbody.put("successful", false);
		} else {
			CoachProfiles profile = service.findProfile(user.getUserId());
			respbody.put("successful", true);
			respbody.put("user", user);
			respbody.put("profile", profile);
		}
		return respbody;
	}
}
