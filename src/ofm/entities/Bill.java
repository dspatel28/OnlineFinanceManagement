package ofm.entities;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b"),
    @NamedQuery(name = "Bill.findById", query = "SELECT b FROM Bill b WHERE b.id = :id"),
    @NamedQuery(name = "Bill.findByDueDate", query = "SELECT b FROM Bill b WHERE b.dueDate = :dueDate"),
    @NamedQuery(name = "Bill.findByBillAmount", query = "SELECT b FROM Bill b WHERE b.billAmount = :billAmount"),
    @NamedQuery(name = "Bill.findByReminderDate", query = "SELECT b FROM Bill b WHERE b.reminderDate = :reminderDate"),
    @NamedQuery(name = "Bill.findByPaid", query = "SELECT b FROM Bill b WHERE b.paid = :paid"),
    @NamedQuery(name = "Bill.findByPaymentDate", query = "SELECT b FROM Bill b WHERE b.paymentDate = :paymentDate")})
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "dueDate")
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    @Basic(optional = false)
    @Column(name = "billAmount")
    private String billAmount;
    @Basic(optional = false)
    @Column(name = "reminderDate")
    @Temporal(TemporalType.DATE)
    private Date reminderDate;
    @Basic(optional = false)
    @Column(name = "paid")
    private boolean paid;
    @Column(name = "paymentDate")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @JoinColumn(name = "connectionType", referencedColumnName = "id")
    @ManyToOne
    private Connection connectionType;
    @JoinColumn(name = "transactionId", referencedColumnName = "id")
    @ManyToOne
    private BankTransaction transactionId;

    public Bill() {
    }

    public Bill(Integer id) {
        this.id = id;
    }

    public Bill(Integer id, Date dueDate, String billAmount, Date reminderDate, boolean paid) {
        this.id = id;
        this.dueDate = dueDate;
        this.billAmount = billAmount;
        this.reminderDate = reminderDate;
        this.paid = paid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Date reminderDate) {
        this.reminderDate = reminderDate;
    }

    public boolean getPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Connection getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(Connection connectionType) {
        this.connectionType = connectionType;
    }

    public BankTransaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(BankTransaction transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ofmproject.Bill[ id=" + id + " ]";
    }
    
}
