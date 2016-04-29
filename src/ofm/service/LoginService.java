package ofm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ofm.beans.User;
import ofm.dao.DAO;

public class LoginService 
{
	DAO dao;
	
	public LoginService()
	{
		dao = new DAO();
	}
	
	public void verifyUser(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		Integer userId =  dao.verifyUser(userName, password);
		
		if(null != userId)
		{
			User user = dao.searchUser(userId);
			
			if(null != user)
			{
				request.setAttribute("user", user);	
				request.getRequestDispatcher("/pages/UserHome.jsp").forward(request,response);
			}
			else
			{
				request.setAttribute("msg", "User does not exist in the system.");		
				request.getRequestDispatcher("/pages/Home.jsp").forward(request,response);
			}
		}
		else
		{
			request.setAttribute("msg", "Invalid user name or password.");		
			request.getRequestDispatcher("/pages/Home.jsp").forward(request,response);
		}
	}
}
