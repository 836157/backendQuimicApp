package bbddmysql.springboot.models.entity;



public class PreguntaDTO {
    final int id;
    final String pregunta;
    final String tematica;


    public PreguntaDTO(int id, String pregunta, String tematica) {
        this.id = id;
        this.pregunta = pregunta;
        this.tematica = tematica;
    }
}
