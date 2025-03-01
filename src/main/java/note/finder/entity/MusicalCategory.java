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

    @OneToMany(mappedBy = "musicalCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MusicalScale> musicalScales;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<MusicalScale> getMusicalScales() {
        return musicalScales;
    }

    public void setMusicalScales(Set<MusicalScale> musicalScales) {
        this.musicalScales = musicalScales;
    }


    public String toString() {

        return "";
    }
}
