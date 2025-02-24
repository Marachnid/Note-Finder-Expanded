package note.finder.persistence;

import note.finder.entity.MusicalScale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class MusicalScaleDaoTest {

    MusicalScaleDao scaleDao;
    MusicalScale musicalScale;

    /** run setup processes before each test */
    @BeforeEach
    void setUp() {
        scaleDao = new MusicalScaleDao();
        Database database = Database.getInstance();
        database.runSQL("short_scales_clean.sql");
    }

    /** tests getting a scale object/record by its id */
    @Test
    void getByIdSuccess() {
        musicalScale = scaleDao.getById(1);
        assertNotNull(musicalScale);
        assertEquals("Natural Minor", musicalScale.getName());
        assertEquals(0, musicalScale.getRoot());
        assertEquals(2, musicalScale.getSecond());
        assertEquals(3, musicalScale.getThird());
    }

    /** tests updating an existing record */
    @Test
    void updateSuccess() {
        musicalScale = scaleDao.getById(1);
        musicalScale.setName("Augmented Minor");
        musicalScale.setRoot(0);
        musicalScale.setSecond(1);
        musicalScale.setThird(2);
        scaleDao.update(musicalScale);

        MusicalScale updatedScale = scaleDao.getById(1);
        assertEquals("Augmented Minor", updatedScale.getName());
        assertEquals(0, updatedScale.getRoot());
        assertEquals(1, updatedScale.getSecond());
        assertEquals(2, updatedScale.getThird());
    }

    /** tests inserting a new scale object into DB */
    @Test
    void insertSuccess() {
        musicalScale = new MusicalScale("Test", 1, 2, 3);
        int newScaleId = scaleDao.insert(musicalScale);
        assertNotEquals(0, newScaleId);

        MusicalScale createdScale = scaleDao.getById(newScaleId);
        assertEquals("Test", createdScale.getName());
        assertEquals(1, createdScale.getRoot());
        assertEquals(2, createdScale.getSecond());
        assertEquals(3, createdScale.getThird());
    }

    /** tests deleting a record from DB */
    @Test
    void deleteSuccess() {
        scaleDao.delete(1);
        List<MusicalScale> updatedScales = scaleDao.getAll();
        assertEquals(2, updatedScales.size());
        assertNull(scaleDao.getById(1));
    }

    /** tests retrieving all records from DB */
    @Test
    void getAllSuccess() {
        List<MusicalScale> scales = scaleDao.getAll();
        assertEquals(3, scales.size());
    }

    /** tests retrieving an object by its name */
    @Test
    void getByPropertyName() {

        String scaleName = scaleDao.getByPropertyName("hungarian minor");
        assertEquals("Hungarian Minor", scaleName);
    }

    /** tests retrieving an object by similarity like a search term */
    @Test
    void getByPropertyLike() {

        List<MusicalScale> scales = scaleDao.getByPropertyLike("name", "minor");
        assertEquals(2, scales.size());
    }
}