package tw.idv.ingrid.web.course.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;


import tw.idv.ingrid.web.course.pojo.Course;
import tw.idv.ingrid.web.course.pojo.CourseRecurringRules;
import tw.idv.ingrid.web.course.pojo.CourseResponse;
import tw.idv.ingrid.web.course.service.CourseService;
import tw.idv.ingrid.web.user.pojo.User;

@RestController
@RequestMapping("course/browse")
public class BrowseController {
	@Autowired
	private CourseService service;

	@GetMapping
	public List<Course> browseCourse(){
		return service.findApprovalCourse();
	}
	@GetMapping("{courseId}")
	public CourseResponse browseCoursePost(@PathVariable Integer courseId, @SessionAttribute(value = "user", required = false) User user){
		CourseResponse courseResponse = new CourseResponse();
		Course course = new Course();
		course.setCourseId(courseId);
		course = service.find(course);
		course = service.findPromo(course);
		String userName = service.findName(course);
		List<CourseRecurringRules> rules = service.findRules(course);
		if(user != null) {
			course = service.findPayStatus(user, course);
		}
		courseResponse.setCourse(course);
		courseResponse.setUserName(userName);
		courseResponse.setRules(rules);
		return courseResponse;
	}
	
	@PostMapping
	public Map<String, Object> addCart(HttpSession session, @RequestBody Course course) {
		Map<String, Object> result = new HashMap<>();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			result.put("successful", false);
			result.put("message", "請先登入");
			return result;
		}
		
		course = service.find(course);
		if (course.isSuccessful()) {
			String coachName = service.findName(course);
			result.put("successful", course.isSuccessful());
			result.put("message", course.getTitle());
			session.setAttribute("course", course);
			session.setAttribute("courseId", course.getCourseId());
			session.setAttribute("coachName", coachName);
		} else {
			result.put("successful", course.isSuccessful());
			result.put("message", "沒有此課程");
		}
		return result;
	}
	
}
