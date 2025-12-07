package tw.idv.ingrid.web.index.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.idv.ingrid.web.coach.dao.CoachDao;
import tw.idv.ingrid.web.coach.pojo.CoachProfiles;
import tw.idv.ingrid.web.index.dao.IndexDao;
import tw.idv.ingrid.web.index.service.IndexService;
import tw.idv.ingrid.web.promotions.pojo.CoursePromo;
import tw.idv.ingrid.web.user.pojo.User;

@Service
@Transactional
public class IndexServiceImpl implements IndexService {
	@Autowired
	private IndexDao dao;
	
	@Autowired
	private CoachDao coachDao;

	@Override
	public List<CoursePromo> findAllPromo() {
		List<CoursePromo> cpAllList = dao.selectAll();
		List<CoursePromo> cpCurList = new ArrayList<>();
		if (!cpAllList.isEmpty()) {
			for (CoursePromo cp : cpAllList) {
				if (isOnSale(cp)) {
					cpCurList.add(cp);
				}
			}
			return cpCurList;
		}
		return cpAllList;		
	}

	@Override
	public Boolean isOnSale(CoursePromo coursePromo) {
		Date today = new Date();
		if (today.after(coursePromo.getDateStart()) && today.before(coursePromo.getDateEnd())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<CoachProfiles> findAllCoach() {
		List<CoachProfiles> profileList = dao.selectAllCoach();
		for (CoachProfiles profile : profileList) {
			User user = dao.selectUserById(profile.getUserId());
			profile.setCoachName(user.getName());
			profile.setAvatarUrl(user.getAvatarUrl());
		}
		return profileList;
	}

	@Override
	public Boolean coachApprovalStatus(User user) {
		CoachProfiles profile = coachDao.selectByUserId(user.getUserId());
		if ("通過".equals(profile.getApprovalStatus())) {
			return true;
		} else {
			return false;
		}
	}
	
}
