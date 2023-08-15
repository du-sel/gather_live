package handler;

import java.util.HashMap;

public class WelcomeHandler implements CommonHandler {

	@Override
	public String execute(HashMap<String, Object> map) {
		
		return "/code/05_join_4.jsp";
	}

}
