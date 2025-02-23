package note.finder.persistence;

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

import java.util.List;

public class MusicalScaleDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get musicalScale by id
     */
    public MusicalScale getById(int id) {
        Session session = sessionFactory.openSession();
        MusicalScale musicalScale = session.get(MusicalScale.class, id);
        session.close();
        return musicalScale;
    }

    /**
     * update musicalScale
     * @param musicalScale  MusicalScale to be updated
     */
    public void update(MusicalScale musicalScale) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(musicalScale);
        transaction.commit();
        session.close();
    }

    /**
     * insert a new musicalScale
     * @param musicalScale  MusicalScale to be inserted
     */
    public int insert(MusicalScale musicalScale) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(musicalScale);
        transaction.commit();
        id = musicalScale.getId();
        session.close();
        return id;
    }

    /**
     * Delete a musicalScale
     * @param musicalScale MusicalScale to be deleted
     */
    public void delete(MusicalScale musicalScale) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(musicalScale);
        transaction.commit();
        session.close();
    }


    /**
     * Return a list of all musicalScales
     * @return All musicalScales
     */
    public List<MusicalScale> getAll() {

        Session session = sessionFactory.openSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MusicalScale> query = builder.createQuery(MusicalScale.class);
        Root<MusicalScale> root = query.from(MusicalScale.class);
        List<MusicalScale> musicalScales = session.createSelectionQuery( query ).getResultList();

        logger.debug("The list of musicalScales {}", musicalScales);
        session.close();

        return musicalScales;
    }

    /**
     * Get musicalScale by property (exact match)
     * sample usage: getByPropertyEqual("lastname", "Curry")
     */
    public List<MusicalScale> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for musicalScale with " + propertyName + " = " + value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MusicalScale> query = builder.createQuery(MusicalScale.class);
        Root<MusicalScale> root = query.from(MusicalScale.class);
        query.select(root).where(builder.equal(root.get(propertyName), value));
        List<MusicalScale> musicalScales = session.createSelectionQuery( query ).getResultList();

        session.close();
        return musicalScales;
    }

    /**
     * Get musicalScale by property (like)
     * sample usage: getByPropertyLike("lastname", "C")
     */
    public List<MusicalScale> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for musicalScale with {} = {}",  propertyName, value);

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MusicalScale> query = builder.createQuery(MusicalScale.class);
        Root<MusicalScale> root = query.from(MusicalScale.class);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<MusicalScale> musicalScales = session.createQuery( query ).getResultList();
        session.close();
        return musicalScales;
    }
}
