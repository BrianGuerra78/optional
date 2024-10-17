package Optional;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeController {

    /*public Employee findEmployeeByEmail(String email){
        Optional<Employee> optionalEmployee = new EmployeeService().findEmployeeEmail(email);
        if (optionalEmployee.isPresent()){
            return optionalEmployee.get();
        }else {
            return null;
        }
    }*/
    /*public Optional<Employee> findEmployeeByEmail(String email){
        return new EmployeeService().findEmployeeEmail(email);
    }*/
    public Optional<Employee> findEmployeeByEmail(String email){
        Optional<Employee> optionalEmployeeService = new EmployeeService().findEmployeeEmail(email);

        Optional<Employee> optionalAlternativeEmployeeService = new AlternativeEmployeeService().
                findEmployeeByEmail(email);

        return optionalEmployeeService.or(()-> optionalAlternativeEmployeeService);
    }

    public Optional<Employee> isDeveloperOptional(String email){
      return findEmployeeByEmail(email).filter(employee -> employee.getOficio().equals("Programador"));
    }

    public static void main(String[] args) {
        EmployeeController controller = new EmployeeController();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el email del empleado: ");
        String email = scanner.next();

        Optional<Employee> empleadoOptional = controller.findEmployeeByEmail(email);
        System.out.println("Forma1");
        empleadoOptional.ifPresent(employee -> System.out.println(employee));
        //System.out.println(empleado);
        System.out.println("--------");
        System.out.println("Forma2");
        empleadoOptional.ifPresentOrElse(
                employee -> System.out.println(employee),
                () -> System.out.println("No se encontro el objeto empleado")
        );
        System.out.println("--------");
        System.out.println("Forma3");
        Employee empleado = empleadoOptional.orElse(EmployeeService.defaultEmployee());
        System.out.println(empleado);

        System.out.println("--------");
        System.out.println("Forma4");
        Employee employee = empleadoOptional.orElseGet(() -> EmployeeService.defaultEmployee());
        System.out.println(employee);

        System.out.println("--------");
        System.out.println("Forma5");
        Employee employee2;
        try {
            employee2 = empleadoOptional.orElseThrow(() -> new EmployeeNotFoundException(email));
            System.out.println(employee);
        }catch (EmployeeNotFoundException ex){
            //Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE,null,ex);
            System.out.println(ex);
        }

        System.out.println("--------");
        System.out.println("Forma6");
        controller.isDeveloperOptional(email).ifPresentOrElse(
                employee1 -> System.out.println("El empleado " + employee1.getNombre() + " es programador"),
                ()-> System.out.println("El empleado no existe o no es programador")
                );

        System.out.println("--------");
        System.out.println("Forma7");
        empleadoOptional.map(emp -> emp.getCorreo()).ifPresent(System.out::println);
    }
}
