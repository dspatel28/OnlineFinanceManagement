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
@Table(name = "bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
    @NamedQuery(name = "Bank.findById", query = "SELECT b FROM Bank b WHERE b.id = :id"),
    @NamedQuery(name = "Bank.findByName", query = "SELECT b FROM Bank b WHERE b.name = :name"),
    @NamedQuery(name = "Bank.findByBranch", query = "SELECT b FROM Bank b WHERE b.branch = :branch"),
    @NamedQuery(name = "Bank.findByAccountNumber", query = "SELECT b FROM Bank b WHERE b.accountNumber = :accountNumber"),
    @NamedQuery(name = "Bank.findByAccountOpenDate", query = "SELECT b FROM Bank b WHERE b.accountOpenDate = :accountOpenDate")})
public class Bank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "branch")
    private String branch;
    @Basic(optional = false)
    @Column(name = "accountNumber")
    private String accountNumber;
    @Basic(optional = false)
    @Column(name = "accountOpenDate")
    @Temporal(TemporalType.DATE)
    private Date accountOpenDate;
    @JoinColumn(name = "addressId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Address addressId;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(mappedBy = "bankId")
    private Collection<BankTransaction> banktransactionCollection;

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

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<BankTransaction> getBanktransactionCollection() {
        return banktransactionCollection;
    }

    public void setBanktransactionCollection(Collection<BankTransaction> banktransactionCollection) {
        this.banktransactionCollection = banktransactionCollection;
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
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ofmproject.Bank[ id=" + id + " ]";
    }
    
}
