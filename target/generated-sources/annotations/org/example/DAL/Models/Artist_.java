package org.example.DAL.Models;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Artist.class)
public abstract class Artist_ {

	public static volatile SingularAttribute<Artist, Date> careerBeginDate;
	public static volatile SingularAttribute<Artist, Integer> rating;
	public static volatile SingularAttribute<Artist, String> artistName;
	public static volatile SingularAttribute<Artist, Long> id;

	public static final String CAREER_BEGIN_DATE = "careerBeginDate";
	public static final String RATING = "rating";
	public static final String ARTIST_NAME = "artistName";
	public static final String ID = "id";

}

