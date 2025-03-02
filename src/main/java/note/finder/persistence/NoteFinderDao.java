package note.finder.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
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

    private final Class<T> type;
    private EntityManager entityManager;
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
    public T getById(int id) {
        Session session = getSession();
        T entity = session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * grabs values by their foreign key id
     * @param foreignId foreign ID being searched
     * @return records list by foreign key id
     */
    public List<T> getByForeignKey(int foreignId) {

        Session session = getSession();
        String foreignKey = "foreignKey";
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.where(builder.equal(root.get(foreignKey).get("id"), foreignId));
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
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

        //parses string to integer if it can be (ie "1", "2"... to 1, 2)
        Object convertedValue = value;
        try {
            convertedValue = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            //if value can't be parsed, use the original value and continue
        }

        query.select(root).where(builder.equal(root.get(propertyName), convertedValue));
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
        List<T> list = session.createQuery(query).getResultList();
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
    public T insert(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        session.close();

        return entity;
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