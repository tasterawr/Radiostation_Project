package org.example.DAL.repositories;

import org.example.DAL.DAO.SongDAO;
import org.example.DAL.Models.Song;
import org.example.DAL.Models.Song_;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class SongRepository implements SongDAO {
    @Override
    public void add(Song song) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(song);

        transaction.commit();
        session.close();
    }

    @Override
    public List<Song> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Song> query = criteriaBuilder.createQuery(Song.class);
        Root<Song> songRoot = query.from(Song.class);
        query.select(songRoot);

        List<Song> songs = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();
        return songs;
    }

    @Override
    public Song getById(Long id) throws NoResultException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Song> query = criteriaBuilder.createQuery(Song.class);
        Root<Song> songRoot = query.from(Song.class);
        query.where(criteriaBuilder.equal(songRoot.get(Song_.id), id));
        query.select(songRoot);

        Song song = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return song;
    }

    @Override
    public void update(Song song) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(song);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Song song) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(song);

        transaction.commit();
        session.close();
    }
}
