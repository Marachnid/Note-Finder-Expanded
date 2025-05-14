package note.finder.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Class represents a user
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "foreignKey", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserPattern> patterns;


    /** empty constructor */
    public User() {}


    /**
     * constructor with arguments
     * @param username User username
     */
    public User(String username) {
        this.username = username;
    }


    /**
     * get id
     * @return id
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
     * get username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * set username
     * @param username username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * get patterns
     * @return patterns
     */
    public Set<UserPattern> getPatterns() {
        return patterns;
    }

    /**
     * set patterns
     * @param patterns patterns
     */
    public void setPatterns(Set<UserPattern> patterns) {
        this.patterns = patterns;
    }

    /**
     * returns a formatted string
     * @return formatted string
     */
    public String toString() {

        return "";
    }
}
