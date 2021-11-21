package pl.edu.TripEvaluator.entity;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    private Integer id;
    private String imie;
    private String pseudonim;


    @OneToMany (mappedBy = "user")
    private List<Rewiev> rewievs;


//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "author.id")






    public User() {
    }

    public User(Integer id, String imie, String pseudonim) {
        this.id = id;
        this.imie = imie;
        this.pseudonim = pseudonim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getPseudonim() {
        return pseudonim;
    }

    public void setPseudonim(String pseudonim) {
        this.pseudonim = pseudonim;
    }

    @Override
    public String toString() {
        return "User {" + "id= " +id + "imie= " + imie + "psedonim= " + pseudonim + "}";
    }

}
