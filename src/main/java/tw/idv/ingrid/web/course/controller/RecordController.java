package tw.idv.ingrid.web.course.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;


import tw.idv.ingrid.web.course.pojo.ClassResponse;
import tw.idv.ingrid.web.course.service.CourseService;
import tw.idv.ingrid.web.user.pojo.User;


@RestController
@RequestMapping("course/record")
public class RecordController {
	@Autowired
	private CourseService service;
	
	@GetMapping
	public List<ClassResponse> getRecord(@SessionAttribute(value = "user", required = false) User user){
		return service.findClass(user.getUserId());
	}
	
	@GetMapping("{courseId}")
	public Map<String, Object> goChat(@PathVariable Integer courseId, HttpSession session){
		Map<String, Object> respbody = new HashMap<>();
		session.setAttribute("courseId", courseId);
		respbody.put("ok", true);
		return respbody;
	}
}
