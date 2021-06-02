package org.example.DAL.Models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RadioProgram.class)
public abstract class RadioProgram_ {

	public static volatile SingularAttribute<RadioProgram, String> radioProgramName;
	public static volatile SingularAttribute<RadioProgram, Integer> monthlyListeners;
	public static volatile ListAttribute<RadioProgram, Playlist> playlists;
	public static volatile SingularAttribute<RadioProgram, Long> id;
	public static volatile SingularAttribute<RadioProgram, Integer> songOrderPrice;

	public static final String RADIO_PROGRAM_NAME = "radioProgramName";
	public static final String MONTHLY_LISTENERS = "monthlyListeners";
	public static final String PLAYLISTS = "playlists";
	public static final String ID = "id";
	public static final String SONG_ORDER_PRICE = "songOrderPrice";

}

