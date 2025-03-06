package note.finder.persistence;
import note.finder.entity.MusicalCategory;
import note.finder.entity.MusicalScale;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.type.descriptor.java.CoercionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * testing class for NoteFinderDao, tests utilization of user, pattern, scale, and category db's
 */
class DaoCategoryScaleTest {

    Logger logger = LogManager.getLogger(this.getClass());

    //dao instances
    NoteFinderDao<MusicalScale> scaleDao;
    NoteFinderDao<MusicalCategory> categoryDao;

    //reused class types for testing scales
    MusicalScale scale;
    MusicalScale insertedScale;
    MusicalScale retrievedScale;
    List<MusicalScale> retrievedScales;

    //reused class types for testing categories
    MusicalCategory category;
    MusicalCategory insertedCategory;
    MusicalCategory retrievedCategory;
    List<MusicalCategory> retrievedCategories;

    /** clean db and object assignment for tests */
    @BeforeEach
    void setUp() {
        scaleDao = new NoteFinderDao<>(MusicalScale.class);
        categoryDao = new NoteFinderDao<>(MusicalCategory.class);

        Database database = Database.getInstance();
        database.runSQL("category_clean.sql");
        database.runSQL("scale_clean.sql");
    }

    /** tests retrieving scales by id */
    @Test
    void getScaleById() {
        retrievedScale = scaleDao.getById(2);
        assertNotNull(retrievedScale);
        assertEquals("Natural Major", retrievedScale.getName());

        logger.info("getScaleById() Success");
    }

    /** tests retrieving categories by id */
    @Test
    void getCategoryById() {
        retrievedCategory = categoryDao.getById(2);
        assertNotNull(retrievedCategory);
        assertEquals("Minor", retrievedCategory.getName());

        logger.info("getCategoryById() Success");
    }

    /** tests retrieving scales by foreign key */
    @Test
    void getScalesByForeignKey() {
        retrievedScales = scaleDao.getByForeignKey(1);
        assertEquals(1, retrievedScales.size());

        logger.info("getScalesByForeignKey() Success");
    }

    /** tests retrieving all scales */
    @Test
    void getAllScales() {
        retrievedScales = scaleDao.getAll();
        assertEquals(3, retrievedScales.size());

        logger.info("getAllScales() Success");
    }

    /** tests retrieving all categories */
    @Test
    void getAllCategories() {
        retrievedCategories = categoryDao.getAll();
        assertEquals(4, retrievedCategories.size());

        logger.info("getAllCategories() Success");
    }

    /** tests retrieving scales by properties equal */
    @Test
    void getScaleByPropertyEqual() {
        retrievedScales = scaleDao.getByPropertyEqual("name", "Natural Minor");
        assertEquals(1, retrievedScales.size());

        retrievedScales = scaleDao.getByPropertyEqual("root", "0");
        assertEquals(3, retrievedScales.size());

        //quick test to check what would happen if a number is included (getPropertyEqual().. tries to parse string to int)
        category = categoryDao.getById(2);
        scale = new MusicalScale("minor 7", 0, 1, 3, category);
        scaleDao.insert(scale);

        retrievedScales = scaleDao.getByPropertyEqual("name", "minor 7");
        assertEquals(1, retrievedScales.size());

        logger.info("getScaleByPropertyEqual() Success");
    }

    /** tests retrieving categories by properties equal */
    @Test
    void getCategoryByPropertyEqual() {
        retrievedCategories = categoryDao.getByPropertyEqual("name", "diminished");
        assertEquals(1, retrievedCategories.size());

        retrievedCategories = categoryDao.getByPropertyEqual("id", "1");
        assertEquals(1, retrievedCategories.size());

        logger.info("getCategoryByPropertyEqual() Success");
    }

    /** tests retrieving scales by properties like */
    @Test
    void getScaleByPropertyLike() {
        retrievedScales = scaleDao.getByPropertyLike("name", "minor");
        assertEquals(2, retrievedScales.size());

        logger.info("getScaleByPropertyLike() Success");
    }

    /** tests for known coercion exception when searching number columns like a number */
    @Test
    void getScaleByPropertyLikeFailure() {
        assertThrows(CoercionException.class, () -> {
            retrievedScales = scaleDao.getByPropertyLike("id", "1");
        });

        logger.info("getScaleByPropertyLikeFailure() Success");
    }

    /** tests retrieving categories by properties like */
    @Test
    void getCategoryByPropertyLike() {
        retrievedCategories = categoryDao.getByPropertyLike("name", "mi");
        assertEquals(2, retrievedCategories.size());

        logger.info("getCategoryByPropertyLike() Success");
    }

    /** tests for known coercion exception when searching number columns like a number */
    @Test
    void getCategoryByPropertyLikeFailure() {
        assertThrows(CoercionException.class, () -> {
            retrievedCategories = categoryDao.getByPropertyLike("id", "1");
        });

        logger.info("getCategoryByPropertyLikeFailure() Success");
    }

    /** tests updating a scale */
    @Test
    void updateScale() {
        scale = scaleDao.getById(1);
        scale.setName("Minor");
        scale.setRoot(1);
        scale.setSecond(5);
        scale.setThird(7);
        scale.setForeignKey(categoryDao.getById(1));
        scaleDao.update(scale);

        retrievedScale = scaleDao.getById(1);
        assertEquals(scale.getName(), retrievedScale.getName());
        assertEquals(scale.getRoot(), retrievedScale.getRoot());
        assertEquals(scale.getSecond(), retrievedScale.getSecond());
        assertEquals(scale.getThird(), retrievedScale.getThird());
        assertEquals(scale.getForeignKey().getId(), retrievedScale.getForeignKey().getId());

        logger.info("updateScale() Success");
    }

    /** tests updating a category */
    @Test
    void updateCategory() {
        category = categoryDao.getById(1);
        category.setName("Custom");
        categoryDao.update(category);

        retrievedCategory = categoryDao.getById(1);
        assertNotNull(retrievedCategory);
        assertEquals(category.getName(), retrievedCategory.getName());

        logger.info("updateCategory() Success");
    }

    /** tests inserting a scale */
    @Test
    void insertMusicalScale() {
        category = categoryDao.getById(1);
        scale = new MusicalScale("Test Scale", 0, 1, 3, category);
        insertedScale = scaleDao.insert(scale);

        retrievedScale = scaleDao.getById(insertedScale.getId());
        assertNotNull(retrievedScale);
        assertEquals(scale.getId(), retrievedScale.getId());
        assertEquals(scale.getName(), retrievedScale.getName());
        assertEquals(scale.getRoot(), retrievedScale.getRoot());
        assertEquals(scale.getSecond(), retrievedScale.getSecond());
        assertEquals(scale.getThird(), retrievedScale.getThird());
        assertEquals(scale.getForeignKey().getId(), retrievedScale.getForeignKey().getId());

        logger.info("insertMusicalScale() Success");
    }

    /** tests inserting a category */
    @Test
    void insertMusicalCategory() {
        category = new MusicalCategory("Custom");
        insertedCategory = categoryDao.insert(category);

        retrievedCategory = categoryDao.getById(insertedCategory.getId());
        assertNotNull(retrievedCategory);
        assertEquals(category.getId(), retrievedCategory.getId());
        assertEquals(category.getName(), retrievedCategory.getName());

        logger.info("insertMusicalCategory() Success");
    }

    /** tests deleting a scale */
    @Test
    void deleteMusicalScale() {
        scale = scaleDao.getById(1);
        scaleDao.delete(scale);
        assertNull(scaleDao.getById(1));

        logger.info("deleteMusicalScale() Success");
    }

    /** tests deleting a category */
    @Test
    void deleteMusicalCategory() {
        category = categoryDao.getById(1);
        categoryDao.delete(category);
        assertNull(categoryDao.getById(1));
        assertEquals(0, scaleDao.getByForeignKey(1).size());

        logger.info("deleteMusicalCategory() Success");
    }
}