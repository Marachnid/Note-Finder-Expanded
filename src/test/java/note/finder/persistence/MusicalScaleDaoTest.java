package note.finder.persistence;

import note.finder.entity.MusicalScale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MusicalScaleDao
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

    /** tests inserting an empty MusicalScale object into DB */
    @Test
    void insertNullObjectSuccess() {

        List<MusicalScale> existingScales = scaleDao.getAll();
        int listSize = existingScales.size();

        musicalScale = new MusicalScale();
        scaleDao.insert(musicalScale);

        assertEquals(3, listSize);
    }

    /** tests deleting a record from DB */
    @Test
    void deleteSuccess() {
        scaleDao.delete(1);
        List<MusicalScale> updatedScales = scaleDao.getAll();
        assertEquals(2, updatedScales.size());
        assertNull(scaleDao.getById(1));
    }

    /** tests deleting a record from DB that doesn't exist */
    @Test
    void deleteFailureSuccess() {
        assertNull(scaleDao.getById(6));
        scaleDao.delete(6);
        List<MusicalScale> updatedScales = scaleDao.getAll();
        assertEquals(3, updatedScales.size());
    }

    /** tests retrieving all records from DB */
    @Test
    void getAllSuccess() {
        List<MusicalScale> scales = scaleDao.getAll();
        assertEquals(3, scales.size());
    }

    /** tests retrieving all records from DB when no records exist */
    @Test
    void getAllFailureSuccess() {

        scaleDao.delete(1);
        scaleDao.delete(2);
        scaleDao.delete(3);
        List<MusicalScale> scales = scaleDao.getAll();
        assertEquals(0, scales.size());
    }

    /** tests retrieving an object by its name */
    @Test
    void getByPropertyNameSuccess() {

        String scaleName = scaleDao.getByPropertyName("hungarian minor");
        assertEquals("Hungarian Minor", scaleName);
    }

    /** tests retrieving an object by a non-existent name */
    @Test
    void getPropertyNameFailureSuccess() {

        String scaleName = scaleDao.getByPropertyName("hungarian");
        assertNull(scaleName);
    }

    /** tests retrieving an object by similarity like a search term */
    @Test
    void getByPropertyLikeSuccess() {

        List<MusicalScale> scales = scaleDao.getByPropertyLike("name", "minor");
        assertEquals(2, scales.size());
    }

    /** tests retrieving a list of records with a non-existing term */
    @Test
    void getPropertyLikeFailureSuccess() {

        List<MusicalScale> scales = scaleDao.getByPropertyLike("name", "test");
        assertEquals(0, scales.size());
    }
}