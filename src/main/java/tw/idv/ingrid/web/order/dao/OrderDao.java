package tw.idv.ingrid.web.order.dao;

import java.util.List;

import tw.idv.ingrid.core.dao.CoreDao;
import tw.idv.ingrid.web.course.pojo.Course;
import tw.idv.ingrid.web.order.pojo.Orderitems;
import tw.idv.ingrid.web.order.pojo.Orders;
import tw.idv.ingrid.web.promotions.pojo.CoursePromo;
import tw.idv.ingrid.web.user.pojo.User;

public interface OrderDao extends CoreDao<Orders, Integer>{
	
	int insert(Orderitems orderitems);
	
	Integer selectOrderIdByUesrIdAndStatus(Integer userId, String status);
	
	Integer selectCoursePriceByCourseId(Integer courseId);
	
	List<Orderitems> selectOrderitemsListByOrderId(Integer orderId); //1找多
	
	List<Course> selectCourseListByOrderitemsCourseIdList(List<Integer> courseIdList);
	
	Integer selectPromoPriceByCourseId (Integer courseId); //沒用到
	
	CoursePromo selectCoursePromoByCourseId(Integer courseId);
	
	Integer deleteOrderitemsByOrderItemId(Integer orderItemId);
	
	Integer modifyStatusByOrderIdAndStatus(Integer orderId, String status);
	
	Course selectCourseByCourseId (Integer courseId);
	
	Orders selectOrdersByOrderId(Integer orderId);
	
	int insert(Orders orders);
	
	Integer selectOrderIdAfterPaymentByUesrId (Integer userId);
	
	String selectUserEmailByUserId(Integer userId);
	
	User selectUserByUserId(Integer userId);
	
	List<Orders> selectShoppingRecordOrdersByUserId(Integer userId);
	
	List<Orderitems>selectOrderitemListByOrderIdList(List<Integer> orderIdList); //多找多
	
	List<Orders> selectCashOrdersByStatus(String status);
	
	Integer selectUserIdByOrderId (Integer orderId);
	
	Integer selectChangeStatusOrderIdByUesrIdAndOrderId (Integer orderId, Integer userId);
}
