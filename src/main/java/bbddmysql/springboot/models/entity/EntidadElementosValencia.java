package bbddmysql.springboot.models.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Elementos_Valencias", schema = "bbddProyecto")
public class EntidadElementosValencia {
    @Basic
    @Column(name = "id_elemento", nullable = true)
    private Integer idElemento;
    @Basic
    @Column(name = "id_valencia", nullable = true)
    private Integer idValencia;
    @Id
    private Integer id;

    public Integer getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(Integer idElemento) {
        this.idElemento = idElemento;
    }

    public Integer getIdValencia() {
        return idValencia;
    }

    public void setIdValencia(Integer idValencia) {
        this.idValencia = idValencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadElementosValencia that = (EntidadElementosValencia) o;
        return Objects.equals(idElemento, that.idElemento) && Objects.equals(idValencia, that.idValencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idElemento, idValencia);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
