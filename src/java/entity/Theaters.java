package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "THEATERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Theaters.findAll", query = "SELECT t FROM Theaters t"), 
    @NamedQuery(name = "Theaters.findByIdPk", query = "SELECT t FROM Theaters t WHERE t.idPk = :idPk"), 
    @NamedQuery(name = "Theaters.findByName", query = "SELECT t FROM Theaters t WHERE t.name = :name"), 
    @NamedQuery(name = "Theaters.findByAddress", query = "SELECT t FROM Theaters t WHERE t.address = :address"), 
    @NamedQuery(name = "Theaters.findByZipIdFk", query = "SELECT t FROM Theaters t WHERE t.zipidFk = :zipidFk")})
public class Theaters implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPK")
    private Long idPk;
    @Size(max = 100)
    @Column(name = "NAME")
    private String name;
    @Size(max = 100)
    @Column(name = "ADDRESS")
    private String address;
    @OneToMany(mappedBy = "theateridFk")
    private Collection<Movies> moviesCollection;
    @JoinColumn(name = "ZIPIDFK", referencedColumnName = "IDPK")
    @ManyToOne
    private ZipCodes zipidFk;

    public Theaters() {
    }

    public Theaters(Long idPk) {
        this.idPk = idPk;
    }

    public Long getIdPk() {
        return idPk;
    }

    public void setIdPk(Long idPk) {
        this.idPk = idPk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<Movies> getMoviesCollection() {
        return moviesCollection;
    }

    public void setMoviesCollection(Collection<Movies> moviesCollection) {
        this.moviesCollection = moviesCollection;
    }

    public ZipCodes getZipidFk() {
        return zipidFk;
    }

    public void setZipidFk(ZipCodes zipidFk) {
        this.zipidFk = zipidFk;
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
        if (!(object instanceof Theaters)) {
            return false;
        }
        Theaters other = (Theaters) object;
        if ((this.idPk == null && other.idPk != null) || (this.idPk != null && !this.idPk.equals(other.idPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Theaters[ idPk=" + idPk + " ]";
    }
    
}

