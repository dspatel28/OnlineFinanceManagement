package ofm.entities;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "banktransaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Banktransaction.findAll", query = "SELECT b FROM Banktransaction b"),
    @NamedQuery(name = "Banktransaction.findById", query = "SELECT b FROM Banktransaction b WHERE b.id = :id"),
    @NamedQuery(name = "Banktransaction.findByType", query = "SELECT b FROM Banktransaction b WHERE b.type = :type"),
    @NamedQuery(name = "Banktransaction.findByAmount", query = "SELECT b FROM Banktransaction b WHERE b.amount = :amount"),
    @NamedQuery(name = "Banktransaction.findByTransactionDate", query = "SELECT b FROM Banktransaction b WHERE b.transactionDate = :transactionDate")})
public class BankTransaction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "amount")
    private String amount;
    @Basic(optional = false)
    @Column(name = "transactionDate")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;
    @OneToMany(mappedBy = "transactionId")
    private Collection<OtherExpenses> otherexpensesCollection;
    @JoinColumn(name = "bankId", referencedColumnName = "id")
    @ManyToOne
    private Bank bankId;
    @OneToMany(mappedBy = "transactionId")
    private Collection<Bill> billCollection;

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

    @XmlTransient
    public Collection<OtherExpenses> getOtherexpensesCollection() {
        return otherexpensesCollection;
    }

    public void setOtherexpensesCollection(Collection<OtherExpenses> otherexpensesCollection) {
        this.otherexpensesCollection = otherexpensesCollection;
    }

    public Bank getBankId() {
        return bankId;
    }

    public void setBankId(Bank bankId) {
        this.bankId = bankId;
    }

    @XmlTransient
    public Collection<Bill> getBillCollection() {
        return billCollection;
    }

    public void setBillCollection(Collection<Bill> billCollection) {
        this.billCollection = billCollection;
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
        if (!(object instanceof BankTransaction)) {
            return false;
        }
        BankTransaction other = (BankTransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ofmproject.Banktransaction[ id=" + id + " ]";
    }
    
}
