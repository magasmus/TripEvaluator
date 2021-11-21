package pl.edu.TripEvaluator.entity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tytul;
    private String destynacja;
    private Double cena;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Rewiev> reviewList=new ArrayList<>();




    public Trip() {
    }


    public Trip(Integer id, String tytul, String destynacja, Double cena, List<Rewiev> reviewList) {
        this.id = id;
        this.tytul = tytul;
        this.destynacja = destynacja;
        this.cena = cena;
        this.reviewList = reviewList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getDestynacja() {
        return destynacja;
    }

    public void setDestynacja(String destynacja) {
        this.destynacja = destynacja;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public List<Rewiev> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Rewiev> reviewList) {
        this.reviewList = reviewList;
    }

//    @Override
//    public String toString() {
//        return "Trip {" + "id= " +id + "tytul= " +tytul + "destynacja=  " + destynacja + "cena: " + cena + "opinie: " + Arrays.toString(reviewList.toArray()) + "}";
//    }



}
