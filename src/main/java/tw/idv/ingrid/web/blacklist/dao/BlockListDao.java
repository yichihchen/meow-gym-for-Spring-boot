package tw.idv.ingrid.web.blacklist.dao;

import java.util.List;

import tw.idv.ingrid.web.user.pojo.User;

public interface BlockListDao {

	int updateBlockState(User user);
	
	List<User> selectAllBlock();

}
