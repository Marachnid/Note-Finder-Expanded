package note.finder.entity;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Column;

import jakarta.persistence.*;

/**
 * Class represents the intervals of a full musical scale
 * Scales contain 7 notes (intervals) which are determined by their
 * tonal position/distance from the root note
 * All Notes: A, A#, B, C, C#, D, D#, E, F, F#, G, G#
 * (if root == A ? secondInterval = B) A = 0, A# = 1, B = 2
 * TEMPORARILY SHORTENED TO 3RD INTERVAL FOR TESTING
 */
@Entity
@Table(name = "scale_intervals")
public class MusicalScale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scale_id")
    private int id;

    @Column(name = "scale_name")
    private String name;

    @Column(name = "root_interval")
    private int root;

    @Column(name = "second_interval")
    private int second;

    @Column(name = "third_interval")
    private int third;


    //empty constructor
    public MusicalScale() {}

    /**
     * instantiates a MusicalScale object w/interval arguments
     * @param name name of scale
     * @param root root interval
     * @param second second interval
     * @param third third interval
     */
    public MusicalScale(String name, int root, int second, int third) {
        this.name = name;
        this.root = root;
        this.second = second;
        this.third = third;

    }

    /**
     * return scale ID
     * @return scale ID
     */
    public int getId() {
        return id;
    }

    /**
     * sets scale ID
     * @param id scale ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets scale name
     * @return scale name
     */
    public String getName() {
        return name;
    }

    /**
     * sets scale name
     * @param name scale name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets root note interval
     * @return root note interval
     */
    public int getRoot() {
        return root;
    }

    /**
     * sets root note interval
     * @param root interval
     */
    public void setRoot(int root) {
        this.root = root;
    }

    /**
     * gets second interval
     * @return second interval
     */
    public int getSecond() {
        return second;
    }

    /**
     * sets second interval
     * @param second interval
     */
    public void setSecond(int second) {
        this.second = second;
    }

    /**
     * gets third interval
     * @return third interval
     */
    public int getThird() {
        return third;
    }

    /**
     * sets third interval
     * @param third interval
     */
    public void setThird(int third) {
        this.third = third;
    }



    /**
     * toString method - formats MusicalScale data
     * @return formatted output of object data
     */
    public String toString() {
        return "MusicalScale{"
                + "id=" + id + '\''
                + ", name='" + name + '\''
                + ", root=" + root + '\''
                + ", second=" + second + '\''
                + ", third=" + third + '\''
                + '}';
    }
}
