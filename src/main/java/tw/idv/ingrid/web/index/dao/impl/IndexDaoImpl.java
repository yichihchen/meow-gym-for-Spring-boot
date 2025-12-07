package tw.idv.ingrid.web.index.dao.impl;

import java.util.List;

import jakarta.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.idv.ingrid.web.coach.pojo.CoachProfiles;
import tw.idv.ingrid.web.index.dao.IndexDao;
import tw.idv.ingrid.web.promotions.pojo.CoursePromo;
import tw.idv.ingrid.web.user.pojo.User;

@Repository
public class IndexDaoImpl implements IndexDao {
	@PersistenceContext
	private Session session;

	@Override
	public int insert(CoursePromo pojo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(CoursePromo pojo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CoursePromo selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CoursePromo> selectAll() {
		final String hql = "FROM CoursePromo ORDER BY promoId";
		return session
				.createQuery(hql, CoursePromo.class)
				.getResultList();
	}

	@Override
	public List<CoachProfiles> selectAllCoach() {
		final String hql = "FROM CoachProfiles " + 
						"Where approvalStatus = '通過' " +
						"ORDER BY coachId";
		return session
				.createQuery(hql, CoachProfiles.class)
				.getResultList();
	}

	@Override
	public User selectUserById(Integer userId) {
		return session.get(User.class, userId);
	}

}
