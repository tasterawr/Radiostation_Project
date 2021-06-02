package org.example.DAL.repositories;

import org.example.DAL.DAO.RadioDjDAO;
import org.example.DAL.Models.RadioDj;
import org.example.DAL.Models.RadioDj_;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RadioDjRepository implements RadioDjDAO {
    @Override
    public void add(RadioDj radioDj) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(radioDj);

        transaction.commit();
        session.close();
    }

    @Override
    public List<RadioDj> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<RadioDj> query = criteriaBuilder.createQuery(RadioDj.class);
        Root<RadioDj> radioDjRoot = query.from(RadioDj.class);
        query.select(radioDjRoot);

        List<RadioDj> radioDjs = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();
        return radioDjs;
    }

    @Override
    public RadioDj getById(Long id) throws NoResultException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<RadioDj> query = criteriaBuilder.createQuery(RadioDj.class);
        Root<RadioDj> radioDjRoot = query.from(RadioDj.class);
        query.where(criteriaBuilder.equal(radioDjRoot.get(RadioDj_.id), id));
        query.select(radioDjRoot);

        RadioDj radioDj = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return radioDj;
    }

    @Override
    public RadioDj getByNickname(String djNickname) throws NoResultException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<RadioDj> query = criteriaBuilder.createQuery(RadioDj.class);
        Root<RadioDj> radioDjRoot = query.from(RadioDj.class);
        query.where(criteriaBuilder.equal(radioDjRoot.get(RadioDj_.djNickname), djNickname));
        query.select(radioDjRoot);

        RadioDj radioDj = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return radioDj;
    }

    @Override
    public void update(RadioDj radioDj) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(radioDj);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(RadioDj radioDj) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(radioDj);

        transaction.commit();
        session.close();
    }
}
