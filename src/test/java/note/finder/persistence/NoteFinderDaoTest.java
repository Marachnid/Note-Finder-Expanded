package note.finder.persistence;

import note.finder.entity.MusicalCategory;
import note.finder.entity.MusicalScale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NoteFinderDaoTest {

    NoteFinderDao scaleDao;
    NoteFinderDao categoryDao;


    @BeforeEach
    void setUp() {

        scaleDao = new NoteFinderDao(MusicalScale.class);
        categoryDao = new NoteFinderDao(MusicalCategory.class);

        Database database = Database.getInstance();
        database.runSQL("category_clean.sql");
        database.runSQL("scale_clean.sql");
//        database.runSQL("user_clean");
//        database.runSQL("pattern_clean");
    }

    @Test
    void getById() {

        //scales
        MusicalScale retrievedScale = (MusicalScale)scaleDao.getById(2);
        assertNotNull(retrievedScale);
        assertEquals("Natural Major", retrievedScale.getName());

        //categories
        MusicalCategory retrievedCategory = (MusicalCategory)categoryDao.getById(2);
        assertNotNull(retrievedCategory);
        assertEquals("Minor", retrievedCategory.getName());
    }

    @Test
    void getAll() {

        //scales
        List<MusicalScale> scales = scaleDao.getAll();
        assertEquals(3, scales.size());

        //categories
        List<MusicalCategory> categories = categoryDao.getAll();
        assertEquals(4, categories.size());
    }

    @Test
    void getByPropertyEqual() {

        //scales
        List<MusicalScale> scaleNames = scaleDao.getByPropertyEqual("name", "Natural Minor");
        assertEquals(1, scaleNames.size());

        //categories
        List<MusicalCategory> categoryNames = categoryDao.getByPropertyEqual("id", "1");
        assertEquals(1, categoryNames.size());

    }

    @Test
    void getByPropertyLike() {

        //scales
        List<MusicalScale> scales = scaleDao.getByPropertyLike("name", "minor");
        assertEquals(2, scales.size());

        //categories
        List<MusicalCategory> categories = categoryDao.getByPropertyLike("name", "mi");
        assertEquals(2, categories.size());
    }

    @Test
    void update() {


    }

    @Test
    void insert() {
    }

    @Test
    void delete() {

//        MusicalScale scale = (MusicalScale)scaleDao.getById(2);
//        scaleDao.delete(scale);
//        assertNull(scaleDao.getById(2));

        MusicalCategory category = (MusicalCategory)categoryDao.getById(1);
        categoryDao.delete(category);


        assertNull(categoryDao.getById(1));
//        assertEquals(0, scaleDao.getByPropertyLike("name", "major").size());
        assertNull(scaleDao.getByPropertyEqual("musicalCategory", "1"));

    }
}