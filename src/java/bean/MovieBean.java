package bean;

import ejb.MovieEJB;
import entity.MovieDetails;
import entity.Movies;
import entity.Ticket;
import entity.Theaters;
import entity.ZipCodes;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

@Named(value = "movieBean")
@SessionScoped
public class MovieBean implements Serializable {

    private Movies movie = new Movies();
    private MovieDetails movieDetails = new MovieDetails();
    private Theaters theater = new Theaters();
    private ZipCodes zip = new ZipCodes();
    private Ticket ticket = new Ticket();

    private String zipcode = "";
    private String zipcodeString = "";
    private String seatNum = "";
    private String seatNumString = "";
    private String creditCardNumber = "";
    private String creditCardString = "";

    public String getSeatNumString() {
        return seatNumString;
    }

    public void setSeatNumString(String seatNumString) {
        this.seatNumString = seatNumString;
    }
    

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getCreditCardString() {
        return creditCardString;
    }

    public String getZipcodeString() {
        return zipcodeString;
    }

    public void setZipcodeString(String zipcodeString) {
        this.zipcodeString = zipcodeString;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Theaters getTheater() {
        return theater;
    }

    public void setTheater(Theaters theater) {
        this.theater = theater;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @EJB
    private MovieEJB movieEJB;

    public MovieBean() {
    }
    
    public String goToMovies() {
        return "Movies.xhtml";
    }

    public String goToTheaters() {
        return "Theaters.xhtml";
    }
    
    public String goToMainPage() {
        return "MainPage.xhtml";
    }
    
    public String goToSearch() {
        return "Search.xhtml";
    }

    public String goToSearchResults() {
        
        return "SearchResults.xhtml";
    }

    public String goToShowingsInTheater(Theaters theater) {
        this.theater = theater;
        return "ShowingsInTheater.xhtml";
    }

    public String goToChooseSeats() {
        return "ChooseSeats.xhtml";
    }

    public String goToChooseSeats(Movies movie) {
        this.movie = movie;
        return "ChooseSeats.xhtml";
    }

    public String goToTicket() {
        return "Ticket.xhtml";
    }

    public String goToTicketConfirmation() {
        return "TicketConfirmation.xhtml";
    }

    public String validateZip() {
        if (zipcode.length() != 5) {
            zipcodeString = "Zipcode must be a 5 digit number";
            return goToSearch();
        }
        for (int i = 0; i < zipcode.length(); i++) {
            if (!Character.isDigit(zipcode.charAt(i))) {
                zipcodeString = "Zipcode must be a 5 digit number";
                return goToSearch();
            }
        }

        return goToSearchResults();
    }

    public boolean validateCreditCard() {
        String num = ticket.getCreditcardnumber();
        if (num.length() != 16) {
            creditCardString = "Invalid Credit Card number";
            return false;
        }
        for (int i = 0; i < num.length(); i++) {
            if (!Character.isDigit(num.charAt(i))) {
                creditCardString = "Invalid Credit Card number";
                return false;
            }
        }
        return true;
    }
    
    public String validateSeatNum() {
        if(seatNum.equals("")) {
            seatNumString = "Please enter a number";
            return MovieBean.this.goToChooseSeats();
        }
        for (int i = 0; i < seatNum.length(); i++) {
            if (!Character.isDigit(seatNum.charAt(i))) {
                seatNumString = "Please enter a number";
                return MovieBean.this.goToChooseSeats();
            }
        }
        return goToTicket();
    }

    public List<MovieDetails> getAllMovies() {

        List<MovieDetails> list = movieEJB.getAllMovies();

        return list;
    }

    public List<Theaters> getAllTheaters() {

        List<Theaters> list = movieEJB.getAllTheaters();

        return list;
    }

    public List<Theaters> getTheatersByZip() {

        ZipCodes zippy = getZipByZipCode();

        List<Theaters> listy = movieEJB.getTheatersByZip(zippy);

        return listy;
    }

    public ZipCodes getZipByZipCode() {
        zip = movieEJB.getZipByZipCode(zipcode);
        return zip;
    }

    public List<Movies> getMoviesByTheater() {
        return movieEJB.getMoviesByTheater(theater);
    }

    public void setTicketDetails() {
        ticket.setTheatername(theater.getName());
        ticket.setZip(zipcode);
        ticket.setTheateraddress(theater.getAddress());
        ticket.setMoviename(movie.getMovieDetailsFk().getMovietitle());
        ticket.setTime(movie.getShowTime());
        ticket.setSeatnum(seatNum);
    }
    
    public String submitTicket() {
        if (!validateCreditCard()) {
            return goToTicket();
        }
        movieEJB.persist(ticket);
        return goToTicketConfirmation();
    }
    
    public String getPrice(){
        Integer numSeats = Integer.parseInt(seatNum);
        Integer price = numSeats * 10;
        return price.toString();
    }

}