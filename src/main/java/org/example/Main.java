package org.example;

import org.example.DAL.Models.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        loadData(sessionFactory.openSession());
        HibernateUtil.shutdown();
    }

    private static void loadData(Session session){

        final Transaction transaction = session.beginTransaction();

        Artist artist1 = new Artist();
        artist1.setArtistName("Metallica");
        artist1.setCareerBeginDate(Date.valueOf("1981-1-1"));
        artist1.setRating(12);

        Artist artist2 = new Artist();
        artist2.setArtistName("Tame Impala");
        artist2.setCareerBeginDate(Date.valueOf("2007-3-12"));
        artist2.setRating(9);

        Artist artist3 = new Artist();
        artist3.setArtistName("Depeche Mode");
        artist3.setCareerBeginDate(Date.valueOf("1980-5-23"));
        artist3.setRating(14);

        Genre genre1 = new Genre();
        genre1.setGenreName("Рок");
        genre1.setDescription("Описание жанра рок");

        Genre genre2 = new Genre();
        genre2.setGenreName("Инди");
        genre2.setDescription("Описание жанра инди");

        Genre genre3 = new Genre();
        genre3.setGenreName("Нью вейв");
        genre3.setDescription("Описание жанра нью вейв");

        Label label1 = new Label();
        label1.setLabelName("Warner Records Inc.");
        label1.setLabelCreationDate(Date.valueOf("1958-1-1"));

        Label label2 = new Label();
        label2.setLabelName("Interscope Records");
        label2.setLabelCreationDate(Date.valueOf("1990-1-1"));

        Label label3 = new Label();
        label3.setLabelName("Mute");
        label3.setLabelCreationDate(Date.valueOf("1978-1-1"));

        Album album1 = new Album();
        album1.setAlbumName("Death Magnetic");
        album1.setArtist(artist1);
        album1.setGenre(genre1);
        album1.setLabel(label1);
        album1.setNumberOfTracks(8);

        Album album2 = new Album();
        album2.setAlbumName("Currents");
        album2.setArtist(artist2);
        album2.setGenre(genre2);
        album2.setLabel(label2);
        album2.setNumberOfTracks(13);

        Album album3 = new Album();
        album3.setAlbumName("Some Great Reward");
        album3.setArtist(artist3);
        album3.setGenre(genre3);
        album3.setLabel(label3);
        album3.setNumberOfTracks(14);

        session.save(artist1);
        session.save(artist2);
        session.save(artist3);
        session.save(genre1);
        session.save(genre2);
        session.save(genre3);
        session.save(label1);
        session.save(label2);
        session.save(label3);
        session.save(album1);
        session.save(album2);
        session.save(album3);

        transaction.commit();
        session.close();
    }
}
