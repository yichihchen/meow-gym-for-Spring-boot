package tw.idv.ingrid.web.coach.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;


import tw.idv.ingrid.web.coach.pojo.*;
import tw.idv.ingrid.web.user.pojo.User;

public interface CoachService {
	
	List<CoachAndUser> findCoachAndUser();
	
	boolean inviteCoach(Integer userId) throws ParseException;
	
	CoachProfiles findProfile(Integer userId);
	
	CoachCertificates findCertificate(Integer coachId);
	
	CoachEducations findEducation(Integer coachId);
	
	CoachExperiences findExperience(Integer coachId);
	
	User findUser(Integer userId);
	
	boolean updateCoachData(CoachApplyUpdateRequest request) throws IOException;

	Boolean updateApprovalStatus(CoachProfiles profile);
}
