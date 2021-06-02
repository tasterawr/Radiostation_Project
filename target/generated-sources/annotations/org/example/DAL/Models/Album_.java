package org.example.DAL.Models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Album.class)
public abstract class Album_ {

	public static volatile SingularAttribute<Album, String> albumName;
	public static volatile SingularAttribute<Album, Artist> artist;
	public static volatile SingularAttribute<Album, Genre> genre;
	public static volatile SingularAttribute<Album, Long> id;
	public static volatile SingularAttribute<Album, Label> label;
	public static volatile SingularAttribute<Album, Integer> numberOfTracks;

	public static final String ALBUM_NAME = "albumName";
	public static final String ARTIST = "artist";
	public static final String GENRE = "genre";
	public static final String ID = "id";
	public static final String LABEL = "label";
	public static final String NUMBER_OF_TRACKS = "numberOfTracks";

}

