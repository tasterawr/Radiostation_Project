package org.example.DAL.repositories;

import org.example.DAL.DAO.DBUserDAO;
import org.example.DAL.Models.Album;
import org.example.DAL.Models.Album_;
import org.example.DAL.Models.DBUser;
import org.example.DAL.Models.DBUser_;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class DBUserRepository implements DBUserDAO {
    @Override
    public void add(DBUser user) throws NoResultException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(user);

        transaction.commit();
        session.close();
    }

    @Override
    public DBUser getById(Long id) throws NoResultException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<DBUser> query = criteriaBuilder.createQuery(DBUser.class);
        Root<DBUser> userRoot = query.from(DBUser.class);
        query.where(criteriaBuilder.equal(userRoot.get(DBUser_.id), id));
        query.select(userRoot);

        DBUser user = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return user;
    }

    @Override
    public void checkLogin(String email, String pass) throws NoResultException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<DBUser> query = criteriaBuilder.createQuery(DBUser.class);
        Root<DBUser> userRoot = query.from(DBUser.class);
        Predicate emailPredicate = criteriaBuilder.equal(userRoot.get(DBUser_.email), email);
        Predicate passPredicate = criteriaBuilder.equal(userRoot.get(DBUser_.password), pass);
        Predicate finalPredicate = criteriaBuilder.and(emailPredicate, passPredicate);
        query.where(finalPredicate);
        query.select(userRoot);

        DBUser user = session.createQuery(query).getSingleResult();
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(DBUser user) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(user);

        transaction.commit();
        session.close();
    }
}
