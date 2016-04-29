package ofm.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ofm.service.LoginService;

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 6480180819915619598L;
	public LoginServlet() 
    {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	try
		{
    		LoginService service = new LoginService();
    		service.verifyUser(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			request.getRequestDispatcher("pages/Error.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
