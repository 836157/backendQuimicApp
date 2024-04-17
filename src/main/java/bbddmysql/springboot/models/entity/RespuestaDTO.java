package bbddmysql.springboot.models.entity;

public class RespuestaDTO {
    final int id;
    final String respuesta;
    final boolean es_correcta;


    public RespuestaDTO(int id, String respuesta, boolean esCorrecta) {
        this.id = id;
        this.respuesta = respuesta;
        es_correcta = esCorrecta;
    }
}
