package Models;

public class PlanCurso {
    private int id;
    private String fecha;
    private int avance;

    public PlanCurso(String fecha, int avance) {
        this.fecha = fecha;
        this.avance = avance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAvance() {
        return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }
}
