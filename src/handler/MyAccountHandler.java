package handler;

import java.util.HashMap;

public class MyAccountHandler implements CommonHandler {

	@Override
	public String execute(HashMap<String, Object> map) {
		
		return "/code/03_my_account.jsp";
	}

}
