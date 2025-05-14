//package note.finder.persistence;
//import note.finder.entity.User;
//import note.finder.entity.UserPattern;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.hibernate.type.descriptor.java.CoercionException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * testing class for NoteFinderDao, tests UserPattern CRUD
// */
//class DaoPatternTest {
//
//    Logger logger = LogManager.getLogger(this.getClass());
//
//    //reused class types for testing patterns
//    NoteFinderDao<UserPattern> patternDao;
//    NoteFinderDao<User> userDao;
//    UserPattern pattern;
//    UserPattern insertedPattern;
//    UserPattern retrievedPattern;
//    List<UserPattern> retrievedPatterns;
//    User user;
//    Database database;
//
//
//    /** clean db and object assignment for tests */
//    @BeforeEach
//    void setUp() {
//        patternDao = new NoteFinderDao<>(UserPattern.class);
//        userDao = new NoteFinderDao<>(User.class);
//
//        database = Database.getInstance();
//        database.runSQL("user_clean.sql");
//        database.runSQL("pattern_clean.sql");
//    }
//
//
//    /** tests retrieving patterns by id */
//    @Test
//    void getUserPatternById() {
//        retrievedPattern = patternDao.getById(2);
//        assertNotNull(retrievedPattern);
//        assertEquals("test", retrievedPattern.getName());
//
//        logger.info("getUserPatternById() Success");
//    }
//
//    /** tests retrieving scales by foreign key */
//    @Test
//    void getPatternsByForeignKey() {
//        retrievedPatterns = patternDao.getByForeignKey(1);
//        assertEquals(2, retrievedPatterns.size());
//
//        logger.info("getPatternsByForeignKey() Success");
//    }
//
//    /** tests retrieving all patterns */
//    @Test
//    void getAllPatterns() {
//        retrievedPatterns= patternDao.getAll();
//        assertEquals(3, retrievedPatterns.size());
//
//        logger.info("getAllPatterns() Success");
//    }
//
//    /** tests retrieving patterns by properties equal */
//    @Test
//    void getPatternByPropertyEqual() {
//        retrievedPatterns = patternDao.getByPropertyEqual("name", "test");
//        assertEquals(1, retrievedPatterns.size());
//
//        retrievedPatterns = patternDao.getByPropertyEqual("id", "1");
//        assertEquals(1, retrievedPatterns.size());
//
//        logger.info("getPatternByPropertyEqual() Success");
//    }
//
//    /** tests retrieving patterns by properties like */
//    @Test
//    void getPatternsByPropertyLike() {
//        retrievedPatterns = patternDao.getByPropertyLike("name", "test");
//        assertEquals(2, retrievedPatterns.size());
//
//        logger.info("getPatternsByPropertyLike() Success");
//    }
//
//    /** tests for known coercion exception when searching number columns like a number */
//    @Test
//    void getPatternsByPropertyLikeFailure() {
//        assertThrows(CoercionException.class, () ->
//            retrievedPatterns = patternDao.getByPropertyLike("id", "1"));
//
//        logger.info("getPatternsByPropertyLikeFailure() Success");
//    }
//
//    /** tests updating a pattern */
//    @Test
//    void updatePattern() {
//        pattern = patternDao.getById(1);
//        pattern.setName("Major Triad");
//        pattern.setRoot(0);
//        pattern.setSecond(4);
//        pattern.setThird(5);
//        pattern.setForeignKey(userDao.getById(1));
//        patternDao.update(pattern);
//
//        retrievedPattern = patternDao.getById(1);
//        assertEquals(pattern.getName(), retrievedPattern.getName());
//        assertEquals(pattern.getRoot(), retrievedPattern.getRoot());
//        assertEquals(pattern.getSecond(), retrievedPattern.getSecond());
//        assertEquals(pattern.getThird(), retrievedPattern.getThird());
//        assertEquals(pattern.getForeignKey().getId(), retrievedPattern.getForeignKey().getId());
//
//        logger.info("updatePattern() Success");
//    }
//
//    /** tests inserting a pattern */
//    @Test
//    void insertPattern() {
//        user = userDao.getById(1);
//        pattern = new UserPattern("testPattern", 0, 1, 2, user);
//        insertedPattern = patternDao.insert(pattern);
//        retrievedPattern = patternDao.getById(insertedPattern.getId());
//
//        assertNotNull(retrievedPattern);
//        assertEquals(pattern.getName(), retrievedPattern.getName());
//        assertEquals(pattern.getRoot(), retrievedPattern.getRoot());
//        assertEquals(pattern.getSecond(), retrievedPattern.getSecond());
//        assertEquals(pattern.getThird(), retrievedPattern.getThird());
//        assertEquals(pattern.getForeignKey().getId(), retrievedPattern.getForeignKey().getId());
//
//        logger.info("insertPattern() Success");
//    }
//
//    /** tests deleting a pattern */
//    @Test
//    void deletePattern() {
//        pattern = patternDao.getById(1);
//        patternDao.delete(pattern);
//        assertNull(patternDao.getById(1));
//
//        logger.info("deletePattern() Success");
//    }
//}