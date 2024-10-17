package Optional;

public class EmployeeNotFoundException  extends Exception{
    public EmployeeNotFoundException(String termino){
        super("No se enconctro el empleado solicitado con el termino: " + termino);
    }
}
