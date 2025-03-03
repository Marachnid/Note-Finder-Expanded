package note.finder.entity;

import jakarta.persistence.*;

/**
 * Class represents patterns of a user
 */
@Entity
@Table(name = "pattern")
public class UserPattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pattern_id")
    private int id;

    @Column(name = "pattern_name")
    private String name;

    @Column(name = "root")
    private int root;

    @Column(name = "second")
    private int second;

    @Column(name = "third")
    private int third;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_pattern"))
    private User foreignKey;


    /** empty constructor */
    public UserPattern() {}


    /**
     * constructor
     * @param name name
     * @param root root
     * @param second second
     * @param third third
     * @param foreignKey foreignKey
     */
    public UserPattern(String name, int root, int second, int third, User foreignKey) {
        this.name = name;
        this.root = root;
        this.second = second;
        this.third = third;
        this.foreignKey = foreignKey;
    }

    /**
     * get id
     * @return return id
     */
    public int getId() {
        return id;
    }

    /**
     * set id
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get foreign key
     * @return foreignKey
     */
    public User getForeignKey() {
        return foreignKey;
    }

    /**
     * set foreign key
     * @param foreignKey foreignKey
     */
    public void setForeignKey(User foreignKey) {
        this.foreignKey = foreignKey;
    }

    /**
     * get name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get root
     * @return root
     */
    public int getRoot() {
        return root;
    }

    /**
     * set root
     * @param root root
     */
    public void setRoot(int root) {
        this.root = root;
    }

    /**
     * set second
     * @return second
     */
    public int getSecond() {
        return second;
    }

    /**
     * get second
     * @param second second
     */
    public void setSecond(int second) {
        this.second = second;
    }

    /**
     * get third
     * @return third
     */
    public int getThird() {
        return third;
    }

    /**
     * set third
     * @param third get third
     */
    public void setThird(int third) {
        this.third = third;
    }


    /**
     * return formatted string
     * @return formatted string
     */
    public String toString() {
        return "";
    }
}
