package tw.idv.ingrid.web.promotions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.idv.ingrid.web.course.pojo.Course;
import tw.idv.ingrid.web.promotions.service.PromotionsService;

@Controller
@RequestMapping("promotions")
public class GetAllCoursePromotionController {
	@Autowired
	private PromotionsService service;

	@GetMapping("getAll")
	@ResponseBody
	public List<Course> getAll() {
		return service.findCourseAndPromotionAll();
	}
}
