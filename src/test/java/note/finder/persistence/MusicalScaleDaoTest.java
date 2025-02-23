package note.finder.persistence;

import note.finder.entity.MusicalScale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
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


    }

    @Test
    void getAll() {


    }

    @Test
    void getByPropertyEqual() {


    }

    @Test
    void getByPropertyLike() {


    }
}