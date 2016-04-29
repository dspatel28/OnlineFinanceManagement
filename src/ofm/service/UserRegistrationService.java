package ofm.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ofm.beans.Address;
import ofm.beans.Bank;
import ofm.beans.BankTransaction;
import ofm.beans.Bill;
import ofm.beans.Connection;
import ofm.beans.Contact;
import ofm.beans.Login;
import ofm.beans.OtherExpenses;
import ofm.beans.User;
import ofm.dao.DAO;

public class UserRegistrationService 
{
	DAO dao;
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	
	public UserRegistrationService()
	{
		dao = new DAO();
	}
	
	public void registerUser(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		Integer userId = dao.addUser(user);
		
		Address address = new Address();
		address.setAddressLine1(request.getParameter("addressLine1"));
		address.setAddressLine2(request.getParameter("addressLine2"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setCountry(request.getParameter("country"));
		address.setZipcode(request.getParameter("zipcode"));
		Integer addressId = dao.addAddress(address);
		
		Login login = new Login();
		login.setUserName(request.getParameter("userName"));
		login.setPassword(request.getParameter("password"));
		login.setUserId(userId);
		dao.addLogin(login);
		
		Contact contact = new Contact();
		contact.setContactNo(request.getParameter("contactNo"));
		contact.setEmailAddress(request.getParameter("emailAddress"));
		contact.setAddressId(addressId);
		contact.setUserId(userId);
		dao.addContact(contact);
		
		String msg = user.getFirstName() + " " + user.getLastName() +" has been registered successfully.";
		request.setAttribute("msg", msg);	
		request.setAttribute("user", user);	
		request.getRequestDispatcher("/pages/UserRegistration.jsp").forward(request,response);	
	}
	
	public void viewPersonalDetails(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		
		User user = dao.searchUser(userId);
		Contact contact = dao.searchContact(userId);
		Address address = dao.searchAddress(contact.getAddressId());
		
		request.setAttribute("user", user);	
		request.setAttribute("contact", contact);	
		request.setAttribute("address", address);	
		
		request.getRequestDispatcher("/pages/UpdatePersonalDetails.jsp").forward(request,response);	
	}
	
	public void updatePersonalDetails(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		User user = new User();
		user.setId(Integer.parseInt(request.getParameter("userId")));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		dao.updateUser(user);
		
		Address address = new Address();
		address.setId(Integer.parseInt(request.getParameter("addressId")));
		address.setAddressLine1(request.getParameter("addressLine1"));
		address.setAddressLine2(request.getParameter("addressLine2"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setCountry(request.getParameter("country"));
		address.setZipcode(request.getParameter("zipcode"));
		dao.updateAddress(address);
		
		Contact contact = new Contact();
		contact.setId(Integer.parseInt(request.getParameter("contactId")));
		contact.setContactNo(request.getParameter("contactNo"));
		contact.setEmailAddress(request.getParameter("emailAddress"));
		dao.updateContact(contact);
		
		String msg = "Personal details updated successfully.";
		request.setAttribute("msg", msg);	
		request.setAttribute("user", user);	
		request.getRequestDispatcher("/pages/UserHome.jsp").forward(request,response);		
	}
	
	public void viewAddBank(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		User user = dao.searchUser(userId);
		request.setAttribute("user", user);	
		request.getRequestDispatcher("/pages/AddBankDetails.jsp").forward(request,response);	
	}
	
	public void addBankDetails(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		User user = dao.searchUser(Integer.parseInt(request.getParameter("userId")));
		
		Address address = new Address();
		address.setAddressLine1(request.getParameter("addressLine1"));
		address.setAddressLine2(request.getParameter("addressLine2"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setCountry(request.getParameter("country"));
		address.setZipcode(request.getParameter("zipcode"));
		Integer addressId = dao.addAddress(address);
		
		Bank bank = new Bank();
		bank.setAccountNumber(request.getParameter("accountNumber"));
		bank.setAccountOpenDate(df.parse(request.getParameter("accountOpenDate")));
		bank.setAddressId(addressId);
		bank.setBranch(request.getParameter("branch"));
		bank.setName(request.getParameter("name"));
		bank.setUserId(user.getId());
		dao.addBank(bank);
		
		String msg = "Bank details added successfully.";
		request.setAttribute("msg", msg);	
		request.setAttribute("user", user);	
		request.getRequestDispatcher("/pages/UserHome.jsp").forward(request,response);	
	}
	
	public void viewBanks(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		User user = dao.searchUser(userId);		
		List<Bank> banks = dao.searchBanks(userId);
		request.setAttribute("user", user);	
		request.setAttribute("banks", banks);	
		request.getRequestDispatcher("/pages/ShowBank.jsp").forward(request,response);	
	}
	
	public void viewBank(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Integer bankId = Integer.parseInt(request.getParameter("bankId"));
		Bank bank = dao.searchBank(bankId);		
		User user = dao.searchUser(bank.getUserId());	
		Address address = dao.searchAddress(bank.getAddressId());	
		
		request.setAttribute("user", user);	
		request.setAttribute("bank", bank);	
		request.setAttribute("address", address);	
		request.getRequestDispatcher("/pages/UpdateBankDetails.jsp").forward(request,response);	
	}
	
	public void updateBankDetails(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Bank bank = new Bank();
		bank.setAccountNumber(request.getParameter("accountNumber"));
		bank.setAccountOpenDate(df.parse(request.getParameter("accountOpenDate")));
		bank.setBranch(request.getParameter("branch"));
		bank.setName(request.getParameter("name"));
		bank.setId(Integer.parseInt(request.getParameter("bankId")));
		dao.updateBank(bank);
		
		Address address = new Address();
		address.setId(Integer.parseInt(request.getParameter("addressId")));
		address.setAddressLine1(request.getParameter("addressLine1"));
		address.setAddressLine2(request.getParameter("addressLine2"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setCountry(request.getParameter("country"));
		address.setZipcode(request.getParameter("zipcode"));
		dao.updateAddress(address);
		
		User user = dao.searchUser(Integer.parseInt(request.getParameter("userId")));
		
		String msg = "Bank details updated successfully.";
		request.setAttribute("msg", msg);	
		request.setAttribute("user", user);	
		request.getRequestDispatcher("/pages/UserHome.jsp").forward(request,response);		
	}
	public void viewAddConnection(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		User user = dao.searchUser(userId);
		request.setAttribute("user", user);	
		request.getRequestDispatcher("/pages/AddConnection.jsp").forward(request,response);	
	}
	
	public void addConnection(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		User user = dao.searchUser(Integer.parseInt(request.getParameter("userId")));
		
		Connection connection = new Connection();
		connection.setRegistrationNo(request.getParameter("registrationNo"));
		connection.setStartDate(df.parse(request.getParameter("startDate")));
		connection.setSupplierName(request.getParameter("supplierName"));
		connection.setType(request.getParameter("type"));
		connection.setUserId(user.getId());
		dao.addConnection(connection);
		
		String msg = "Connection details added successfully.";
		request.setAttribute("msg", msg);	
		request.setAttribute("user", user);	
		request.getRequestDispatcher("/pages/UserHome.jsp").forward(request,response);	
	}
	
	public void viewConnections(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		User user = dao.searchUser(userId);		
		List<Connection> connections = dao.searchConnections(userId);
		request.setAttribute("user", user);	
		request.setAttribute("connections", connections);	
		request.getRequestDispatcher("/pages/ShowConnection.jsp").forward(request,response);	
	}
	
	public void viewConnection(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Integer connectionId = Integer.parseInt(request.getParameter("connectionId"));
		Connection connection = dao.searchConnection(connectionId);		
		User user = dao.searchUser(connection.getUserId());	
		
		request.setAttribute("user", user);	
		request.setAttribute("connection", connection);	
		request.getRequestDispatcher("/pages/UpdateConnection.jsp").forward(request,response);	
	}
	
	public void updateConnection(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Connection connection = new Connection();
		connection.setRegistrationNo(request.getParameter("registrationNo"));
		connection.setStartDate(df.parse(request.getParameter("startDate")));
		connection.setSupplierName(request.getParameter("supplierName"));
		connection.setType(request.getParameter("type"));
		connection.setId(Integer.parseInt(request.getParameter("connectionId")));
		dao.updateConnection(connection);
		
		User user = dao.searchUser(Integer.parseInt(request.getParameter("userId")));
		
		String msg = "Connection details updated successfully.";
		request.setAttribute("msg", msg);	
		request.setAttribute("user", user);	
		request.getRequestDispatcher("/pages/UserHome.jsp").forward(request,response);		
	}
	
	public void viewAddBill(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		
		User user = dao.searchUser(userId);
		List<Connection> connections = dao.searchConnections(userId);
		
		request.setAttribute("user", user);	
		request.setAttribute("connections", connections);	
		
		request.getRequestDispatcher("/pages/AddBill.jsp").forward(request,response);	
	}
	
	public void addBill(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		User user = dao.searchUser(Integer.parseInt(request.getParameter("userId")));
		
		Bill bill = new Bill();
		bill.setBillAmount(request.getParameter("billAmount"));
		bill.setConnectionType( Integer.parseInt(request.getParameter("type")));
		bill.setDueDate(df.parse(request.getParameter("dueDate")));
		bill.setReminderDate(df.parse(request.getParameter("dueDate")));
		bill.setPaid(false);
		dao.addBill(bill);
		
		String msg = "Bill details added successfully.";
		request.setAttribute("msg", msg);	
		request.setAttribute("user", user);	
		request.getRequestDispatcher("/pages/UserHome.jsp").forward(request,response);	
	}
	
	public void viewAddPurchase(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		User user = dao.searchUser(userId);
		request.setAttribute("user", user);	
		
		request.getRequestDispatcher("/pages/AddOtherExpenses.jsp").forward(request,response);	
	}
	
	public void addPurchase(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		User user = dao.searchUser(Integer.parseInt(request.getParameter("userId")));
		
		OtherExpenses oe = new OtherExpenses();
		
		
		oe.setName(request.getParameter("name"));
		oe.setDescription(request.getParameter("description"));
		oe.setAmount(Double.parseDouble(request.getParameter("amount")));
		oe.setUserId(user.getId());
		oe.setPaid(false);
		dao.addPurchase(oe);
		
		String msg = "Other expense details added successfully.";
		request.setAttribute("msg", msg);	
		request.setAttribute("user", user);	
		request.getRequestDispatcher("/pages/UserHome.jsp").forward(request,response);	
	}
	
	public void viewMakePayment(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		User user = dao.searchUser(userId);
		
		List<OtherExpenses> expenses = dao.searchBillsAndPurchases(userId);
		request.setAttribute("user", user);	
		request.setAttribute("expenses", expenses);
		
		request.getRequestDispatcher("/pages/MakePayment.jsp").forward(request,response);	
	}
	
	public void makePayment(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		User user = dao.searchUser(Integer.parseInt(request.getParameter("userId")));
		
		String type = request.getParameter("type");
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		if(type.equalsIgnoreCase("phone") || type.equalsIgnoreCase("internet") || type.equalsIgnoreCase("gas") || type.equalsIgnoreCase("electricity"))
		{
			Bill bill = new Bill();
			bill.setId(id);
			bill.setPaid(true);
			bill.setPaymentDate(new Date());
			dao.updateBill(bill);
		}
		else
		{
			OtherExpenses oe = new OtherExpenses();
			oe.setId(id);
			oe.setPaid(true);
			oe.setPaymentDate(new Date());
			dao.updatePurchse(oe);
		}
		
		List<OtherExpenses> expenses = dao.searchBillsAndPurchases(user.getId());
		
		String msg = "Payment details updated successfully.";
		request.setAttribute("msg", msg);	
		request.setAttribute("user", user);	
		request.setAttribute("expenses", expenses);
		request.getRequestDispatcher("/pages/MakePayment.jsp").forward(request,response);	
	}
	
	public void viewAccountSummary(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		User user = dao.searchUser(userId);
		List<OtherExpenses> expenses = dao.viewSummary(userId);
		request.setAttribute("user", user);	
		request.setAttribute("expenses", expenses);
		
		request.getRequestDispatcher("/pages/ViewAccountSummary.jsp").forward(request,response);	
	}
	
	public void viewAddTransaction(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		
		User user = dao.searchUser(userId);
		List<Bank> banks = dao.searchBanks(userId);
		
		request.setAttribute("user", user);	
		request.setAttribute("banks", banks);	
		
		request.getRequestDispatcher("/pages/AddBankTransaction.jsp").forward(request,response);	
	}
	
	public void addTransaction(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		User user = dao.searchUser(Integer.parseInt(request.getParameter("userId")));
		
		BankTransaction bt = new BankTransaction();
		bt.setAmount(request.getParameter("amount"));
		bt.setBankId(Integer.parseInt(request.getParameter("bankId")));
		bt.setTransactionDate(df.parse(request.getParameter("transactionDate")));
		bt.setType(request.getParameter("type"));
		dao.addTransaction(bt);
		
		String msg = "Bank Transaction details added successfully.";
		request.setAttribute("msg", msg);	
		request.setAttribute("user", user);	
		request.getRequestDispatcher("/pages/UserHome.jsp").forward(request,response);	
	}
	
	public void goToHome(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		
		User user = dao.searchUser(userId);
		request.setAttribute("user", user);	
		request.getRequestDispatcher("/pages/UserHome.jsp").forward(request,response);		
	}
}
