package tw.idv.ingrid.web.chat.config;


import jakarta.servlet.http.HttpSession;
import jakarta.websocket.HandshakeResponse;
import jakarta.websocket.server.HandshakeRequest;
import jakarta.websocket.server.ServerEndpointConfig;

import java.util.Map;



public class HttpSessionConfigurator extends ServerEndpointConfig.Configurator {
	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest req, HandshakeResponse resp) {
		// EndpointConfig 是 ServerEndpointConfig 的父類別
		// 將session資料傳到ws的servlet
		
		//拿出 WebSocket 設定的屬性 Map
		Map<String, Object> userMap = sec.getUserProperties();
		System.out.println("userMap getUserProperties" + userMap);
		
		//** 重要!!從 HandshakeRequest 取得目前使用者的 HttpSession
		HttpSession httpSession = (HttpSession) req.getHttpSession(); //null
		
		//把 HttpSession 放到 WebSocket 的設定屬性裡
		userMap.put("httpSession", httpSession);
		System.out.println("userMap put httpsession" + userMap);

	}
}
