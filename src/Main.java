import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.createNewEmployee("Ivanov1 Ivan1 Ivanovich1", 1, BigDecimal.valueOf(10_000));
        employeeBook.createNewEmployee("Ivanov2 Ivan2 Ivanovich2", 2, BigDecimal.valueOf(20_000));
        employeeBook.createNewEmployee("Ivanov3 Ivan3 Ivanovich3", 3, BigDecimal.valueOf(30_000));
        employeeBook.createNewEmployee("Ivanov4 Ivan4 Ivanovich4", 4, BigDecimal.valueOf(40_000));
        employeeBook.createNewEmployee("Ivanov5 Ivan5 Ivanovich5", 5, BigDecimal.valueOf(50_000));
        employeeBook.createNewEmployee("Ivanov6 Ivan6 Ivanovich6", 1, BigDecimal.valueOf(60_000));
        employeeBook.createNewEmployee("Ivanov7 Ivan7 Ivanovich7", 2, BigDecimal.valueOf(70_000));
        employeeBook.createNewEmployee("Ivanov8 Ivan8 Ivanovich8", 3, BigDecimal.valueOf(80_000));
        employeeBook.createNewEmployee("Ivanov9 Ivan9 Ivanovich9", 4, BigDecimal.valueOf(90_000));
        employeeBook.createNewEmployee("Ivanov10 Ivan10 Ivanovich10", 5, BigDecimal.valueOf(100_000));

        if (!employeeBook.createNewEmployee(null, 0, BigDecimal.valueOf(0))) {
            System.out.println("хранилище заполнено");
        }

        employeeBook.removeEmployee(4);
        employeeBook.printAllEmployees();
        System.out.println(employeeBook.getEmployeeById(4));
        System.out.println(employeeBook.getTotalEmployeeSalaries());
        System.out.println(employeeBook.findEmployeeWithMinSalary());
        System.out.println(employeeBook.findEmployeeWithMaxSalary());
        System.out.println(employeeBook.calculateAverageSalaryAllEmployees());
        System.out.println(employeeBook.findEmployeeWithMinSalaryByDepartment(4));
        System.out.println(employeeBook.findEmployeeWithMaxSalaryByDepartment(3));
        System.out.println(employeeBook.getTotalEmployeeSalariesByDepartment(2));
        System.out.println(employeeBook.calculateAverageSalaryByDepartment(5));
        System.out.println(employeeBook.getTotalIndexedSalaryByDepartment(3));
        employeeBook.printEmployeesWithSalaryLessThan(BigDecimal.valueOf(35000));
        employeeBook.printEmployeesWithSalaryMoreThan(BigDecimal.valueOf(35000));
    }
}