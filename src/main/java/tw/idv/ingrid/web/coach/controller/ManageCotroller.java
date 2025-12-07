package tw.idv.ingrid.web.coach.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tw.idv.ingrid.web.coach.pojo.CoachAndUser;
import tw.idv.ingrid.web.coach.service.CoachService;
import tw.idv.ingrid.web.user.pojo.User;

@RestController
@RequestMapping("coach/manage")
public class ManageCotroller {
	@Autowired
	private CoachService service;

	@GetMapping
	public List<CoachAndUser> getUserList(){
		return service.findCoachAndUser();
		
	}
	
	@PostMapping
	public Map<String, Object> invite(@RequestBody User user) throws ParseException{
		Boolean result = service.inviteCoach(user.getUserId());
		Map<String, Object> respbody = new HashMap<>();
		if (result) {
			respbody.put("message", "邀請成功！");
		} else {
			respbody.put("message", "邀請失敗！");
		}
		respbody.put("successful", result);
		return respbody;
	}
}
