package pl.edu.TripEvaluator.entity;
import javax.persistence.ManyToOne;
import javax.persistence.*;

@Entity
public class Rewiev {
    @Id
    @GeneratedValue
    private Integer id;
    private String tresc;
    private Integer ocena;

    @ManyToOne
    @JoinColumn(name = "user.id")
    private User user ;



    public Rewiev() {
    }

    public Rewiev(Integer id, String tresc, Integer ocena, User user) {
        this.id = id;
        this.tresc = tresc;
        this.ocena = ocena;
        this.user = user;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

//    @Override
//    public String toString() {
//        return "Rewiev {" + "id= " + id + "tresc= " + tresc + "ocena= " +ocena + "}";
//    }
}
