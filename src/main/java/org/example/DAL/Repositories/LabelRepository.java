package org.example.DAL.Repositories;

import org.example.DAL.DAO.LabelDAO;
import org.example.DAL.Models.Label;
import org.example.DAL.Models.Label_;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class LabelRepository implements LabelDAO {
    @Override
    public void add(Label label) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(label);

        transaction.commit();
        session.close();
    }

    @Override
    public List<Label> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Label> query = criteriaBuilder.createQuery(Label.class);
        Root<Label> labelRoot = query.from(Label.class);
        query.select(labelRoot);

        List<Label> labels = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();
        return labels;
    }

    @Override
    public Label getById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Label> query = criteriaBuilder.createQuery(Label.class);
        Root<Label> labelRoot = query.from(Label.class);
        query.where(criteriaBuilder.equal(labelRoot.get(Label_.id), id));
        query.select(labelRoot);

        Label label = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return label;
    }

    @Override
    public Label getByName(String labelName) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Label> query = criteriaBuilder.createQuery(Label.class);
        Root<Label> labelRoot = query.from(Label.class);
        query.where(criteriaBuilder.equal(labelRoot.get(Label_.labelName), labelName));
        query.select(labelRoot);

        Label label = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return label;
    }

    @Override
    public void update(Label label) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(label);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Label label) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(label);

        transaction.commit();
        session.close();
    }
}
