package note.finder.entity;

import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "category")
public class MusicalCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "musicalCategory", cascade = CascadeType.ALL, orphanRemoval = false)
    private Set<MusicalScale> musicalScales;
}
