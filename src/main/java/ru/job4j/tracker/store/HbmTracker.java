package ru.job4j.tracker.store;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import ru.job4j.tracker.model.Item;

import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public void close() throws Exception {
        if (sf.getCurrentSession().isOpen()) {
            sf.getCurrentSession().close();
        }
    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        int rows = 0;
        try {
            session.beginTransaction();
            rows = session.createQuery("update Item as i set i.name = :fName, i.created = :fCreated where i.id = :fId")
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return rows > 0;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        int rows = 0;
        try {
            session.beginTransaction();
            rows = session.createQuery("delete Item as i where i.id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return rows > 0;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        Session session = sf.openSession();
        try {
            Query query = session.createQuery("from Item as i order by i.id");
            rsl = query.list();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        Session session = sf.openSession();
        try {
            Query query = session.createQuery("from Item as i where i.name = :fName order by i.id")
                    .setParameter("fName", key);
            rsl = query.list();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Item rsl = null;
        try {
            Query<Item> query = session.createQuery("from Item as i where i.id = :fId", Item.class)
                    .setParameter("fId", id);
            rsl = query.getSingleResult();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return rsl;
    }
}
