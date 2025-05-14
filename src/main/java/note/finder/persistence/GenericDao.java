package note.finder.persistence;

import note.finder.entity.MusicalScale;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GenericDao<T> {

    private Class<T> entityClass;
    private Session getSession() {return SessionFactoryProvider.getSessionFactory().openSession();}

    /**empty constructor*/
    public GenericDao() {}

    /**
     * constructor with class type
     * @param entityClass class type/entity to use
     */
    public GenericDao(Class<T> entityClass) {this.entityClass = entityClass;}


    /**
     * retrieves records with their foreign entities (many-to-one relationships)
     * @param entityClass class being passed into the method
     * @param foreignReference the name of the foreign key reference for the entity
     * @return results of query ('many' records with 'one' associated foreign key reference)
     * @param <T> class type
     */
    public <T> List<T> getAllWithFK(Class<T> entityClass, String foreignReference) {
        List<T> results;
        Session session = getSession();
        String queryString = "SELECT entity FROM " + entityClass.getSimpleName() + " entity LEFT JOIN FETCH entity." + foreignReference;
        results = session.createQuery(queryString, entityClass).getResultList();
        return results;
    }


    /**
     * retrieves records without their foreign entities (one-to-many relationships)
     * @param entityClass class being passed into method
     * @return results of query (does not retrieve 'many' associated results with the record)
     * @param <T> class type
     */
    public <T> List<T> getAllWithoutFK(Class<T> entityClass) {
        List<T> results;
        Session session = getSession();

        //hql syntax, omits SELECT when retrieving entire entities
        String queryString = "FROM " + entityClass.getSimpleName();
        results = session.createQuery(queryString, entityClass).getResultList();
        return results;
    }


    /**
     * inserts a new record
     * @param entity entity object being inserted
     */
    public void insert(T entity) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {transaction.rollback();}
            e.printStackTrace();
        }
    }


    /**
     * updates a record
     * @param entity entity object being updated
     */
    public void update(T entity, int id) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();

            //retrieve existing entity from database
            T existingEntity = (T) session.get(entity.getClass(), id);
            if (existingEntity != null) {
                session.merge(entity); //only merge updated fields
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    /**
     * deletes a record
     * @param entityClass entity object/record to be deleted
     * @param id id of object to be deleted
     */
    public void delete(Class<T> entityClass, int id) {
        Transaction transaction = null;
        try (Session session = getSession()) {
            transaction = session.beginTransaction();

            //get entity by ID before deleting, if exists
            T entity = session.get(entityClass, id);
            if (entity != null) {session.delete(entity);}
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }







}
