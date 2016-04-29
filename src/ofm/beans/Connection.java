package ofm.beans;


import java.io.Serializable;
import java.util.Date;

public class Connection implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    private String type;
    private String supplierName;
    private Date startDate;
    private String registrationNo;
    private Integer userId;

    public Connection() {
    }

    public Connection(Integer id) {
        this.id = id;
    }

    public Connection(Integer id, String supplierName, Date startDate, String registrationNo) {
        this.id = id;
        this.supplierName = supplierName;
        this.startDate = startDate;
        this.registrationNo = registrationNo;
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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
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
        if (!(object instanceof Connection)) {
            return false;
        }
        Connection other = (Connection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ofmproject.Connection[ id=" + id + " ]";
    }
    
}
