package Optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AlternativeEmployeeService {
    public static List<Employee> getEmployeesFromDB(){
        return Arrays.asList(
                new Employee("fabiolo@email.com","Romina","Martinez", "Direccion conocida", "Programador"),
                new Employee("sofia@email.com", "Claudia", "Iturris", "Direccion conocida","Programadora"),
                new Employee("gabriel@email.com","Javier","Vazquez", "Direccion conocida", "Infraestructura"),
                new Employee("miriam@email.com", "Itzel", "Caballos","Direccion conocida", "Product Manager"),
                new Employee("juan@email.com", "Alonso", "Zamora", "Direccion conocida", "Scrum master"),
                new Employee("juan.alberto@email.com", "Juan Carlos", "Dorantes", "Direccion conocida", "QA"),
                new Employee("marisa@email.com", "Sofia", "Velez", "Direccion conocida", "QA")
        );
    }
    public Optional<Employee> findEmployeeByEmail(String email){
        return getEmployeesFromDB().stream().filter(employee -> employee.getCorreo().equals(email))
                .findFirst();
    }
}
