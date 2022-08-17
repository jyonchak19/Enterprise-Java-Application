package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "ZIPCODES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZipCodes.findAll", query = "SELECT z FROM ZipCodes z"), 
    @NamedQuery(name = "ZipCodes.findByIdPk", query = "SELECT z FROM ZipCodes z WHERE z.idPk = :idPk"), 
    @NamedQuery(name = "ZipCodes.findByZipcode", query = "SELECT z FROM ZipCodes z WHERE z.zipcode = :zipcode")})
public class ZipCodes implements Serializable {

    @OneToMany(mappedBy = "zipidFk")
    private Collection<Theaters> theatersCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPK")
    private Long idPk;
    @Size(max = 5)
    @Column(name = "ZIPCODE")
    private String zipcode;

    public ZipCodes() {
    }

    public ZipCodes(Long idPk) {
        this.idPk = idPk;
    }

    public Long getIdPk() {
        return idPk;
    }

    public void setIdPk(Long idPk) {
        this.idPk = idPk;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPk != null ? idPk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZipCodes)) {
            return false;
        }
        ZipCodes other = (ZipCodes) object;
        if ((this.idPk == null && other.idPk != null) || (this.idPk != null && !this.idPk.equals(other.idPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ZipCodes[ idPk=" + idPk + " ]";
    } 
}
