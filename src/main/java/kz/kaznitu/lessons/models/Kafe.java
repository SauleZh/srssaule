package kz.kaznitu.lessons.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Kafe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    private String kafeName ;
    private String kalaName ;
    private int nomer ;

    public Kafe(){}

    public Kafe(String kafeName, String kalaName, int nomer) {
        this.kafeName = kafeName;
        this.kalaName=kalaName;
        this.nomer = nomer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKafeName() {
        return kafeName;
    }

    public void setKafeName(String kafeName) {
        this.kafeName = kafeName;
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

