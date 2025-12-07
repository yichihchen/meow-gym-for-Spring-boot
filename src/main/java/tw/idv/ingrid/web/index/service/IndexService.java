package tw.idv.ingrid.web.index.service;

import java.util.List;

import tw.idv.ingrid.web.coach.pojo.CoachProfiles;
import tw.idv.ingrid.web.promotions.pojo.CoursePromo;
import tw.idv.ingrid.web.user.pojo.User;

public interface IndexService {
	List<CoursePromo> findAllPromo();
	Boolean isOnSale (CoursePromo coursePromo);
	List<CoachProfiles> findAllCoach();
	Boolean coachApprovalStatus(User user);
}
