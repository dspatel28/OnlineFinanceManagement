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
@Table(name = "otherexpenses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Otherexpenses.findAll", query = "SELECT o FROM Otherexpenses o"),
    @NamedQuery(name = "Otherexpenses.findById", query = "SELECT o FROM Otherexpenses o WHERE o.id = :id"),
    @NamedQuery(name = "Otherexpenses.findByName", query = "SELECT o FROM Otherexpenses o WHERE o.name = :name"),
    @NamedQuery(name = "Otherexpenses.findByDescription", query = "SELECT o FROM Otherexpenses o WHERE o.description = :description"),
    @NamedQuery(name = "Otherexpenses.findByAmount", query = "SELECT o FROM Otherexpenses o WHERE o.amount = :amount"),
    @NamedQuery(name = "Otherexpenses.findByPaid", query = "SELECT o FROM Otherexpenses o WHERE o.paid = :paid"),
    @NamedQuery(name = "Otherexpenses.findByPaymentDate", query = "SELECT o FROM Otherexpenses o WHERE o.paymentDate = :paymentDate")})
public class OtherExpenses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "amount")
    private double amount;
    @Basic(optional = false)
    @Column(name = "paid")
    private boolean paid;
    @Column(name = "paymentDate")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;
    @JoinColumn(name = "transactionId", referencedColumnName = "id")
    @ManyToOne
    private BankTransaction transactionId;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public OtherExpenses() {
    }

    public OtherExpenses(Integer id) {
        this.id = id;
    }

    public OtherExpenses(Integer id, String name, double amount, boolean paid) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.paid = paid;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public BankTransaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(BankTransaction transactionId) {
        this.transactionId = transactionId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof OtherExpenses)) {
            return false;
        }
        OtherExpenses other = (OtherExpenses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ofmproject.Otherexpenses[ id=" + id + " ]";
    }
    
}
