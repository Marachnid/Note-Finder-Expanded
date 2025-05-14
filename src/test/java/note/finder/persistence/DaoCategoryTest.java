//package note.finder.persistence;
//
//import note.finder.entity.MusicalCategory;
//import note.finder.entity.MusicalScale;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.hibernate.type.descriptor.java.CoercionException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * testing class for NoteFinderDao, tests category CRUD
// */
//public class DaoCategoryTest {
//
//    Logger logger = LogManager.getLogger(this.getClass());
//
//    //reused class types for testing categories
//    NoteFinderDao<MusicalCategory> categoryDao;
//    MusicalCategory category;
//    MusicalCategory insertedCategory;
//    MusicalCategory retrievedCategory;
//    List<MusicalCategory> retrievedCategories;
//    Database database;
//
//    /** clean db and object assignment for tests */
//    @BeforeEach
//    void setUp() {
//        categoryDao = new NoteFinderDao<>(MusicalCategory.class);
//        database = Database.getInstance();
//        database.runSQL("category_clean.sql");
//        database.runSQL("scale_clean.sql");
//    }
//
//
//    /** tests retrieving categories by id */
//    @Test
//    void getCategoryById() {
//        retrievedCategory = categoryDao.getById(2);
//        assertNotNull(retrievedCategory);
//        assertEquals("Minor", retrievedCategory.getName());
//
//        logger.info("getCategoryById() Success");
//    }
//
//    /** tests retrieving all categories */
//    @Test
//    void getAllCategories() {
//        retrievedCategories = categoryDao.getAll();
//        assertEquals(4, retrievedCategories.size());
//
//        logger.info("getAllCategories() Success");
//    }
//
//    /** tests retrieving categories by properties equal */
//    @Test
//    void getCategoryByPropertyEqual() {
//        retrievedCategories = categoryDao.getByPropertyEqual("name", "diminished");
//        assertEquals(1, retrievedCategories.size());
//
//        retrievedCategories = categoryDao.getByPropertyEqual("id", "1");
//        assertEquals(1, retrievedCategories.size());
//
//        logger.info("getCategoryByPropertyEqual() Success");
//    }
//
//    /** tests retrieving categories by properties like */
//    @Test
//    void getCategoryByPropertyLike() {
//        retrievedCategories = categoryDao.getByPropertyLike("name", "mi");
//        assertEquals(2, retrievedCategories.size());
//
//        logger.info("getCategoryByPropertyLike() Success");
//    }
//
//    /** tests for known coercion exception when searching number columns like a number */
//    @Test
//    void getCategoryByPropertyLikeFailure() {
//        assertThrows(CoercionException.class, () ->
//                retrievedCategories = categoryDao.getByPropertyLike("id", "1"));
//
//        logger.info("getCategoryByPropertyLikeFailure() Success");
//    }
//
//    /** tests updating a category */
//    @Test
//    void updateCategory() {
//        category = categoryDao.getById(1);
//        category.setName("Custom");
//        categoryDao.update(category);
//
//        retrievedCategory = categoryDao.getById(1);
//        assertNotNull(retrievedCategory);
//        assertEquals(category.getName(), retrievedCategory.getName());
//
//        logger.info("updateCategory() Success");
//    }
//
//    /** tests inserting a category */
//    @Test
//    void insertMusicalCategory() {
//        category = new MusicalCategory("Custom");
//        insertedCategory = categoryDao.insert(category);
//
//        retrievedCategory = categoryDao.getById(insertedCategory.getId());
//        assertNotNull(retrievedCategory);
//        assertEquals(category.getId(), retrievedCategory.getId());
//        assertEquals(category.getName(), retrievedCategory.getName());
//
//        logger.info("insertMusicalCategory() Success");
//    }
//
//    /** tests deleting a category */
//    @Test
//    void deleteMusicalCategory() {
//        NoteFinderDao<MusicalScale> scaleDao = new NoteFinderDao<>(MusicalScale.class);
//        category = categoryDao.getById(1);
//        categoryDao.delete(category);
//        assertNull(categoryDao.getById(1));
//        assertEquals(0, scaleDao.getByForeignKey(1).size());
//
//        logger.info("deleteMusicalCategory() Success");
//    }
//}
