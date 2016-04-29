package ofm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ofm.beans.Address;
import ofm.beans.Bank;
import ofm.beans.BankTransaction;
import ofm.beans.Bill;
import ofm.beans.Contact;
import ofm.beans.Login;
import ofm.beans.OtherExpenses;
import ofm.beans.User;

public class DAO 
{
	private PreparedStatement preparedStatement = null;
	
	private Connection getConnection() throws Exception
	{
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ofm", "root", "dspatel28");
		return connection;
	}
	
	public Integer verifyUser(String userName, String password) throws Exception
	{
		Integer userId= null;
		
		preparedStatement = getConnection().prepareStatement("select l.userId from Login l where l.userName =? and l.password =?");
		preparedStatement.setString(1, userName);
		preparedStatement.setString(2, password);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		if(rs.next())
		{
			userId = rs.getInt("userId");
		}
		return userId;
	}
	
	public User searchUser(int userId) throws Exception
	{
		User u = null;
		preparedStatement = getConnection().prepareStatement("select u.firstName, u.LastName from User u where id =?");
		preparedStatement.setInt(1, userId);
		
		ResultSet rs = preparedStatement.executeQuery();		
			
		if(rs.next())
		{
			u = new User();
			u.setId(userId);
			u.setFirstName(rs.getString("firstName"));
			u.setLastName(rs.getString("lastName"));	
		}
			
		return u;
	}
	
	public Integer addUser(User user) throws Exception
	{
		Integer userId = null;
		
		preparedStatement = getConnection().prepareStatement("insert into User (firstName, lastName) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, user.getFirstName());
		preparedStatement.setString(2, user.getLastName());
		
		preparedStatement.executeUpdate();
		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) 
		{
			userId = rs.getInt(1);
		}
		
		return userId; 		
	}
	
	public void updateUser(User user) throws Exception
	{
		preparedStatement = getConnection().prepareStatement("update User set firstName =?, lastName=? where id =?");
		preparedStatement.setString(1, user.getFirstName());
		preparedStatement.setString(2, user.getLastName());
		preparedStatement.setInt(3, user.getId());
		preparedStatement.executeUpdate();	
	}
	
	public Integer addLogin(Login login) throws Exception
	{
		Integer loginId = null;
		
		preparedStatement = getConnection().prepareStatement("insert into Login (userName, password, userId) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, login.getUserName());
		preparedStatement.setString(2, login.getPassword());
		preparedStatement.setInt(3, login.getUserId());
		
		preparedStatement.executeUpdate();
		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) 
		{
			loginId = rs.getInt(1);
		}
		
		return loginId; 		
	}
	
	public Integer addAddress(Address address) throws Exception
	{
		Integer addressId = null;
				
		preparedStatement = getConnection().prepareStatement("insert into Address (addressLine1, addressLine2, city, state, country, zipcode) values (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, address.getAddressLine1());
		preparedStatement.setString(2, address.getAddressLine2());
		preparedStatement.setString(3, address.getCity());
		preparedStatement.setString(4, address.getState());
		preparedStatement.setString(5, address.getCountry());
		preparedStatement.setString(6, address.getZipcode());
		preparedStatement.executeUpdate();	
		
		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) 
		{
			addressId = rs.getInt(1);
		}
		
		return addressId;
	}
		
	public void updateAddress(Address address) throws Exception
	{
		
		preparedStatement = getConnection().prepareStatement("update Address set addressLine1 =?, addressLine2=?, city=?, state=?, country=?, zipcode=? where id =?");
		
		preparedStatement.setString(1, address.getAddressLine1());
		preparedStatement.setString(2, address.getAddressLine2());
		preparedStatement.setString(3, address.getCity());
		preparedStatement.setString(4, address.getState());
		preparedStatement.setString(5, address.getCountry());
		preparedStatement.setString(6, address.getZipcode());
		preparedStatement.setInt(7, address.getId());
		
		preparedStatement.executeUpdate();	
	}
		
	public Address searchAddress(int addressId) throws Exception
	{
		Address addr = null;
		
		preparedStatement = getConnection().prepareStatement("select a.addressLine1, a.addressLine2, a.city, a.state, a.country, a.zipcode from Address a where id =?");
		preparedStatement.setInt(1, addressId);
		
		ResultSet rs = preparedStatement.executeQuery();		
		
		if(rs.next())
		{
			addr = new Address();
			addr.setId(addressId);
			addr.setAddressLine1(rs.getString("addressLine1"));
			addr.setAddressLine2(rs.getString("addressLine2"));	
			addr.setCity(rs.getString("city"));
			addr.setState(rs.getString("state"));
			addr.setCountry(rs.getString("country"));
			addr.setZipcode(rs.getString("zipcode"));
		}
			
		return addr;
	}
	
	public Integer addContact(Contact contact) throws Exception
	{
		Integer contactId = null;
				
		preparedStatement = getConnection().prepareStatement("insert into Contact (contactNo, emailAddress, userId, addressId) values (?, ?, ?, ?)",  Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, contact.getContactNo());
		preparedStatement.setString(2, contact.getEmailAddress());
		preparedStatement.setInt(3, contact.getUserId());
		preparedStatement.setInt(4, contact.getAddressId());
		
		preparedStatement.executeUpdate();		
		
		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) 
		{
			contactId = rs.getInt(1);
		}
		
		return contactId;
	}
			
	public void updateContact(Contact contact) throws Exception
	{
		preparedStatement = getConnection().prepareStatement("update Contact set contactNo =?, emailAddress=? where id =?");
		preparedStatement.setString(1, contact.getContactNo());
		preparedStatement.setString(2, contact.getEmailAddress());
		preparedStatement.setInt(3, contact.getId());
		preparedStatement.executeUpdate();	
	}
			
	public Contact searchContact(int userId) throws Exception
	{
		Contact contact = null;
		
		preparedStatement = getConnection().prepareStatement("select c.id, c.contactNo, c.emailAddress, c.addressId from Contact c where c.userId =?");
		preparedStatement.setInt(1, userId);
		
		ResultSet rs = preparedStatement.executeQuery();		
		
		if(rs.next())
		{
			contact = new Contact();
			contact.setId(rs.getInt("id"));
			contact.setContactNo(rs.getString("contactNo"));
			contact.setEmailAddress(rs.getString("emailAddress"));	
			contact.setAddressId(rs.getInt("addressId"));
		}
			
		return contact;
	}
	
	public Integer addBank(Bank bank) throws Exception
	{
		Integer bankId = null;
				
		preparedStatement = getConnection().prepareStatement("insert into Bank (name, branch, addressId, accountNumber, accountOpenDate, userId) values (?, ?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, bank.getName());
		preparedStatement.setString(2, bank.getBranch());
		preparedStatement.setInt(3, bank.getAddressId());
		preparedStatement.setString(4, bank.getAccountNumber());
		preparedStatement.setDate(5, new java.sql.Date(bank.getAccountOpenDate().getTime()));
		preparedStatement.setInt(6, bank.getUserId());
		
		preparedStatement.executeUpdate();		
		
		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) 
		{
			bankId = rs.getInt(1);
		}
		
		return bankId;
	}
	
	public List<Bank> searchBanks(int userId) throws Exception
	{
		preparedStatement  = getConnection().prepareStatement("select b.id, b.name, b.branch, b.addressId, b.accountNumber, b.accountOpenDate from Bank b where b.userId =?");
		preparedStatement.setInt(1, userId);
		ResultSet rs = preparedStatement.executeQuery();
		
		List<Bank> bankList = new ArrayList<Bank>();
		while (rs.next()) 
		{
		    Bank bank = new Bank();
		    bank.setId(rs.getInt(1));
		    bank.setName(rs.getString(2));
		    bank.setBranch(rs.getString(3));
		    bank.setAddressId(rs.getInt(4));
		    bank.setAccountNumber(rs.getString(5));
		    bank.setAccountOpenDate(rs.getDate(6));
		    
		    bankList.add(bank);
		}
		
		return bankList;
	}
	
	public Bank searchBank(int bankId) throws Exception
	{
		Bank bank = null;
		
		preparedStatement = getConnection().prepareStatement("select b.name, b.branch, b.addressId, b.accountNumber, b.accountOpenDate, b.userId from Bank b where b.id  =?");
		preparedStatement.setInt(1, bankId);
		ResultSet rs = preparedStatement.executeQuery();		
		
		if(rs.next())
		{
			bank = new Bank();
			bank.setName(rs.getString("name"));
			bank.setBranch(rs.getString("branch"));
			bank.setAddressId(rs.getInt("addressId"));
			bank.setAccountNumber(rs.getString("accountNumber"));	
			bank.setAccountOpenDate(rs.getDate("accountOpenDate"));
			bank.setUserId(rs.getInt("userId"));
			bank.setId(bankId);
		}
			
		return bank;
	}
	
	public void updateBank(Bank bank) throws Exception
	{
		preparedStatement = getConnection().prepareStatement("update Bank set name =?, branch=?, accountNumber =?, accountOpenDate =? where id =?");
		
		preparedStatement.setString(1, bank.getName());
		preparedStatement.setString(2, bank.getBranch());
		preparedStatement.setString(3, bank.getAccountNumber());
		preparedStatement.setDate(4, new java.sql.Date(bank.getAccountOpenDate().getTime()));
		preparedStatement.setInt(5, bank.getId());
		
		preparedStatement.executeUpdate();	
	}
	
	 public Integer addConnection(ofm.beans.Connection conn) throws Exception
	{
		Integer connId = null;
				
		preparedStatement = getConnection().prepareStatement("insert into Connection (type, supplierName, startDate, userId, registrationNo) values (?, ?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
		
		preparedStatement.setString(1, conn.getType()); 
		preparedStatement.setString(2, conn.getSupplierName());
		preparedStatement.setDate(3, new java.sql.Date(conn.getStartDate().getTime()));
		preparedStatement.setInt(4, conn.getUserId());
		preparedStatement.setString(5, conn.getRegistrationNo());
		
		preparedStatement.executeUpdate();		
		
		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) 
		{
			connId = rs.getInt(1);
		}
		
		return connId;
	}
	
	public List<ofm.beans.Connection> searchConnections(int userId) throws Exception
	{
		preparedStatement  = getConnection().prepareStatement("select c.id, c.type, c.supplierName, c.startDate, c.registrationNo from Connection c where c.userId =?");
		
		preparedStatement.setInt(1, userId);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		List<ofm.beans.Connection> connectionList = new ArrayList<ofm.beans.Connection>();
		while (rs.next()) 
		{
			ofm.beans.Connection conn = new ofm.beans.Connection();
		    conn.setId(rs.getInt(1));
		    conn.setType(rs.getString(2));
		    conn.setSupplierName(rs.getString(3));
		    conn.setStartDate(rs.getDate(4));
		    conn.setRegistrationNo(rs.getString(5));
		    conn.setUserId(userId);
		    connectionList.add(conn);
		}
		return connectionList;
	}
	
	public ofm.beans.Connection searchConnection(int connId) throws Exception
	{
		ofm.beans.Connection conn = null;
		
		preparedStatement = getConnection().prepareStatement("select c.type, c.supplierName, c.startDate, c.userId, c.registrationNo from Connection c where c.id  =?");
		
		preparedStatement.setInt(1, connId);
		
		ResultSet rs = preparedStatement.executeQuery();		
		
		if(rs.next())
		{
			conn = new ofm.beans.Connection();
			conn.setType(rs.getString("type"));
			conn.setSupplierName(rs.getString("supplierName"));
			conn.setStartDate(rs.getDate("startDate"));
			conn.setUserId(rs.getInt("userId"));	
			conn.setRegistrationNo(rs.getString("registrationNo"));
			conn.setId(connId);
		}
			
		return conn;
	}
	
	public void updateConnection(ofm.beans.Connection conn) throws Exception
	{
		preparedStatement = getConnection().prepareStatement("update Connection set type =?, supplierName=? , startDate =?, registrationNo =? where id =?");
		
		preparedStatement.setString(1, conn.getType());
		preparedStatement.setString(2, conn.getSupplierName());
		preparedStatement.setDate(3, new java.sql.Date(conn.getStartDate().getTime()));
		preparedStatement.setString(4, conn.getRegistrationNo());
		preparedStatement.setInt(5, conn.getId());
		
		preparedStatement.executeUpdate();	
	}
	
	public Integer addBill(Bill bill) throws Exception
	{
		Integer billId = null;
				
		preparedStatement = getConnection().prepareStatement("insert into Bill (connectionType, dueDate, billAmount, reminderDate, paid) values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		preparedStatement.setInt(1, bill.getConnectionType());
		preparedStatement.setDate(2, new java.sql.Date(bill.getDueDate().getTime()));
		preparedStatement.setString(3, bill.getBillAmount());
		preparedStatement.setDate(4, new java.sql.Date(bill.getReminderDate().getTime()));
		preparedStatement.setBoolean(5, bill.getPaid());
		billId = preparedStatement.executeUpdate();		
		
		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) 
		{
			billId = rs.getInt(1);
		}
		return billId;
	}
	
	public Integer addPurchase(OtherExpenses otherExp) throws Exception
	{
		Integer otherExpId = null;
				
		preparedStatement = getConnection().prepareStatement("insert into OtherExpenses (name, description, amount, userId, paid) values (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		
		preparedStatement.setString(1, otherExp.getName());
		preparedStatement.setString(2, otherExp.getDescription());
		preparedStatement.setDouble(3, otherExp.getAmount());
		preparedStatement.setInt(4, otherExp.getUserId());
		preparedStatement.setBoolean(5, otherExp.getPaid());
		
		otherExpId = preparedStatement.executeUpdate();		
		
		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) 
		{
			otherExpId = rs.getInt(1);
		}
		
		return otherExpId;
	}
	
	public List<OtherExpenses> searchBillsAndPurchases(int userId) throws Exception
	{
		preparedStatement = getConnection().prepareStatement("select b.id, c.type, b.dueDate, b.billAmount, b.paid, b.paymentDate from Bill b join Connection c where b.connectionType = c.id and c.userId =? and b.paid=false union select oe.id, oe.name, oe.paymentDate, oe.amount, oe.paid, oe.paymentDate from OtherExpenses oe where oe.userId =? and oe.paid=false");
		preparedStatement.setInt(1, userId);
		preparedStatement.setInt(2, userId);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		List<OtherExpenses> otherExpList = new ArrayList<OtherExpenses>();
		while (rs.next()) 
		{
			OtherExpenses otherExp = new OtherExpenses();
			otherExp.setId(rs.getInt(1));
			otherExp.setName(rs.getString(2));
			otherExp.setPaymentDate(rs.getDate(3));
			otherExp.setAmount(rs.getDouble(4));
			otherExp.setPaid(rs.getBoolean(5));
			otherExp.setPaymentDate(rs.getDate(6));
		    
		    otherExpList.add(otherExp);
		}
		return otherExpList;
	}
	
	public List<OtherExpenses> viewSummary(int userId) throws Exception
	{
		preparedStatement = getConnection().prepareStatement("select b.id, c.type, b.dueDate, b.billAmount, b.paid, b.paymentDate from Bill b join Connection c where b.connectionType = c.id and c.userId =? union select oe.id, oe.name, oe.paymentDate, oe.amount, oe.paid, oe.paymentDate from OtherExpenses oe where oe.userId =?");
		preparedStatement.setInt(1, userId);
		preparedStatement.setInt(2, userId);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		List<OtherExpenses> otherExpList = new ArrayList<OtherExpenses>();
		while (rs.next()) 
		{
			OtherExpenses otherExp = new OtherExpenses();
			otherExp.setId(rs.getInt(1));
			otherExp.setName(rs.getString(2));
			otherExp.setPaymentDate(rs.getDate(3));
			otherExp.setAmount(rs.getDouble(4));
			otherExp.setPaid(rs.getBoolean(5));
			otherExp.setPaymentDate(rs.getDate(6));
			
			if(null == otherExp.getPaymentDate())
			{
				otherExp.setPaymentDate(new Date());
			}
		    
		    otherExpList.add(otherExp);
		}
		return otherExpList;
	}
	
	
	public void updateBill(Bill bill) throws Exception
	{
		preparedStatement = getConnection().prepareStatement("update Bill set paid =?, paymentDate =? where id=?");
		preparedStatement.setBoolean(1, bill.getPaid());
		preparedStatement.setDate(2, new java.sql.Date(bill.getPaymentDate().getTime()));
		preparedStatement.setInt(3, bill.getId());
		preparedStatement.executeUpdate();	
	}
	
	public void updatePurchse(OtherExpenses oe) throws Exception
	{
		preparedStatement = getConnection().prepareStatement("update OtherExpenses set paid =?, paymentDate =? where id=?");
		preparedStatement.setBoolean(1, oe.getPaid());
		preparedStatement.setDate(2, new java.sql.Date(oe.getPaymentDate().getTime()));
		preparedStatement.setInt(3, oe.getId());
		preparedStatement.executeUpdate();	
	}
	
	public Integer addTransaction(BankTransaction bankTrans) throws Exception
	{
		Integer transactionId = null;
				
		preparedStatement = getConnection().prepareStatement("insert into BankTransaction (type, amount, transactionDate, bankId) values (?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, bankTrans.getType());
		preparedStatement.setString(2, bankTrans.getAmount());
		preparedStatement.setDate(3, new java.sql.Date(bankTrans.getTransactionDate().getTime()));
		preparedStatement.setInt(4, bankTrans.getBankId());
		transactionId = preparedStatement.executeUpdate();		
		
		ResultSet rs = preparedStatement.getGeneratedKeys();
		if (rs.next()) 
		{
			transactionId = rs.getInt(1);
		}
		
		return transactionId;
	}
	
}