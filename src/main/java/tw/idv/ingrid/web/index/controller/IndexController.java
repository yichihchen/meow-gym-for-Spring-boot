package tw.idv.ingrid.web.index.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.ingrid.web.index.service.IndexService;
import tw.idv.ingrid.web.promotions.pojo.CoursePromo;

@RestController
@RequestMapping("index/getPromotions")
public class IndexController {
	@Autowired
	private IndexService service;
	
	@GetMapping
	public List<CoursePromo> getPromotions() {
		return service.findAllPromo();
	}
}
