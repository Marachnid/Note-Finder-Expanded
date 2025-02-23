package note.finder.persistence;

import note.finder.entity.MusicalScale;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MusicalScaleDaoTest {

    private static SessionFactory sessionFactory;
    private static MusicalScaleDao musicalScaleDao;

    @BeforeAll
    public static void setUp() {
        // Initialize the SessionFactory and DAO
        SessionFactoryProvider.createSessionFactory();
        sessionFactory = SessionFactoryProvider.getSessionFactory();
        musicalScaleDao = new MusicalScaleDao();
    }

    @AfterAll
    public static void tearDown() {
        // Shutdown the SessionFactory
        SessionFactoryProvider.shutdown();
    }

    @Test
    public void testAddNewMusicalScale() {
        // Create a new MusicalScale entity
        MusicalScale scale = new MusicalScale("Test Scale", 0, 2, 4, 5, 7, 9, 11);

        // Add the new MusicalScale to the database
        int id = musicalScaleDao.addNewMusicalScale(scale);

        // Assert that the ID is not zero
        assertNotEquals(0, id);

        // Retrieve the MusicalScale from the database
        MusicalScale createdScale = musicalScaleDao.getById(id);

        // Assert that the retrieved scale is not null and matches the original scale
        assertEquals("Test Scale", createdScale.getName());
        assertEquals(0, createdScale.getRoot());
        assertEquals(2, createdScale.getSecond());
        assertEquals(4, createdScale.getThird());
        assertEquals(5, createdScale.getFourth());
        assertEquals(7, createdScale.getFifth());
        assertEquals(9, createdScale.getSixth());
        assertEquals(11, createdScale.getSeventh());
    }
}
