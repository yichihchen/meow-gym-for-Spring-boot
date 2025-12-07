package tw.idv.ingrid.web.order.controller;

import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import tw.idv.ingrid.core.pojo.Core;
import tw.idv.ingrid.web.course.pojo.Course;
import tw.idv.ingrid.web.order.pojo.Orderitems;
import tw.idv.ingrid.web.order.pojo.Orders;
import tw.idv.ingrid.web.order.service.OrderService;
import tw.idv.ingrid.web.promotions.pojo.CoursePromo;
import tw.idv.ingrid.web.user.pojo.User;

@Controller
@RequestMapping("order")
//@WebServlet("/order/payment")
public class CartController {
	@Autowired
	private OrderService orderservice;
	
	@GetMapping("getAllCoursePromo")
	@ResponseBody
	protected List<CoursePromo> getAllCoursePromo() {
		// 回傳購物車清單
		return orderservice.getAllCoursePromo();
	}

	@GetMapping("addCart")
	@ResponseBody
	protected Map<String, Object> addCart(HttpSession session,@SessionAttribute(value = "user", required = false) User setUser, 
			@SessionAttribute(value = "course", required = false) Course setCourse) {
		//取會員資料
		Integer userId = setUser.getUserId();

		// 判斷是否有加入購物車的課程，如無則顯示課程清單
		if (setCourse != null) {
			// 比對訂單course資訊
			Boolean booLean = orderservice.addcart(setCourse, userId);
			System.out.println(booLean);
		}
		// 回傳購物車清單
		Map<String, Object> orderitemsAndCourseList = orderservice.getAllOrderitemsAndCourseByUserId(userId);
		session.removeAttribute("course");
		return orderitemsAndCourseList;
	}
	
	@PostMapping("deleteCart")
	@ResponseBody
	protected Core deleteCart(@RequestBody Orderitems orderitems, 
			@SessionAttribute(value = "user", required = false) User setUser){
		Integer orderItemId = orderitems.getOrderItemId();
		//取會員資料
		Integer userId = setUser.getUserId();

		Core core = new Core();
		core.setSuccessful(orderservice.deletecoursefromcart(orderItemId, userId));
		return core;
	}
	
	@PostMapping("payment")
	@ResponseBody
	protected Orders payment (@RequestBody Orders orders, 
			@SessionAttribute(value = "user", required = false) User setUser) {		
		//取會員資料
		Integer userId = setUser.getUserId();
		
		//import static 套件寫法		
		return orderservice.payment(orders, userId);
	}
	
	@GetMapping("confirmation")
	@ResponseBody
	protected Map<String, Object> confirmation(@SessionAttribute(value = "user", required = false) User setUser
			) {
		//取會員資料
		Integer userId = setUser.getUserId();
		
		// 回傳購物車清單
		Map<String, Object> orderConfirmation = orderservice.getOrderConfirmation(userId);
		return orderConfirmation;
	}
}
