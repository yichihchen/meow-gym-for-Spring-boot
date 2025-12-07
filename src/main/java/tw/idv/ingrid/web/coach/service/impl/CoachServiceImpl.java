package tw.idv.ingrid.web.coach.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tw.idv.ingrid.core.util.FileUtil;
import tw.idv.ingrid.web.coach.dao.CoachDao;
import tw.idv.ingrid.web.coach.pojo.*;
import tw.idv.ingrid.web.coach.service.CoachService;
import tw.idv.ingrid.web.course.service.CourseService;
import tw.idv.ingrid.web.user.pojo.User;

@Service
@Transactional
public class CoachServiceImpl implements CoachService {
	@Autowired
	private CoachDao dao;
	
	@Autowired
	private CourseService service;

	@Override
	public List<CoachAndUser> findCoachAndUser() {
		List<CoachAndUser> cuList = new ArrayList<>();
		List<User> userList = dao.selectAllUser();
		for (User user : userList) {
			CoachAndUser coachAndUser = new CoachAndUser();
			CoachProfiles cp = dao.selectByUserId(user.getUserId());
			if(cp != null) {
				coachAndUser.setCoachProfiles(cp);
			}
			coachAndUser.setUser(user);
			cuList.add(coachAndUser);
		}
		return cuList;
	}

	@Override
	public boolean inviteCoach(Integer userId) throws ParseException {
		int count = dao.updateRole(userId);
		if (count <= 0) {
			return false;
		}
		
		CoachProfiles profiles = new CoachProfiles();
		profiles.setApprovalStatus("待審核");
		profiles.setUserId(userId);
		profiles.setBio("");
		count = dao.insertCoachProfiles(profiles);
		if (count != 1) {
			return false;
		}
		Integer coachId = profiles.getCoachId();
		
		CoachCertificates certificates = new CoachCertificates();
		certificates.setCoachId(coachId);
		certificates.setName("");
		certificates.setFileUrl("");
		count = dao.insertCoachCertificates(certificates);
		if (count != 1) {
			return false;
		}
		
		CoachEducations educations = new CoachEducations();
		educations.setCoachId(coachId);
		educations.setSchool("");
		educations.setDegree("");
		count = dao.insertCoachEducations(educations);
		if (count != 1) {
			return false;
		}
		
		CoachExperiences experiences = new CoachExperiences();
		String dateStr = "2025-01-01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date initDate = sdf.parse(dateStr);
		experiences.setCoachId(coachId);
		experiences.setCompany("");
		experiences.setTitle("");
		experiences.setStartDate(initDate);
		experiences.setEndDate(initDate);
		count = dao.insertCoachExperiences(experiences);
		if (count != 1) {
			return false;
		}
		
		return true;
	}

	@Override
	public CoachProfiles findProfile(Integer userId) {
		return dao.selectByUserId(userId);
	}

	@Override
	public CoachCertificates findCertificate(Integer coachId) {
		return dao.selectCertificateByCoachId(coachId);
	}

	@Override
	public CoachEducations findEducation(Integer coachId) {
		return dao.selectEducationByCoachId(coachId);
	}

	@Override
	public CoachExperiences findExperience(Integer coachId) {
		return dao.selectExperienceByCoachId(coachId);
	}

	@Override
	public boolean updateCoachData(CoachApplyUpdateRequest request) throws IOException {
		int count;
		
		count = dao.updateProfileBio(request.getProfile());
		if(count != 1) return false;
		
		count = dao.updateEducation(request.getEducation());
		if(count != 1) return false;
		
		count = dao.updateExperience(request.getExperience());
		if(count != 1) return false;
		
		String imgBase64 = request.getImgBase64();
		CoachCertificates certificate = request.getCertificate();
		if (imgBase64 != null && !imgBase64.isEmpty()) {
			String fileName = service.addTimestampToFileName(request.getFileName());
			String fullPath = FileUtil.IMG_ROOT_PATH + fileName;
			byte[] img = Base64.getDecoder().decode(imgBase64);
			Path path = Paths.get(fullPath);
			Files.write(path, img);		
			certificate.setFileUrl("/meow-gym/course/img/" + fileName);
		} else {
			certificate.setFileUrl("");
		}
		
		count = dao.updateCertificate(certificate);
		if(count != 1) return false;
		
		return true;
	}

	@Override
	public User findUser(Integer userId) {
		return dao.selectUserById(userId);
	}

	@Override
	public Boolean updateApprovalStatus(CoachProfiles profile) {
		int count = dao.updateApprovalStatus(profile);
		return count > 0 ? true : false;
	}

	
}
