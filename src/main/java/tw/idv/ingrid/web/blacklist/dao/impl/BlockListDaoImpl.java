package tw.idv.ingrid.web.blacklist.dao.impl;

import java.util.List;

import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;


import tw.idv.ingrid.web.blacklist.dao.BlockListDao;
import tw.idv.ingrid.web.user.pojo.User;

@Repository
public class BlockListDaoImpl implements BlockListDao {
	@PersistenceContext
	private Session session;

	@Override
	public List<User> selectAllBlock() {
		final String hql = "FROM User";
		return session
				.createQuery(hql, User.class)
				.getResultList();
	}

//封鎖使用者(修)update 狀態
	@Override
	public int updateBlockState(User user) {
		final StringBuilder hql = new StringBuilder()
				.append("update User set ")
				.append("isBanned = :isBanned ")
				.append("where userId = :userId ");
		
		return session
				.createQuery(hql.toString())
				.setParameter("isBanned", user.getIsBanned())
				.setParameter("userId", user.getUserId())
				.executeUpdate();
	}

}
