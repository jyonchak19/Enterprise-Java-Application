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
@Table(name = "MOVIEDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovieDetails.findAll", query = "SELECT n FROM MovieDetails n"), 
    @NamedQuery(name = "MovieDetails.findByIdPk", query = "SELECT n FROM MovieDetails n WHERE n.idPk = :idPk"), 
    @NamedQuery(name = "MovieDetails.findByMovietitle", query = "SELECT n FROM MovieDetails n WHERE n.movietitle = :movietitle"), 
    @NamedQuery(name = "MovieDetails.findByMoviedescription", query = "SELECT n FROM MovieDetails n WHERE n.moviedescription = :moviedescription")})
public class MovieDetails implements Serializable {

    @OneToMany(mappedBy = "moviedetailsFk")
    private Collection<Movies> moviesCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPK")
    private Long idPk;
    @Size(max = 100)
    @Column(name = "MOVIETITLE")
    private String movietitle;
    @Size(max = 10000)
    @Column(name = "MOVIEDESCRIPTION")
    private String moviedescription;

    public MovieDetails() {
    }

    public MovieDetails(Long idPk) {
        this.idPk = idPk;
    }

    public Long getIdPk() {
        return idPk;
    }

    public void setIdPk(Long idPk) {
        this.idPk = idPk;
    }

    public String getMovietitle() {
        return movietitle;
    }

    public void setMovietitle(String movietitle) {
        this.movietitle = movietitle;
    }

    public String getMoviedescription() {
        return moviedescription;
    }

    public void setMoviedescription(String moviedescription) {
        this.moviedescription = moviedescription;
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
        if (!(object instanceof MovieDetails)) {
            return false;
        }
        MovieDetails other = (MovieDetails) object;
        if ((this.idPk == null && other.idPk != null) || (this.idPk != null && !this.idPk.equals(other.idPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MovieDetails[ idPk=" + idPk + " ]";
    }
}
