package note.finder.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Class represents the category of musical scales
 */

@Entity
@Table(name = "category")
public class MusicalCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "foreignKey", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Set<MusicalScale> musicalScales;

    /** empty constructor */
    public MusicalCategory() {}


    /**
     * constructor
     * @param name name of category
     */
    public MusicalCategory(String name) {
        this.name = name;
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
     * get foreign dependency set
     * @return foreign dependency set
     */
    public Set<MusicalScale> getMusicalScales() {
        return musicalScales;
    }

    /**
     * set musicalScales
     * @param musicalScales set musicalScales
     */
    public void setMusicalScales(Set<MusicalScale> musicalScales) {
        this.musicalScales = musicalScales;
    }

    /**
     * returns a formatted string
     * @return formatted string
     */
    public String toString() {
        return "";
    }
}