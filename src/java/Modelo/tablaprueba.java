package Modelo;

public class tablaprueba {
    private int pk_tabla;
    private String codigo;

    public tablaprueba() {
    }

    public tablaprueba(int pk_tabla, String codigo) {
        this.pk_tabla = pk_tabla;
        this.codigo = codigo;
    }

    public int getPk_tabla() {
        return pk_tabla;
    }

    public void setPk_tabla(int pk_tabla) {
        this.pk_tabla = pk_tabla;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
}
