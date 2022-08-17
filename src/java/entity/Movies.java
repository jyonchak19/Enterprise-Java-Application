package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "MOVIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movies.findAll", query = "SELECT m FROM Movies m"), 
    @NamedQuery(name = "Movies.findByIdPk", query = "SELECT m FROM Movies m WHERE m.idPk = :idPk"), 
    @NamedQuery(name = "Movies.findByTime", query = "SELECT m FROM Movies m WHERE m.showTime = :showTime"), 
    @NamedQuery(name = "Movies.findByTheaterIdFk", query = "SELECT m FROM Movies m WHERE m.theateridFk = :theateridFk")})
public class Movies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPK")
    private Long idPk;
    @Size(max = 50)
    @Column(name = "SHOWTIME")
    private String showTime;
    @JoinColumn(name = "MOVIEDETAILSFK", referencedColumnName = "IDPK")
    @ManyToOne
    private MovieDetails moviedetailsFk;
    @JoinColumn(name = "THEATERIDFK", referencedColumnName = "IDPK")
    @ManyToOne
    private Theaters theateridFk;

    public Movies() {
    }

    public Movies(Long idPk) {
        this.idPk = idPk;
    }

    public Long getIdPk() {
        return idPk;
    }

    public void setIdPk(Long idPk) {
        this.idPk = idPk;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public MovieDetails getMovieDetailsFk() {
        return moviedetailsFk;
    }

    public void setMovieDetailsFk(MovieDetails moviedetailsFk) {
        this.moviedetailsFk = moviedetailsFk;
    }

    public Theaters getTheateridFk() {
        return theateridFk;
    }

    public void setTheateridFk(Theaters theateridFk) {
        this.theateridFk = theateridFk;
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
        if (!(object instanceof Movies)) {
            return false;
        }
        Movies other = (Movies) object;
        if ((this.idPk == null && other.idPk != null) || (this.idPk != null && !this.idPk.equals(other.idPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Movies[ idPk=" + idPk + " ]";
    }
    
}