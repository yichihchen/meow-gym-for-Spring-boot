package tw.idv.ingrid.web.chat.dao;

import java.util.List;


import tw.idv.ingrid.core.dao.CoreDao;
import tw.idv.ingrid.web.chat.pojo.ChatDTO;
import tw.idv.ingrid.web.chat.pojo.Chats;
import tw.idv.ingrid.web.chat.pojo.UserCourseDTO;
import tw.idv.ingrid.web.user.pojo.User;

public interface ChatDao extends CoreDao<User, Integer> {

	int insert(Chats chats);

	List<Chats> selectChatsByCourseId(Integer courseId);
	
	List<ChatDTO> selectCourseChatsWithUser(Integer courseId); //為了user_id要對應到name而製作的, 並未連通到資料庫
	
	Integer selectCoachIdByCourse(Integer courseId); //找課堂上教練
	
	 //寫入後立刻帶回 DB 寫入完成的 Entity（含 id、created_at)
	Chats saveAndLoad(Chats chats);

	List<UserCourseDTO> selectUserCourseId(Integer role);
	
	//使用courseId 查詢課程名稱
	String selectCourseTitle(Integer courseId);



}