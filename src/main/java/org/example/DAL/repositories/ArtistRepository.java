package org.example.DAL.repositories;

import org.example.DAL.DAO.ArtistDAO;
import org.example.DAL.Models.Artist;
import org.example.DAL.Models.Artist_;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ArtistRepository implements ArtistDAO {
    @Override
    public void add(Artist artist) throws TransactionException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(artist);

        transaction.commit();
        session.close();
    }

    @Override
    public List<Artist> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Artist> query = criteriaBuilder.createQuery(Artist.class);
        Root<Artist> artistRoot = query.from(Artist.class);
        query.select(artistRoot);

        List<Artist> artists = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();
        return artists;
    }

    @Override
    public Artist getById(Long id) throws NoResultException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Artist> query = criteriaBuilder.createQuery(Artist.class);
        Root<Artist> artistRoot = query.from(Artist.class);
        query.where(criteriaBuilder.equal(artistRoot.get(Artist_.id), id));
        query.select(artistRoot);

        Artist artist = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return artist;
    }

    @Override
    public Artist getByName(String artistName) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Artist> query = criteriaBuilder.createQuery(Artist.class);
        Root<Artist> artistRoot = query.from(Artist.class);
        query.where(criteriaBuilder.equal(artistRoot.get(Artist_.artistName), artistName));
        query.select(artistRoot);

        Artist artist = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return artist;
    }

    @Override
    public List<Artist> getByHigherRating(Integer rating) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Artist> query = criteriaBuilder.createQuery(Artist.class);
        Root<Artist> artistRoot = query.from(Artist.class);
        query.where(criteriaBuilder.greaterThanOrEqualTo(artistRoot.get(Artist_.rating), rating));
        query.select(artistRoot);

        List<Artist> artists = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();
        return artists;
    }

    @Override
    public List<Artist> getByLowerRating(Integer rating) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Artist> query = criteriaBuilder.createQuery(Artist.class);
        Root<Artist> artistRoot = query.from(Artist.class);
        query.where(criteriaBuilder.lessThan(artistRoot.get(Artist_.rating), rating));
        query.select(artistRoot);

        List<Artist> artists = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();
        return artists;
    }

    @Override
    public void update(Artist artist) throws TransactionException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(artist);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Artist artist) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(artist);

        transaction.commit();
        session.close();
    }
}
