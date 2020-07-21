package Models;

public class Curso {
    private int idCurso;
    private int idDocente;
    private String nombre;
    private String fechaInicio;
    private String turno;
    private String horario;
    private String seccion;

    public Curso(int idDocente, String nombre, String fechaInicio, String turno, String horario, String seccion) {
        this.idDocente = idDocente;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.turno = turno;
        this.horario = horario;
        this.seccion = seccion;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
}
