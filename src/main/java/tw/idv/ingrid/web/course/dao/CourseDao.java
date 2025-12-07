package tw.idv.ingrid.web.course.dao;

import java.util.List;


import tw.idv.ingrid.core.dao.CoreDao;
import tw.idv.ingrid.web.coach.pojo.CoachProfiles;
import tw.idv.ingrid.web.course.pojo.ClassSessions;
import tw.idv.ingrid.web.course.pojo.Course;
import tw.idv.ingrid.web.course.pojo.CourseRecurringRules;
import tw.idv.ingrid.web.course.pojo.SessionUsers;
import tw.idv.ingrid.web.order.pojo.Orders;
import tw.idv.ingrid.web.order.pojo.Orderitems;

import tw.idv.ingrid.web.promotions.pojo.CoursePromo;
import tw.idv.ingrid.web.user.pojo.User;

public interface CourseDao extends CoreDao<Course, Integer> {
	
	int insert (Course course);
	
	int insert (CourseRecurringRules courseRecurringRules);
	
	int insert (ClassSessions classSessions);
	
	int insert (SessionUsers sessionUsers);
	
	CoachProfiles selectByCoachId (Integer id);
	
	User selectByUserId (Integer id);
	
	List<CourseRecurringRules> selectByCourseId (Integer id);
	
	List<Orders> selectOrderByUserId (Integer id);
	
	List<Integer> selectCourseIdByOrderId (Integer id);
	
	List<ClassSessions> selectClassSessionBycourseID (Integer id);

	SessionUsers selectBySessionIdUserID (Integer sessionId, Integer userId);

	Long selectCntBySessionId (Integer sessionId);
	
	Long selectCntFromSessionUserById (Integer sessionId, Integer userId);
	
	int deleteById (SessionUsers sessionUsers);
	
	List<Course> selectApprovalCourse();
	
	List<Orderitems> selectOrderItemByCourseId(Integer courseId);
	
	Orders selectOrderByOrderId(Integer orderId);
	
	List<CoursePromo> selectByCoursId(Integer courseId);
	
	List<Course> selectCourseByCoachId (Integer coachId);
	
	int updateChkAt (ClassSessions classSessions);
	
	int updateChkOut (ClassSessions classSessions);
}
