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

    @BeforeEach
    void setUp() {

        scaleDao = new MusicalScaleDao();

        Database database = Database.getInstance();
        database.runSQL("short_scales_clean.sql");
    }

    @Test
    void getByIdSuccess() {

        MusicalScale scale = scaleDao.getById(1);
        assertNotNull(scale);
        assertEquals("Natural Minor", scale.getName());
        assertEquals(0, scale.getRoot());
        assertEquals(2, scale.getSecond());
        assertEquals(3, scale.getThird());

    }

    @Test
    void update() {

        MusicalScale scale = scaleDao.getById(1);
        scale.setName("Augmented Minor");
        scale.setRoot(0);
        scale.setSecond(1);
        scale.setThird(2);
        scaleDao.update(scale);

        MusicalScale updatedScale = scaleDao.getById(1);
        assertEquals("Augmented Minor", updatedScale.getName());
        assertEquals(0, updatedScale.getRoot());
        assertEquals(1, updatedScale.getSecond());
        assertEquals(2, updatedScale.getThird());
    }

    @Test
    void insert() {

        MusicalScale newUser = new MusicalScale("Test", 1, 2, 3);
        int newUserId = scaleDao.insert(newUser);
        assertNotEquals(0, newUserId);

        MusicalScale createdUser = scaleDao.getById(newUserId);
        assertEquals("Test", createdUser.getName());
        assertEquals(1, createdUser.getRoot());
        assertEquals(2, createdUser.getSecond());
        assertEquals(3, createdUser.getThird());

    }

    @Test
    void delete() {

        MusicalScale scaleToDelete = scaleDao.getById(1);
        scaleDao.delete(scaleToDelete);

        List<MusicalScale> updatedScales = scaleDao.getAll();
        assertEquals(2, updatedScales.size());
        assertNull(scaleDao.getById(1));
    }

    @Test
    void getAll() {

        List<MusicalScale> scales = scaleDao.getAll();
        assertEquals(3, scales.size());
    }

    @Test
    void getByPropertyEqual() {

        List<MusicalScale> scales = scaleDao.getByPropertyEqual("name", "hungarian minor");
        assertEquals(1, scales.size());
    }

    @Test
    void getByPropertyName() {

        String scaleName = scaleDao.getByPropertyName("hungarian minor");
        assertEquals("Hungarian Minor", scaleName);
    }

    @Test
    void getByPropertyLike() {

        List<MusicalScale> scales = scaleDao.getByPropertyLike("name", "minor");
        assertEquals(2, scales.size());
    }
}