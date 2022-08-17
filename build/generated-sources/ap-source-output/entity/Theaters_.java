package entity;

import entity.Movies;
import entity.ZipCodes;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-08-17T10:13:52")
@StaticMetamodel(Theaters.class)
public class Theaters_ { 

    public static volatile CollectionAttribute<Theaters, Movies> moviesCollection;
    public static volatile SingularAttribute<Theaters, ZipCodes> zipidFk;
    public static volatile SingularAttribute<Theaters, String> address;
    public static volatile SingularAttribute<Theaters, Long> idPk;
    public static volatile SingularAttribute<Theaters, String> name;

}