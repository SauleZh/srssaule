package kz.kaznitu.lessons.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Restoran {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String RestoranName ;
    private String kalaName ;
    private int nomer ;

    public Restoran(){}

    public Restoran(String RestoranName, String kalaName, int nomer) {
        this.RestoranName = RestoranName;
        this.kalaName=kalaName;
        this.nomer = nomer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRestoranName() {
        return RestoranName;
    }

    public void setRestoranName(String RestoranName) { this.RestoranName = RestoranName;
    }

    public String getKalaName() {
        return kalaName;
    }

    public void setKalaName(String kalaName) {
        this.kalaName = kalaName;
    }

    public int getNomer() {
        return nomer;
    }

    public void setNomer(int nomer) {
        this.nomer = nomer;
    }
}

