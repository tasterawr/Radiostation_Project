package org.example.DAL.Repositories;

import org.example.DAL.DAO.ArtistDAO;
import org.example.DAL.Models.Artist;
import org.example.DAL.Models.Artist_;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ArtistRepository implements ArtistDAO {
    @Override
    public void add(Artist artist) {
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
    public Artist getById(Long id) {
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
    public void update(Artist artist) {
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
