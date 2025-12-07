package tw.idv.ingrid.web.chat.service;


import tw.idv.ingrid.web.chat.pojo.Chats;

public interface ChatService {
	 //copy the saveAndLoad method from DAO to Service layer.
	Chats saveAndLoad(Chats chats);
}
