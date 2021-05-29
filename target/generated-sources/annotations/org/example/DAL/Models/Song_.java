package org.example.DAL.Models;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Song.class)
public abstract class Song_ {

	public static volatile SingularAttribute<Song, String> songName;
	public static volatile SingularAttribute<Song, Integer> duration;
	public static volatile SingularAttribute<Song, Album> album;
	public static volatile SetAttribute<Song, Playlist> playlists;
	public static volatile SingularAttribute<Song, Integer> rating;
	public static volatile SingularAttribute<Song, Long> id;
	public static volatile SingularAttribute<Song, Integer> monthlyOrders;

	public static final String SONG_NAME = "songName";
	public static final String DURATION = "duration";
	public static final String ALBUM = "album";
	public static final String PLAYLISTS = "playlists";
	public static final String RATING = "rating";
	public static final String ID = "id";
	public static final String MONTHLY_ORDERS = "monthlyOrders";

}

