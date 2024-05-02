package bbddmysql.springboot.domain.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "preguntas")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pregunta")
    private String pregunta;

    @Column(name = "tematica")
    private String tematica;

    @OneToMany(mappedBy = "pregunta" ,cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pregunta pregunta1 = (Pregunta) o;
        return Objects.equals(getId(), pregunta1.getId()) && Objects.equals(getPregunta(), pregunta1.getPregunta()) && Objects.equals(getTematica(), pregunta1.getTematica()) && Objects.equals(getRespuestas(), pregunta1.getRespuestas());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}

