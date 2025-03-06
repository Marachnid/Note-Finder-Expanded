package note.finder.persistence;
import note.finder.entity.User;
import note.finder.entity.UserPattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.type.descriptor.java.CoercionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * testing class for NoteFinderDao, tests User and UserPattern classes
 */
class DaoUserPatternTest {

    Logger logger = LogManager.getLogger(this.getClass());

    //dao instances
    NoteFinderDao<UserPattern> patternDao;
    NoteFinderDao<User> userDao;

    //reused class types for testing patterns
    UserPattern pattern;
    UserPattern insertedPattern;
    UserPattern retrievedPattern;
    List<UserPattern> retrievedPatterns;

    //reused class types for testing users
    User user;
    User insertedUser;
    User retrievedUser;
    List<User> retrievedUsers;


    /** clean db and object assignment for tests */
    @BeforeEach
    void setUp() {
        patternDao = new NoteFinderDao<>(UserPattern.class);
        userDao = new NoteFinderDao<>(User.class);

        Database database = Database.getInstance();
        database.runSQL("user_clean.sql");
        database.runSQL("pattern_clean.sql");
    }

    /** tests retrieving patterns by id */
    @Test
    void getUserPatternById() {
        retrievedPattern = patternDao.getById(2);
        assertNotNull(retrievedPattern);
        assertEquals("test", retrievedPattern.getName());

        logger.info("getUserPatternById() Success");
    }

    /** tests retrieving users by id */
    @Test
    void getUserById() {
        retrievedUser = userDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("testUser", retrievedUser.getUsername());

        logger.info("getUserById() Success");
    }

    /** tests retrieving scales by foreign key */
    @Test
    void getPatternsByForeignKey() {
        retrievedPatterns = patternDao.getByForeignKey(1);
        assertEquals(2, retrievedPatterns.size());

        logger.info("getPatternsByForeignKey() Success");
    }

    /** tests retrieving all patterns */
    @Test
    void getAllPatterns() {
        retrievedPatterns= patternDao.getAll();
        assertEquals(3, retrievedPatterns.size());

        logger.info("getAllPatterns() Success");
    }

    /** tests retrieving all users */
    @Test
    void getAllUsers() {
        retrievedUsers = userDao.getAll();
        assertEquals(2, retrievedUsers.size());

        logger.info("getAllUsers() Success");
    }

    /** tests retrieving patterns by properties equal */
    @Test
    void getPatternByPropertyEqual() {
        retrievedPatterns = patternDao.getByPropertyEqual("name", "test");
        assertEquals(1, retrievedPatterns.size());

        retrievedPatterns = patternDao.getByPropertyEqual("id", "1");
        assertEquals(1, retrievedPatterns.size());

        logger.info("getPatternByPropertyEqual() Success");
    }

    /** tests retrieving users by properties equal */
    @Test
    void getUserByPropertyEqual() {
        retrievedUsers = userDao.getByPropertyEqual("username", "testUser");
        assertEquals(1, retrievedUsers.size());

        retrievedUsers = userDao.getByPropertyEqual("id", "1");
        assertEquals(1, retrievedUsers.size());

        logger.info("getUserByPropertyEqual() Success");
    }

    /** tests retrieving patterns by properties like */
    @Test
    void getPatternsByPropertyLike() {
        retrievedPatterns = patternDao.getByPropertyLike("name", "test");
        assertEquals(2, retrievedPatterns.size());

        logger.info("getPatternsByPropertyLike() Success");
    }

    /** tests for known coercion exception when searching number columns like a number */
    @Test
    void getPatternsByPropertyLikeFailure() {
        assertThrows(CoercionException.class, () ->
            retrievedPatterns = patternDao.getByPropertyLike("id", "1"));

        logger.info("getPatternsByPropertyLikeFailure() Success");
    }

    /** tests retrieving users by properties like */
    @Test
    void getUsersByPropertyLike() {
        retrievedUsers = userDao.getByPropertyLike("username", "testUser");
        assertEquals(2, retrievedUsers.size());

        logger.info("getUsersByPropertyLike() Success");
    }

    /** tests for known coercion exception when searching number columns like a number */
    @Test
    void getUsersByPropertyLikeFailure() {
        assertThrows(CoercionException.class, () ->
            retrievedUsers = userDao.getByPropertyLike("id", "1"));

        logger.info("getUsersByPropertyLikeFailure() Success");
    }


    /** tests updating a pattern */
    @Test
    void updatePattern() {
        pattern = patternDao.getById(1);
        pattern.setName("Major Triad");
        pattern.setRoot(0);
        pattern.setSecond(4);
        pattern.setThird(5);
        pattern.setForeignKey(userDao.getById(1));
        patternDao.update(pattern);

        retrievedPattern = patternDao.getById(1);
        assertEquals(pattern.getName(), retrievedPattern.getName());
        assertEquals(pattern.getRoot(), retrievedPattern.getRoot());
        assertEquals(pattern.getSecond(), retrievedPattern.getSecond());
        assertEquals(pattern.getThird(), retrievedPattern.getThird());
        assertEquals(pattern.getForeignKey().getId(), retrievedPattern.getForeignKey().getId());

        logger.info("updatePattern() Success");
    }

    /** tests updating a user */
    @Test
    void updateUser() {
        user = userDao.getById(1);
        user.setUsername("updateUser");
        userDao.update(user);

        retrievedUser = userDao.getById(1);
        assertEquals(user.getUsername(), retrievedUser.getUsername());

        logger.info("updateUser() Success");
    }

    /** tests inserting a pattern */
    @Test
    void insertPattern() {
        user = userDao.getById(1);
        pattern = new UserPattern("testPattern", 0, 1, 2, user);
        insertedPattern = patternDao.insert(pattern);
        retrievedPattern = patternDao.getById(insertedPattern.getId());

        assertNotNull(retrievedPattern);
        assertEquals(pattern.getName(), retrievedPattern.getName());
        assertEquals(pattern.getRoot(), retrievedPattern.getRoot());
        assertEquals(pattern.getSecond(), retrievedPattern.getSecond());
        assertEquals(pattern.getThird(), retrievedPattern.getThird());
        assertEquals(pattern.getForeignKey().getId(), retrievedPattern.getForeignKey().getId());

        logger.info("insertPattern() Success");
    }

    /** tests inserting a user */
    @Test
    void insertUser() {
        user = new User("testUser3");
        insertedUser = userDao.insert(user);
        retrievedUser = userDao.getById(insertedUser.getId());

        assertNotNull(retrievedUser);
        assertEquals(insertedUser.getId(), retrievedUser.getId());
        assertEquals(user.getUsername(), retrievedUser.getUsername());

        logger.info("insertUser() Success");
    }

    /** tests deleting a pattern */
    @Test
    void deletePattern() {
        pattern = patternDao.getById(1);
        patternDao.delete(pattern);
        assertNull(patternDao.getById(1));

        logger.info("deletePattern() Success");
    }

    /** tests deleting a user */
    @Test
    void deleteUser() {
        user = userDao.getById(1);
        userDao.delete(user);
        assertNull(userDao.getById(1));
        assertEquals(0, patternDao.getByForeignKey(1).size());

        logger.info("deleteUser() Success");
    }
}