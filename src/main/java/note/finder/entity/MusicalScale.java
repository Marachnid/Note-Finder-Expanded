package note.finder.entity;


import javax.persistence.*;



/**
 * Class represents the intervals of a full musical scale
 * Scales contain 7 notes (intervals) which are determined by their
 * tonal position/distance from the root note
 * All Notes: A, A#, B, C, C#, D, D#, E, F, F#, G, G#
 * (if root == A ? secondInterval = B) A = 0, A# = 1, B = 2
 */
@Entity
@Table(name = "musical_scale_intervals")
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

    @Column(name = "fourth_interval")
    private int fourth;

    @Column(name = "fifth_interval")
    private int fifth;

    @Column(name = "sixth_interval")
    private int sixth;

    @Column(name = "seventh_interval")
    private int seventh;


    //empty constructor
    public MusicalScale() {}

    /**
     * instantiates a MusicalScale object w/interval arguments
     * @param name name of scale
     * @param root root interval
     * @param second second interval
     * @param third third interval
     * @param fourth fourth interval
     * @param fifth fifth interval
     * @param sixth sixth interval
     * @param seventh interval
     */
    public MusicalScale(String name, int root, int second, int third, int fourth,
                        int fifth, int sixth, int seventh) {
        this.name = name;
        this.root = root;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
        this.fifth = fifth;
        this.sixth = sixth;
        this.seventh = seventh;
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
     * gets fourth interval
     * @return fourth interval
     */
    public int getFourth() {
        return fourth;
    }

    /**
     * sets fourth interval
     * @param fourth interval
     */
    public void setFourth(int fourth) {
        this.fourth = fourth;
    }

    /**
     * gets fifth interval
     * @return fifth interval
     */
    public int getFifth() {
        return fifth;
    }

    /**
     * sets fifth interval
     * @param fifth interval
     */
    public void setFifth(int fifth) {
        this.fifth = fifth;
    }

    /**
     * gets sixth interval
     * @return sixth interval
     */
    public int getSixth() {
        return sixth;
    }

    /**
     * sets sixth interval
     * @param sixth interval
     */
    public void setSixth(int sixth) {
        this.sixth = sixth;
    }

    /**
     * gets seventh interval
     * @return seventh interval
     */
    public int getSeventh() {
        return seventh;
    }

    /**
     * sets seventh interval
     * @param seventh interval
     */
    public void setSeventh(int seventh) {
        this.seventh = seventh;
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
                + ", fourth=" + fourth + '\''
                + ", fifth=" + fifth + '\''
                + ", sixth=" + sixth + '\''
                + ", seventh=" + seventh + '\''
                + '}';
    }
}
