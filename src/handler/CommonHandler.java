package handler;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommonHandler {

	public String execute(HashMap<String, Object> map);
	
}

