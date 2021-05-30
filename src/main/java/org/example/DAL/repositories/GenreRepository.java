package org.example.DAL.repositories;

import org.example.DAL.DAO.GenreDAO;
import org.example.DAL.Models.Genre;
import org.example.DAL.Models.Genre_;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GenreRepository implements GenreDAO {
    @Override
    public void add(Genre genre) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(genre);

        transaction.commit();
        session.close();
    }

    @Override
    public List<Genre> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Genre> query = criteriaBuilder.createQuery(Genre.class);
        Root<Genre> genreRoot = query.from(Genre.class);
        query.select(genreRoot);

        List<Genre> genres = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();
        return genres;
    }

    @Override
    public Genre getByGenreCode(Long genreCode) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Genre> query = criteriaBuilder.createQuery(Genre.class);
        Root<Genre> genreRoot = query.from(Genre.class);
        query.where(criteriaBuilder.equal(genreRoot.get(Genre_.genreCode), genreCode));
        query.select(genreRoot);

        Genre genre = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return genre;
    }

    @Override
    public void update(Genre genre) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(genre);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Genre genre) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(genre);

        transaction.commit();
        session.close();
    }
}
