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
// * testing class for NoteFinderDao, tests User CRUD
// */
//class DaoUserTest {
//
//    Logger logger = LogManager.getLogger(this.getClass());
//
//    //reused class types for testing users
//    NoteFinderDao<User> userDao;
//    User user;
//    User insertedUser;
//    User retrievedUser;
//    List<User> retrievedUsers;
//    Database database;
//
//    /** clean db and object assignment for tests */
//    @BeforeEach
//    void setUp() {
//        userDao = new NoteFinderDao<>(User.class);
//        database = Database.getInstance();
//        database.runSQL("user_clean.sql");
//        database.runSQL("pattern_clean.sql");
//    }
//
//
//    /** tests retrieving users by id */
//    @Test
//    void getUserById() {
//        retrievedUser = userDao.getById(1);
//        assertNotNull(retrievedUser);
//        assertEquals("testUser", retrievedUser.getUsername());
//
//        logger.info("getUserById() Success");
//    }
//
//    /** tests retrieving all users */
//    @Test
//    void getAllUsers() {
//        retrievedUsers = userDao.getAll();
//        assertEquals(2, retrievedUsers.size());
//
//        logger.info("getAllUsers() Success");
//    }
//
//    /** tests retrieving users by properties equal */
//    @Test
//    void getUserByPropertyEqual() {
//        retrievedUsers = userDao.getByPropertyEqual("username", "testUser");
//        assertEquals(1, retrievedUsers.size());
//
//        retrievedUsers = userDao.getByPropertyEqual("id", "1");
//        assertEquals(1, retrievedUsers.size());
//
//        logger.info("getUserByPropertyEqual() Success");
//    }
//
//    /** tests retrieving users by properties like */
//    @Test
//    void getUsersByPropertyLike() {
//        retrievedUsers = userDao.getByPropertyLike("username", "testUser");
//        assertEquals(2, retrievedUsers.size());
//
//        logger.info("getUsersByPropertyLike() Success");
//    }
//
//    /** tests for known coercion exception when searching number columns like a number */
//    @Test
//    void getUsersByPropertyLikeFailure() {
//        assertThrows(CoercionException.class, () ->
//                retrievedUsers = userDao.getByPropertyLike("id", "1"));
//
//        logger.info("getUsersByPropertyLikeFailure() Success");
//    }
//
//    /** tests updating a user */
//    @Test
//    void updateUser() {
//        user = userDao.getById(1);
//        user.setUsername("updateUser");
//        userDao.update(user);
//
//        retrievedUser = userDao.getById(1);
//        assertEquals(user.getUsername(), retrievedUser.getUsername());
//
//        logger.info("updateUser() Success");
//    }
//
//    /** tests inserting a user */
//    @Test
//    void insertUser() {
//        user = new User("testUser3");
//        insertedUser = userDao.insert(user);
//        retrievedUser = userDao.getById(insertedUser.getId());
//
//        assertNotNull(retrievedUser);
//        assertEquals(insertedUser.getId(), retrievedUser.getId());
//        assertEquals(user.getUsername(), retrievedUser.getUsername());
//
//        logger.info("insertUser() Success");
//    }
//
//    /** tests deleting a user */
//    @Test
//    void deleteUser() {
//        NoteFinderDao<UserPattern> patternDao = new NoteFinderDao<>(UserPattern.class);
//        user = userDao.getById(1);
//        userDao.delete(user);
//        assertNull(userDao.getById(1));
//        assertEquals(0, patternDao.getByForeignKey(1).size());
//
//        logger.info("deleteUser() Success");
//    }
//}