package tw.idv.ingrid.web.course.service;

import java.util.Date;
import java.util.List;

import jakarta.servlet.http.Part;

import com.google.gson.JsonObject;

import tw.idv.ingrid.core.service.CoreService;
import tw.idv.ingrid.web.course.pojo.ClassResponse;
import tw.idv.ingrid.web.course.pojo.ClassSessions;
import tw.idv.ingrid.web.course.pojo.Course;
import tw.idv.ingrid.web.course.pojo.CourseRecurringRules;
import tw.idv.ingrid.web.user.pojo.User;

public interface CourseService extends CoreService {
	
	Course apply(Course course);
	
	JsonObject apply(List<CourseRecurringRules> rules, Course course);
	
	JsonObject removeById(Integer id);
	
	List<Course> findAll();
	
	Course find(Course cousre);
	
	String findName(Course cousre);
	
	String modify(Course cousre);
	
	String addTimestampToFileName (String fileName);
	
	boolean writeToImgPath(Part part);
	
	List<CourseRecurringRules> findRules (Course cousre);
	
	List<Date> findDateOfWeekday (Course course, CourseRecurringRules rule);
	
	List<ClassResponse> findClass (Integer userId);

	Boolean reserveUpdate (ClassSessions classSessions, Integer userId);
	
	Long findQuotaUsed (Course course, Integer UserId);
	
	List<Course> findApprovalCourse();
	
	Course findPayStatus(User user, Course course);
	
	Course findPromo(Course course);
	
	List<ClassResponse> getCoursesByCoach (Integer coachId);
	
	Boolean updateChkTime (ClassSessions classSessions);
}
