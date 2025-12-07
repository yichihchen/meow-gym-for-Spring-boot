package tw.idv.ingrid.web.blacklist.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tw.idv.ingrid.web.blacklist.dao.BlockListDao;
import tw.idv.ingrid.web.blacklist.service.BlockListService;
import tw.idv.ingrid.web.user.pojo.User;

@Transactional
@Service
public class BlockListServiceImpl implements BlockListService {
	@Autowired
	private BlockListDao blockListDao;

	@Autowired
	private BlockListDao blockDao;

	@Override
	public List<User> selectAllBlockService() {
		return blockListDao.selectAllBlock();
	}

	@Override
	public int updateBlockStateService(User user) {
		user.setIsBanned(true);
		return blockDao.updateBlockState(user);
	}
	@Override
	public int updateUnlockStateService(User user) {
		user.setIsBanned(false);
		return blockDao.updateBlockState(user);
	}
}
