/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.MovieDetails;
import entity.Movies;
import entity.Theaters;
import entity.ZipCodes;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;

@Stateless
public class MovieEJB {
@PersistenceContext(unitName = "MovieProjectPU")
    private EntityManager em;
    
    
 public List<MovieDetails> getAllMovies()
    {
        List<MovieDetails> list = em.createNamedQuery("MovieDetails.findAll", MovieDetails.class).getResultList();   
        return list;
    }
 
    public ZipCodes getZipByZipCode(String zipcode){
        try{
            ZipCodes zip = em.createNamedQuery("ZipCodes.findByZipcode", ZipCodes.class).setParameter("zipcode", zipcode).getSingleResult();
            return zip;
        }
        catch(NoResultException e){
            return new ZipCodes();
        }
    }
    
    public List<Theaters> getTheatersByZip(ZipCodes zip){    
        try{
            List<Theaters> list = em.createNamedQuery("Theaters.findByZipIdFk", Theaters.class).setParameter("zipidFk", zip).getResultList();
            return list;
        }
        catch(NoResultException e){
            List<Theaters> list = new ArrayList();
            return list;
        }
    }

    public List<Movies> getMoviesByTheater(Theaters theater) {
       try{
            List<Movies> list = em.createNamedQuery("Movies.findByTheaterIdFk", Movies.class).setParameter("theateridFk", theater).getResultList();
            return list;
        }
        catch(NoResultException e){
            List<Movies> list = new ArrayList();
            return list;       
        }
    }

    public void persist(Object object) {
        try{
            em.persist(object);
        }
        catch (ConstraintViolationException e) {
            System.out.println(e.getConstraintViolations().toString());
        }
    }

    public List<Theaters> getAllTheaters() {
          List<Theaters> list = em.createNamedQuery("Theaters.findAll", Theaters.class).getResultList();
        return list;
    }
    
}
