package note.finder.entity;

import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserPattern> patterns;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<UserPattern> getPatterns() {
        return patterns;
    }

    public void setPatterns(Set<UserPattern> patterns) {
        this.patterns = patterns;
    }

    public String toString() {

        return "";
    }
}
