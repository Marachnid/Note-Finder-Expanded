package note.finder.persistence;

import note.finder.entity.MusicalScale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MusicalScaleDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    /**
     * Get musical scale by id
     */
    public MusicalScale getById(int id) {
        Session session = sessionFactory.openSession();
        MusicalScale musicalScale = session.get(MusicalScale.class, id);
        session.close();
        return musicalScale;
    }


    public int addNewMusicalScale(MusicalScale musicalScale) {
        int id = 0;
        Session session = sessionFactory.openSession();
        try (session) {
            Transaction transaction = session.beginTransaction();
            session.persist(musicalScale);
            session.flush(); // Ensure the entity is persisted before committing
            transaction.commit();
            id = musicalScale.getId();
            logger.info("Persisted MusicalScale with ID: " + id);
        } catch (Exception e) {

            logger.error("Error persisting MusicalScale", e);
        }
        return id;
    }

}
