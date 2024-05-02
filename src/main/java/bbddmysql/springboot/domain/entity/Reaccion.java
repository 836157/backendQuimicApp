package bbddmysql.springboot.domain.entity;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="reacciones", schema = "bbddProyecto")
public class Reaccion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "reaccion",nullable = false)
    private String reaccion;
    @Basic
    @Column(name="A", nullable = true)
    private Integer A;
    @Basic
    @Column(name="B", nullable = true)
    private Integer B;
    @Basic
    @Column(name="C", nullable = true)
    private Integer C;
    @Basic
    @Column(name="D", nullable = true)
    private Integer D;
    @Basic
    @Column(name="E", nullable = true)
    private Integer E;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReaccion() {
        return reaccion;
    }

    public void setReaccion(String reaccion) {
        this.reaccion = reaccion;
    }

    public Integer getA() {
        return A;
    }

    public void setA(Integer a) {
        A = a;
    }

    public Integer getB() {
        return B;
    }

    public void setB(Integer b) {
        B = b;
    }

    public Integer getC() {
        return C;
    }

    public void setC(Integer c) {
        C = c;
    }

    public Integer getD() {
        return D;
    }

    public void setD(Integer d) {
        D = d;
    }

    public Integer getE() {
        return E;
    }

    public void setE(Integer e) {
        E = e;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reaccion reaccion1 = (Reaccion) o;
        return getId() == reaccion1.getId() && Objects.equals(getReaccion(), reaccion1.getReaccion()) && Objects.equals(getA(), reaccion1.getA()) && Objects.equals(getB(), reaccion1.getB()) && Objects.equals(getC(), reaccion1.getC()) && Objects.equals(getD(), reaccion1.getD()) && Objects.equals(getE(), reaccion1.getE());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getReaccion(), getA(), getB(), getC(), getD(), getE());
    }
}






