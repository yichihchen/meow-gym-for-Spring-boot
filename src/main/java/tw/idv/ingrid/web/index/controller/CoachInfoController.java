package tw.idv.ingrid.web.index.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.ingrid.web.coach.pojo.CoachProfiles;
import tw.idv.ingrid.web.index.service.IndexService;

@RestController
@RequestMapping("index/coachInfo")
public class CoachInfoController {
	@Autowired
	private IndexService service;
	
	@GetMapping
	public List<CoachProfiles> getCoachInfo(){
		return service.findAllCoach();
	}
}
