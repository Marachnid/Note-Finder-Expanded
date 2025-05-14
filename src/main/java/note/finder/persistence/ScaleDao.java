package note.finder.persistence;

import note.finder.entity.MusicalScale;
import org.hibernate.Session;
import java.util.List;

public class ScaleDao {


    private Session getSession() {return SessionFactoryProvider.getSessionFactory().openSession();}


    public List<MusicalScale> getAllScales() {
        List<MusicalScale> scales;
        try (Session session = getSession()) {
            scales = session.createQuery(
                "SELECT s FROM MusicalScale s LEFT JOIN FETCH s.foreignKey", MusicalScale.class)
                .getResultList();
        }
        return scales;
    }


}
