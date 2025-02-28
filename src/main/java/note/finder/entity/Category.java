package note.finder.entity;


import jakarta.persistence.*;

import java.util.ArrayList;


@Entity(name = "Category")
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private ArrayList<MusicalScale> musicalScales = new ArrayList<>();



    public void addMusicalScale(MusicalScale musicalScale) {
        musicalScales.add(musicalScale);
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", musicalScales=" + musicalScales +
                '}';
    }
}
