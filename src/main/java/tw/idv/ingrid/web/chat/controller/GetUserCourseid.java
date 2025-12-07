package tw.idv.ingrid.web.chat.controller;

import java.util.HashMap;
import java.util.Map;


import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import tw.idv.ingrid.web.chat.dao.ChatDao;
import tw.idv.ingrid.web.user.pojo.User;

@Controller
@RequestMapping("chat")
public class GetUserCourseid {

	@Autowired
	private ChatDao chatDao;

	@GetMapping("getusercourseid")
	@ResponseBody
	public Map<String, Object> getUserCourseId(HttpSession session) {

		Map<String, Object> body = new HashMap<>();

		User loginUser = (User) session.getAttribute("user");

		// 呼叫 httpsession 的 courseId
		Integer courseIdNew = (Integer) session.getAttribute("courseId");
		System.out.println("fan courseId" + courseIdNew); // send to frontend

		// List<UserCourseDTO> usercourseid = chatDao.selectUserCourseId(userid);

		// add 20251129
		String courseTitle = chatDao.selectCourseTitle(courseIdNew);
		System.out.println("courseTitle" + courseTitle);
		// add 20251129 end

		body.put("ok", true);
		body.put("usercourseid", courseIdNew);

		body.put("coursetitle", courseTitle);

		System.out.println("fan body" + body);
		return body;

	}

}
