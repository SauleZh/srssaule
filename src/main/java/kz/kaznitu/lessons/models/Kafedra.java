package kz.kaznitu.lessons.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kafedra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String KafedraName;
    private int year;


    public Kafedra() {
    }

    public Kafedra(String kafedraName, int year) {
        KafedraName = kafedraName;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKafedraName() {
        return KafedraName;
    }

    public void setKafedraName(String kafedraName) {
        KafedraName = kafedraName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

