package note.finder.persistence;

import note.finder.entity.MusicalScale;
import org.hibernate.Session;
import java.util.List;

public class GenericDao {


    private Session getSession() {return SessionFactoryProvider.getSessionFactory().openSession();}


    /**
     *
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
     *
     * @param entityClass class being passed into method
     * @return results of query (does not retrieve 'many' associated results with the record)
     * @param <T> class type
     */
    public <T> List<T> getAllWithoutFK(Class<T> entityClass) {
        List<T> results;
        Session session = getSession();
        String queryString = "FROM " + entityClass.getSimpleName();
        results = session.createQuery(queryString, entityClass).getResultList();
        return results;
    }
}
