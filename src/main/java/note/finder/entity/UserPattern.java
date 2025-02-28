package note.finder.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "pattern")
public class UserPattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pattern_id")
    private int id;

    @Column(name = "pattern_name")
    private String patternName;

    @Column(name = "root")
    private int root;

    @Column(name = "second")
    private int second;

    @Column(name = "third")
    private int third;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_pattern"))
    private User user;



}
