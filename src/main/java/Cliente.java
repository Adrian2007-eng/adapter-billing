public class Cliente {
    private String nombre;
    private String ruc;

    public Cliente(String nombre, String ruc) {
        this.nombre = nombre;
        this.ruc    = ruc;
    }

    public String getNombre() { return nombre; }
    public String getRuc()    { return ruc; }
}
