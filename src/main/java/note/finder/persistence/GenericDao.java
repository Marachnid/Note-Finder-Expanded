package note.finder.persistence;

import note.finder.entity.MusicalScale;
import org.hibernate.Session;
import java.util.List;

public class GenericDao {


    private Session getSession() {return SessionFactoryProvider.getSessionFactory().openSession();}


//    public List<MusicalScale> getAllScales() {
//        List<MusicalScale> scales;
//        try (Session session = getSession()) {
//            scales = session.createQuery(
//                "SELECT scale FROM MusicalScale scale LEFT JOIN FETCH scale.foreignKey", MusicalScale.class)
//                .getResultList();
//        }
//        return scales;
//    }


    public <T> List<T> getAllWithForeignEntity(Class<T> entityClass, String foreignReference) {
        List<T> results;
        try (Session session = getSession()) {
            String queryString = "SELECT entity FROM " + entityClass.getSimpleName() + " entity LEFT JOIN FETCH entity." + foreignReference;
            results = session.createQuery(queryString, entityClass).getResultList();
        }
        return results;
    }

}
