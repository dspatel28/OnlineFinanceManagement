package ofm.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ofm.service.UserRegistrationService;

public class UserRegistrationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public UserRegistrationServlet() 
    {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			String actionField = request.getParameter("actionField");
			
			if(actionField.equals("viewHome"))
			{
				response.sendRedirect("pages/UserRegistration.jsp");
			}
			else if(actionField.equals("register"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.registerUser(request, response);
			}
			else if(actionField.equals("viewPersonalDetails"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.viewPersonalDetails(request, response);
			}
			else if(actionField.equals("updatePersonalDetails"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.updatePersonalDetails(request, response);
			}
			else if(actionField.equals("viewAddBank"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.viewAddBank(request, response);
			}
			else if(actionField.equals("addBankDetails"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.addBankDetails(request, response);
			}
			else if(actionField.equals("viewBanks"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.viewBanks(request, response);
			}
			else if(actionField.equals("viewBank"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.viewBank(request, response);
			}
			else if(actionField.equals("updateBankDetails"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.updateBankDetails(request, response);
			}
			else if(actionField.equals("viewAddConnection"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.viewAddConnection(request, response);
			}
			else if(actionField.equals("addConnection"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.addConnection(request, response);
			}
			else if(actionField.equals("viewConnections"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.viewConnections(request, response);
			}
			else if(actionField.equals("viewConnection"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.viewConnection(request, response);
			}
			else if(actionField.equals("updateConnection"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.updateConnection(request, response);
			}
			else if(actionField.equals("viewAddBill"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.viewAddBill(request, response);
			}
			else if(actionField.equals("addBill"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.addBill(request, response);
			}
			else if(actionField.equals("viewAddPurchase"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.viewAddPurchase(request, response);
			}
			else if(actionField.equals("addPurchase"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.addPurchase(request, response);
			}
			else if(actionField.equals("viewMakePayment"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.viewMakePayment(request, response);
			}
			else if(actionField.equals("makePayment"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.makePayment(request, response);
			}
			else if(actionField.equals("viewAccountSummary"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.viewAccountSummary(request, response);
			}
			else if(actionField.equals("viewAddTransaction"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.viewAddTransaction(request, response);
			}
			else if(actionField.equals("addTransaction"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.addTransaction(request, response);
			}
			else if(actionField.equals("goToHome"))
			{
				UserRegistrationService service = new UserRegistrationService();
				service.goToHome(request, response);
			}
			else if(actionField.equals("logout"))
			{
				request.getRequestDispatcher("pages/Home.jsp").forward(request, response);
			}
		} 
		catch (Exception e) 
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
