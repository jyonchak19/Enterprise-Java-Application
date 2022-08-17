package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "TICKET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ticket.findAll", query = "SELECT r FROM Ticket r"), 
    @NamedQuery(name = "Ticket.findByIdPk", query = "SELECT r FROM Ticket r WHERE r.idPk = :idPk"), 
    @NamedQuery(name = "Ticket.findByCreditcardnumber", query = "SELECT r FROM Ticket r WHERE r.creditcardnumber = :creditcardnumber"), 
    @NamedQuery(name = "Ticket.findByFirstname", query = "SELECT r FROM Ticket r WHERE r.firstname = :firstname"), 
    @NamedQuery(name = "Ticket.findByLastname", query = "SELECT r FROM Ticket r WHERE r.lastname = :lastname"), 
    @NamedQuery(name = "Ticket.findByMoviename", query = "SELECT r FROM Ticket r WHERE r.moviename = :moviename"), 
    @NamedQuery(name = "Ticket.findByTheatername", query = "SELECT r FROM Ticket r WHERE r.theatername = :theatername"), 
    @NamedQuery(name = "Ticket.findByTheateraddress", query = "SELECT r FROM Ticket r WHERE r.theateraddress = :theateraddress"), 
    @NamedQuery(name = "Ticket.findByTime", query = "SELECT r FROM Ticket r WHERE r.time = :time"), 
    @NamedQuery(name = "Ticket.findByZip", query = "SELECT r FROM Ticket r WHERE r.zip = :zip"), 
    @NamedQuery(name = "Ticket.findBySeatnum", query = "SELECT r FROM Ticket r WHERE r.seatnum = :seatnum")})
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPK")
    private Long idPk;
    @Size(max = 16)
    @Column(name = "CREDITCARDNUMBER")
    private String creditcardnumber;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @Size(max = 100)
    @Column(name = "MOVIENAME")
    private String moviename;
    @Size(max = 100)
    @Column(name = "THEATERNAME")
    private String theatername;
    @Size(max = 100)
    @Column(name = "THEATERADDRESS")
    private String theateraddress;
    @Size(max = 50)
    @Column(name = "TIME")
    private String time;
    @Size(max = 5)
    @Column(name = "ZIP")
    private String zip;
    @Size(max = 5)
    @Column(name = "SEATNUM")
    private String seatnum;

    public Ticket() {
    }

    public Ticket(Long idPk) {
        this.idPk = idPk;
    }

    public Long getIdPk() {
        return idPk;
    }

    public void setIdPk(Long idPk) {
        this.idPk = idPk;
    }

    public String getCreditcardnumber() {
        return creditcardnumber;
    }

    public void setCreditcardnumber(String creditcardnumber) {
        this.creditcardnumber = creditcardnumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getTheatername() {
        return theatername;
    }

    public void setTheatername(String theatername) {
        this.theatername = theatername;
    }

    public String getTheateraddress() {
        return theateraddress;
    }

    public void setTheateraddress(String theateraddress) {
        this.theateraddress = theateraddress;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getSeatnum() {
        return seatnum;
    }

    public void setSeatnum(String seatnum) {
        this.seatnum = seatnum;
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
        if (!(object instanceof Ticket)) {
            return false;
        }
        Ticket other = (Ticket) object;
        if ((this.idPk == null && other.idPk != null) || (this.idPk != null && !this.idPk.equals(other.idPk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Ticket[ idPk=" + idPk + " ]";
    }
    
}

