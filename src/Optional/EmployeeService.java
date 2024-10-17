package Optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeService {
    public static List<Employee> getEmployeesFromDB(){
        return Arrays.asList(
                new Employee("romina@email.com","Romina","Martinez", "Direccion desconocida", "Programador"),
                new Employee("claudia@email.com", "Claudia", "Iturri", "Direcccion conocida", "Programador"),
                new Employee("javier@email.com", "Javier", "Vazquez", "Direccion conocida", "Programador"),
                new Employee("itzel@email.com", "Itzel", "Caballos", "Direccion conocida", "Infraestructura"),
                new Employee("alonso@email.com", "Alonso", "Zamora", "Direccion conocida", "Product Manager"),
                new Employee("mara@email.com", "Mara", "Gonzalez", "Direcion conocida", "Scrum Master"),
                new Employee("juan.carlos@email.com","Juan Carlos", "Dorantes", "Direccion conocida", "QA"),
                new Employee("sofia@email.com", "Sofia", "Velez", "Direccion conocida", "QA")
        );
    }
    public Optional<Employee> findEmployeeEmail(String email){
        /* List<Employee> employees = getEmployeesFromDB().stream().filter(employee -> employee.getCorreo().equals(email))
                .collect(Collectors.toList());
        Employee employee= employees.get(0);
        if (employee != null){
            return Optional.of(employee);
        }else {
            return Optional.empty();
        }*/
        return getEmployeesFromDB().stream().filter(employee -> employee.getCorreo().equals(email))
                .findFirst();
    };

    //abstract Employee defaultEmployee();

    public static Employee defaultEmployee(){
        return new Employee("default@email.com", "Default", "Default",
                "Direccion conocida", "Programador");
    }
}
