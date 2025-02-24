package note.finder.persistence;

import jakarta.persistence.NoResultException;
import note.finder.entity.MusicalScale;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import javax.validation.ConstraintViolationException;
import java.util.List;


/** Dao Class for MusicalSCale's, contains queries for CRUD */
public class MusicalScaleDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get musicalScale by id
     * @param id id value of object to query for
     */
    public MusicalScale getById(int id) {

        Session session = sessionFactory.openSession();
        MusicalScale musicalScale = null;

        try {
            musicalScale = session.get(MusicalScale.class, id);

        } catch (NoResultException exception) {
            logger.info("No scales found for getById()", exception);

        } catch (Exception exception) {
            logger.debug("Failed to get scales by getById()", exception);

        } finally {
            session.close();
        }
        return musicalScale;
    }

    /**
     * update musicalScale
     * @param musicalScale  MusicalScale object to be updated
     */
    public void update(MusicalScale musicalScale) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(musicalScale);
            transaction.commit();

        } catch (NullPointerException exception) {
            logger.debug("Null object used", exception);

        } catch (Exception exception) {
            logger.debug("Failed to update object", exception);
        }
    }

    /**
     * insert a new musicalScale object into DB
     * @param musicalScale  MusicalScale object to be inserted
     */
    public int insert(MusicalScale musicalScale) {

        Session session = sessionFactory.openSession();
        int id = 0;

        try {
            Transaction transaction = session.beginTransaction();
            session.persist(musicalScale);
            transaction.commit();
            id = musicalScale.getId();

        } catch (ConstraintViolationException exception) {
            logger.debug("Invalid DB data types", exception);

        } catch (NullPointerException exception) {
            logger.debug("Null object", exception);

        } catch (Exception exception) {
            logger.debug("Failed to insert object", exception);

        } finally {
            session.close();
        }

        return id;
    }

    /**
     * Delete a musicalScale object from DB records
     * @param id id of MusicalScale object to be deleted
     */
    public void delete(int id) {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            MusicalScale musicalScale = session.get(MusicalScale.class, id);
            session.remove(musicalScale);
            transaction.commit();

        } catch (NullPointerException exception) {
            logger.debug("Null ID value", exception);

        } catch (Exception exception) {
            logger.debug("Failed to delete object", exception);
        }
    }


    /**
     * Return a list of all musicalScales
     * @return All musicalScales
     */
    public List<MusicalScale> getAll() {

        Session session = sessionFactory.openSession();
        List<MusicalScale> musicalScales = null;

        try {
            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<MusicalScale> query = builder.createQuery(MusicalScale.class);
            musicalScales = session.createSelectionQuery(query).getResultList();

        } catch (NoResultException exception) {
            logger.info("No scales found for getAll()");

        } catch (Exception exception) {
            logger.debug("Failed to retrieve all scales", exception);

        } finally {
            session.close();
        }

        return musicalScales;
    }

    /**
     * Modified version of getPropertyEqual()
     * going to need some work in the future, had to ditch unique name values
     * to simplify updating process
     * Servlet should handle duplicates but needs to be looked at
     * @param value string value/keyword used to query db
     */
    public String getByPropertyName(String value) {
        Session session = sessionFactory.openSession();
        MusicalScale musicalScale;
        String scaleName = null;

        try {
            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<MusicalScale> query = builder.createQuery(MusicalScale.class);
            Root<MusicalScale> root = query.from(MusicalScale.class);
            query.where(builder.equal(root.get("name"), value));
            musicalScale = (session.createSelectionQuery( query ).getSingleResult());
            scaleName = musicalScale.getName();

        } catch (NoResultException exception) {
            logger.info("No scales found for name: {}", scaleName, exception);

        } catch (Exception exception){
            logger.debug("Failed to get scale by name: {}", scaleName, exception);

        } finally {
            session.close();
        }

        return scaleName;
    }

    /**
     * Get musicalScale by property (like)
     * @param propertyName name of the column/property being queries
     * @param value string value/keyword used for querying
     */
    public List<MusicalScale> getByPropertyLike(String propertyName, String value) {

        Session session = sessionFactory.openSession();
        List<MusicalScale> musicalScales = null;

        try {
            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<MusicalScale> query = builder.createQuery(MusicalScale.class);
            Root<MusicalScale> root = query.from(MusicalScale.class);
            Expression<String> propertyPath = root.get(propertyName);

            query.where(builder.like(propertyPath, "%" + value + "%"));
            musicalScales = session.createQuery(query).getResultList();

        } catch (NoResultException exception) {
            logger.info("No scales found for {} = {}", propertyName, value, exception);

        } catch (Exception exception) {
            logger.debug("Failed to get scales by {} = {}",  propertyName, value, exception);

        } finally {
            session.close();
        }

        return musicalScales;
    }
}
