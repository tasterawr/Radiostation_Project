package org.example.DAL.Models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Genre.class)
public abstract class Genre_ {

	public static volatile SingularAttribute<Genre, Long> genreCode;
	public static volatile SingularAttribute<Genre, String> genreName;
	public static volatile SingularAttribute<Genre, String> description;

	public static final String GENRE_CODE = "genreCode";
	public static final String GENRE_NAME = "genreName";
	public static final String DESCRIPTION = "description";

}

