package bbddmysql.springboot.domain.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ElementosQuimicos", schema = "bbddProyecto")
public class Element {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nombre", nullable = true, length = 255)
    private String nombre;
    @Basic
    @Column(name = "numeroAtomico", nullable = true)
    private Integer numeroAtomico;
    @Basic
    @Column(name = "simbolo", nullable = true, length = 5)
    private String simbolo;
    @Basic
    @Column(name = "pesoAtomico", nullable = true, precision = 4)
    private float pesoAtomico;
    @Basic
    @Column(name = "geometriaMasComun", nullable = true, length = 255)
    private String geometriaMasComun;
    @Basic
    @Column(name = "densidad", nullable = true, precision = 4)
    private float densidad;
    @Basic
    @Column(name = "puntoFusion", nullable = true, precision = 4)
    private float puntoFusion;
    @Basic
    @Column(name = "puntoEbullicion", nullable = true, precision = 4)
    private float puntoEbullicion;
    @Basic
    @Column(name = "calorEspecifico", nullable = true, precision = 4)
    private float calorEspecifico;
    @Basic
    @Column(name = "electronegatividad", nullable = true, precision = 4)
    private float electronegatividad;
    @Basic
    @Column(name = "radioAtomico", nullable = true, precision = 4)
    private float radioAtomico;
    @Basic
    @Column(name = "radioCovalente", nullable = true, precision = 4)
    private float radioCovalente;
    @Basic
    @Column(name = "radioIonico", nullable = true, precision = 4)
    private float radioIonico;
    @Basic
    @Column(name = "familia", nullable = false)
    private String familia;
    @Basic
    @Column(name = "color1", nullable = false)
    private String color1;
    @Basic
    @Column(name = "color2", nullable = false)
    private String color2;
    @Basic
    @Column(name = "source", nullable = false)
    private String source;
    @Basic
    @Column(name = "posicionX", nullable = false)
    private int posicionX;
    @Basic
    @Column(name = "posicionY", nullable = false)
    private int posicionY;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Elementos_Valencias",
            joinColumns = @JoinColumn(name = "id_elemento"),
            inverseJoinColumns = @JoinColumn(name = "id_valencia"))
    private List<EntidadValencia> valencias;

    public List<EntidadValencia> getValencias() {
        return valencias;
    }


    public String getColor1() {
        return color1;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public String getColor2() {
        return color2;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroAtomico() {
        return numeroAtomico;
    }

    public void setNumeroAtomico(Integer numeroAtomico) {
        this.numeroAtomico = numeroAtomico;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public float getPesoAtomico() {
        return pesoAtomico;
    }

    public void setPesoAtomico(float pesoAtomico) {
        this.pesoAtomico = pesoAtomico;
    }

    public String getGeometriaMasComun() {
        return geometriaMasComun;
    }

    public void setGeometriaMasComun(String geometriaMasComun) {
        this.geometriaMasComun = geometriaMasComun;
    }

    public float getDensidad() {
        return densidad;
    }

    public void setDensidad(float densidad) {
        this.densidad = densidad;
    }

    public float getPuntoFusion() {
        return puntoFusion;
    }

    public void setPuntoFusion(float puntoFusion) {
        this.puntoFusion = puntoFusion;
    }

    public float getPuntoEbullicion() {
        return puntoEbullicion;
    }

    public void setPuntoEbullicion(float puntoEbullicion) {
        this.puntoEbullicion = puntoEbullicion;
    }

    public float getCalorEspecifico() {
        return calorEspecifico;
    }

    public void setCalorEspecifico(float calorEspecifico) {
        this.calorEspecifico = calorEspecifico;
    }

    public float getElectronegatividad() {
        return electronegatividad;
    }

    public void setElectronegatividad(float electronegatividad) {
        this.electronegatividad = electronegatividad;
    }

    public float getRadioAtomico() {
        return radioAtomico;
    }

    public void setRadioAtomico(float radioAtomico) {
        this.radioAtomico = radioAtomico;
    }

    public float getRadioCovalente() {
        return radioCovalente;
    }

    public void setRadioCovalente(float radioCovalente) {
        this.radioCovalente = radioCovalente;
    }

    public float getRadioIonico() {
        return radioIonico;
    }

    public void setRadioIonico(float radioIonico) {
        this.radioIonico = radioIonico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element that = (Element) o;
        return id == that.id && Objects.equals(nombre, that.nombre) && Objects.equals(numeroAtomico, that.numeroAtomico) && Objects.equals(simbolo, that.simbolo) && Objects.equals(pesoAtomico, that.pesoAtomico) && Objects.equals(geometriaMasComun, that.geometriaMasComun) && Objects.equals(densidad, that.densidad) && Objects.equals(puntoFusion, that.puntoFusion) && Objects.equals(puntoEbullicion, that.puntoEbullicion) && Objects.equals(calorEspecifico, that.calorEspecifico) && Objects.equals(electronegatividad, that.electronegatividad) && Objects.equals(radioAtomico, that.radioAtomico) && Objects.equals(radioCovalente, that.radioCovalente) && Objects.equals(radioIonico, that.radioIonico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, numeroAtomico, simbolo, pesoAtomico, geometriaMasComun, densidad, puntoFusion, puntoEbullicion, calorEspecifico, electronegatividad, radioAtomico, radioCovalente, radioIonico, familia, color1, color2, source, posicionX, posicionY);
    }

}
