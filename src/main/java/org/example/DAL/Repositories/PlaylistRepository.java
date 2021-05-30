package org.example.DAL.Repositories;

import org.example.DAL.DAO.PlaylistDAO;
import org.example.DAL.Models.Playlist;
import org.example.DAL.Models.Playlist_;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PlaylistRepository implements PlaylistDAO {
    @Override
    public void add(Playlist playlist) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(playlist);

        transaction.commit();
        session.close();
    }

    @Override
    public List<Playlist> getAll() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Playlist> query = criteriaBuilder.createQuery(Playlist.class);
        Root<Playlist> playlistRoot = query.from(Playlist.class);
        query.select(playlistRoot);

        List<Playlist> playlists = session.createQuery(query).getResultList();

        transaction.commit();
        session.close();
        return playlists;
    }

    @Override
    public Playlist getById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Playlist> query = criteriaBuilder.createQuery(Playlist.class);
        Root<Playlist> playlistRoot = query.from(Playlist.class);
        query.where(criteriaBuilder.equal(playlistRoot.get(Playlist_.id), id));
        query.select(playlistRoot);

        Playlist playlist = session.createQuery(query).getSingleResult();

        transaction.commit();
        session.close();
        return playlist;
    }

    @Override
    public void update(Playlist playlist) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(playlist);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Playlist playlist) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.delete(playlist);

        transaction.commit();
        session.close();
    }
}
