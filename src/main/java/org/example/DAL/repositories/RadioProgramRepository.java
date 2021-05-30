package org.example.DAL.repositories;

import org.example.DAL.DAO.RadioProgramDAO;
import org.example.DAL.Models.RadioProgram;
import org.example.DAL.Models.RadioProgram_;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RadioProgramRepository implements RadioProgramDAO {
    @Override
    public void add(RadioProgram radioProgram) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(radioProgram);

        transaction.commit();
        session.close();
    }

    @Override
    public List<RadioProgram> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<RadioProgram> query = criteriaBuilder.createQuery(RadioProgram.class);
        Root<RadioProgram> radioProgramRoot = query.from(RadioProgram.class);
        query.select(radioProgramRoot);

        List<RadioProgram> radioPrograms = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();
        return radioPrograms;
    }

    @Override
    public RadioProgram getById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<RadioProgram> query = criteriaBuilder.createQuery(RadioProgram.class);
        Root<RadioProgram> radioProgramRoot = query.from(RadioProgram.class);
        query.where(criteriaBuilder.equal(radioProgramRoot.get(RadioProgram_.id), id));
        query.select(radioProgramRoot);

        RadioProgram radioProgram = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return radioProgram;
    }

    @Override
    public RadioProgram getByName(String radioProgramName) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<RadioProgram> query = criteriaBuilder.createQuery(RadioProgram.class);
        Root<RadioProgram> radioProgramRoot = query.from(RadioProgram.class);
        query.where(criteriaBuilder.equal(radioProgramRoot.get(RadioProgram_.radioProgramName), radioProgramName));
        query.select(radioProgramRoot);

        RadioProgram radioProgram = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return radioProgram;
    }

    @Override
    public void update(RadioProgram radioProgram) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(radioProgram);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(RadioProgram radioProgram) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(radioProgram);

        transaction.commit();
        session.close();
    }
}
