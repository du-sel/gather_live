package listener;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import dao.DAO;
import handler.AccountHandler;
import handler.ChangePWHandler;
import handler.DeleteAccountHandler;
import handler.EmailValHandler;
import handler.InsertHandler;
import handler.LikeProfileHandler;
import handler.LoginHandler;
import handler.LogoutHandler;
import handler.MyAccountHandler;
import handler.MyPageHandler;
import handler.MyProfileAccountHandler;
import handler.MyProfileHandler;
import handler.MyProfileInstHandler;
import handler.MyProfileLocaHandler;
import handler.MyProfilePrefHandler;
import handler.ProfileHandler;
import handler.ProfileListHandler;
import handler.ProfilePostHandler;
import handler.RecruitWriteHandler;
import handler.WelcomeHandler;
import model.Criteria;
import model.PageLimit;

public class ContextLoaderListener implements ServletContextListener {


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		try {

			
			ServletContext context = sce.getServletContext();
			InitialContext itContext = new InitialContext();
			
			DataSource ds = (DataSource)itContext.lookup("java:comp/env/jdbc/gather_live");
		
			DAO dao = new DAO();
			dao.setDataSource(ds);
			
			
			context.setAttribute("/join/email.do", new EmailValHandler().setDAO(dao));
			context.setAttribute("/join/account.do", new AccountHandler().setDAO(dao));
			context.setAttribute("/join/insert.do", new InsertHandler().setDAO(dao));
			context.setAttribute("/join/prfl.do", new ProfileHandler().setDAO(dao));
			context.setAttribute("/join/welcome.do", new WelcomeHandler());
			
			context.setAttribute("/member/login.do", new LoginHandler().setDAO(dao));
			context.setAttribute("/member/logout.do", new LogoutHandler());
			
			context.setAttribute("/my/main.do", new MyPageHandler().setDAO(dao));
			context.setAttribute("/my/account.do", new MyAccountHandler());
			context.setAttribute("/my/prfl.do", new MyProfileHandler().setDAO(dao));
			context.setAttribute("/my/changePW.do", new ChangePWHandler().setDAO(dao));
			context.setAttribute("/my/delAccount.do", new DeleteAccountHandler().setDAO(dao));
			
			context.setAttribute("/my/prfl/account.do", new MyProfileAccountHandler().setDAO(dao));
			context.setAttribute("/my/prfl/instrument.do", new MyProfileInstHandler().setDAO(dao));
			context.setAttribute("/my/prfl/location.do", new MyProfileLocaHandler().setDAO(dao));
			context.setAttribute("/my/prfl/pref.do", new MyProfilePrefHandler().setDAO(dao));
	
			context.setAttribute("/prfl/list.do", new ProfileListHandler().setDAO(dao));
			context.setAttribute("/prfl/post.do", new ProfilePostHandler().setDAO(dao));
			context.setAttribute("/prfl/like.do", new LikeProfileHandler().setDAO(dao));

			context.setAttribute("/rcrt/write.do", new RecruitWriteHandler().setDAO(dao));
			
			//context.setAttribute("/admin/uploadAjaxAction.do", new ().setDAO(dao));

			
			
			context.setAttribute("FINALINST", dao.getFinalInst());
			context.setAttribute("FINALLOCA", dao.getFinalLoca());
			
			context.setAttribute("JSONINST", dao.getJSONInst());
			context.setAttribute("JSONLOCA", dao.getJSONLoca());
			
			context.setAttribute("MAINPRFL", dao.getPagedMembers(new Criteria(), new PageLimit(1)));
			

			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {}
}
