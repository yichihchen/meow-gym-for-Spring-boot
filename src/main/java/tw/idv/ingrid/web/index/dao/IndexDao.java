package tw.idv.ingrid.web.index.dao;

import java.util.List;

import tw.idv.ingrid.core.dao.CoreDao;
import tw.idv.ingrid.web.coach.pojo.CoachProfiles;
import tw.idv.ingrid.web.promotions.pojo.CoursePromo;
import tw.idv.ingrid.web.user.pojo.User;

public interface IndexDao extends CoreDao<CoursePromo, Integer>{

	List<CoachProfiles> selectAllCoach();

	User selectUserById(Integer userId);

}
