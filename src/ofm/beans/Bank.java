package ofm.beans;

import java.io.Serializable;
import java.util.Date;

public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String branch;
    private String accountNumber;
    private Date accountOpenDate;
    private Integer addressId;
    private Integer userId;

    public Bank() {
    }

    public Bank(Integer id) {
        this.id = id;
    }

    public Bank(Integer id, String name, String branch, String accountNumber, Date accountOpenDate) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.accountNumber = accountNumber;
        this.accountOpenDate = accountOpenDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getAccountOpenDate() {
        return accountOpenDate;
    }

    public void setAccountOpenDate(Date accountOpenDate) {
        this.accountOpenDate = accountOpenDate;
    }

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

   
}
