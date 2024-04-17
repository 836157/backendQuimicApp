package bbddmysql.springboot.models.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "valencias", schema = "bbddProyecto", catalog = "")
public class EntidadValencia {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "valor", nullable = false)
    private int valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadValencia that = (EntidadValencia) o;
        return id == that.id && valor == that.valor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor);
    }
}
