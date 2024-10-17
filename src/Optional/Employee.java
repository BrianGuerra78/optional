package Optional;

public class Employee {

    private String correo;
    private String nombre;
    private String apellido;
    private String direccion;
    private String oficio;

    public Employee(String correo, String nombre, String apellido, String direccion, String oficio) {
        this.correo = correo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.oficio = oficio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Employee{");
        sb.append("nombre= ").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", direccion=").append(direccion);
        sb.append(", puesto=").append(oficio);
        sb.append("}");
        return sb.toString();
    }
}
