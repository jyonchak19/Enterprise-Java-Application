package entity;

import entity.Theaters;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-08-17T15:43:39")
@StaticMetamodel(ZipCodes.class)
public class ZipCodes_ { 

    public static volatile SingularAttribute<ZipCodes, String> zipcode;
    public static volatile SingularAttribute<ZipCodes, Long> idPk;
    public static volatile CollectionAttribute<ZipCodes, Theaters> theatersCollection;

}