package entity;

import entity.Movies;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-08-17T10:13:52")
@StaticMetamodel(MovieDetails.class)
public class MovieDetails_ { 

    public static volatile CollectionAttribute<MovieDetails, Movies> moviesCollection;
    public static volatile SingularAttribute<MovieDetails, Long> idPk;
    public static volatile SingularAttribute<MovieDetails, String> moviedescription;
    public static volatile SingularAttribute<MovieDetails, String> movietitle;

}