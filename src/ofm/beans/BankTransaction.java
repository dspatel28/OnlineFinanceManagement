package ofm.beans;

import java.io.Serializable;
import java.util.Date;

public class BankTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
	    
    private Integer id;
    private String type;
    private String amount;
    private Date transactionDate;
    private Integer bankId;

    public BankTransaction() {
    }

    public BankTransaction(Integer id) {
        this.id = id;
    }

    public BankTransaction(Integer id, String amount, Date transactionDate) {
        this.id = id;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

   
}
