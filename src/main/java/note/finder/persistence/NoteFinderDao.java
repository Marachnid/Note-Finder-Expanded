package note.finder.persistence;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import note.finder.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public class NoteFinderDao<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * instantiates a generic DAO for the project
     * @param type entity class type
     */
    public NoteFinderDao(Class<T> type) {
        this.type = type;
    }

    /**
     * returns an open session from SessionFactory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }


    /**
     * Get entity by id
     * @param id id of entity being queried
     */
    public <T>T getById(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }
    /**
     * returns a list of all entities
     * @return list of all entities
     */
    public List<T> getAll() {

        Session session = getSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createSelectionQuery(query).getResultList();
        session.close();

        return list;
    }

    /**
     * get entity by property (equal)
     * @param propertyName name of the property/column being queried
     * @param value value being used to query column
     */
    public List<T> getByPropertyEqual(String propertyName, String value) {

        Session session = getSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<T> list = session.createSelectionQuery(query).getResultList();
        session.close();

        return list;
    }

    /**
     * get entity by property (like)
     * @param propertyName name of the property/column being queried
     * @param value value being used to query column
     */
    public List<T> getByPropertyLike(String propertyName, String value) {

        Session session = getSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);
        query.where(builder.like(propertyPath, "%" + value + "%"));
        List<T> list = (List<T>)session.createQuery(query).getResultList();
        session.close();

        return list;
    }

    /**
     * update an entity
     * @param entity  entity to be updated
     */
    public void update(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(entity);
        transaction.commit();
        session.close();
    }

    /**
     * insert a new entity
     * @param entity  entity to be inserted
     */
    public void insert(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();
    }

    /**
     * delete an entity
     * @param entity entity to be deleted
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.remove(entity);
        transaction.commit();
        session.close();
    }
}