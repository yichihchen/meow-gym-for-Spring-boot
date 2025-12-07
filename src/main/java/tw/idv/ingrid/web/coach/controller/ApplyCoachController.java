package tw.idv.ingrid.web.coach.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;


import tw.idv.ingrid.web.coach.pojo.*;
import tw.idv.ingrid.web.coach.service.CoachService;
import tw.idv.ingrid.web.user.pojo.User;

@RestController
@RequestMapping("coach/apply")
public class ApplyCoachController {
	@Autowired
	private CoachService service;
	
	@GetMapping
	public Map<String, Object> getApplyData(@SessionAttribute(value = "user", required = false) User user){
		Map<String, Object> respbody = new HashMap<>();
		
		CoachProfiles profile = service.findProfile(user.getUserId());
		CoachCertificates certificate = service.findCertificate(profile.getCoachId());
		CoachEducations education = service.findEducation(profile.getCoachId());
		CoachExperiences experience = service.findExperience(profile.getCoachId());
		
		respbody.put("profile", profile);
		respbody.put("certificate", certificate);
		respbody.put("education", education);
		respbody.put("experience", experience);
		
		return respbody;
	}
	
	@PutMapping
	public Map<String, Object> updateAppleData(@RequestBody CoachApplyUpdateRequest request) throws IOException{
		Map<String, Object> respbody = new HashMap<>();
		boolean result = service.updateCoachData(request);
		
		respbody.put("successful", result);
		return respbody;
		
	}

}
