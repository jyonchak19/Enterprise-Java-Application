package entity;

import entity.MovieDetails;
import entity.Theaters;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-08-17T10:13:52")
@StaticMetamodel(Movies.class)
public class Movies_ { 

    public static volatile SingularAttribute<Movies, Long> idPk;
    public static volatile SingularAttribute<Movies, String> showTime;
    public static volatile SingularAttribute<Movies, MovieDetails> moviedetailsFk;
    public static volatile SingularAttribute<Movies, Theaters> theateridFk;

}