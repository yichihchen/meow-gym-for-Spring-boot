package tw.idv.ingrid.web.promotions.dao;

import java.util.List;

import tw.idv.ingrid.web.promotions.pojo.CoursePromo;

public interface PromotionsDao {

	List<CoursePromo> selectPromo();

	int insert(CoursePromo coursePromo);

	int deleteById(CoursePromo coursePromo);

}
