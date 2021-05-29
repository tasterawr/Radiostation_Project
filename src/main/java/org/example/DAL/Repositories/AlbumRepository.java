package org.example.DAL.Repositories;

import org.example.DAL.DAO.AlbumDAO;
import org.example.DAL.Models.Album;
import org.example.DAL.Models.Album_;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AlbumRepository implements AlbumDAO {
    @Override
    public void add(Album album) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(album);

        transaction.commit();
        session.close();

    }

    @Override
    public List<Album> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Album> query = criteriaBuilder.createQuery(Album.class);
        Root<Album> albumRoot = query.from(Album.class);
        query.select(albumRoot);

        List<Album> albums = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();
        return albums;
    }

    @Override
    public Album getById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Album> query = criteriaBuilder.createQuery(Album.class);
        Root<Album> albumRoot = query.from(Album.class);
        query.where(criteriaBuilder.equal(albumRoot.get(Album_.id), id));
        query.select(albumRoot);

        Album album = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return album;
    }

    @Override
    public void update(Album album) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(album);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Album album) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(album);

        transaction.commit();
        session.close();
    }
}
