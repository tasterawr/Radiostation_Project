package org.example.DAL.Models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Playlist.class)
public abstract class Playlist_ {

	public static volatile ListAttribute<Playlist, Song> songs;
	public static volatile SingularAttribute<Playlist, Long> id;
	public static volatile SetAttribute<Playlist, RadioProgram> programs;
	public static volatile SingularAttribute<Playlist, String> playlistName;

	public static final String SONGS = "songs";
	public static final String ID = "id";
	public static final String PROGRAMS = "programs";
	public static final String PLAYLIST_NAME = "playlistName";

}

