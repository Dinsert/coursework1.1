import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.*;
import static java.util.Objects.nonNull;

public class EmployeeBook {

    private final Employee[] employees = new Employee[10];
    private final static BigDecimal PERCENT_VALUE = valueOf(1.0);
    private final static BigDecimal ONE_HUNDRED = valueOf(100);
    private final static BigDecimal PERCENT_INCREASE = ONE.add(PERCENT_VALUE.divide(ONE_HUNDRED, 0, RoundingMode.DOWN));

    private int getNumberOfEmployees() {
        int count = 0;
        for (Employee employee : employees) {
            if (nonNull(employee)) {
                count++;
            }
        }
        return count;
    }

    public boolean createNewEmployee(String fullName, int department, BigDecimal salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, department, salary);
                return true;
            }
        }
        return false;
    }

    public boolean removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (nonNull(employees[i]) && id == employees[i].getId()) {
                employees[i] = null;
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (nonNull(employee) && id == employee.getId()) {
                return employee;
            }
        }
        return null;
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (nonNull(employee)) {
                System.out.println(employee);
            }
        }
    }

    public BigDecimal getTotalEmployeeSalaries() {
        BigDecimal sum = ZERO;
        for (Employee employee : employees) {
            if (nonNull(employee)) {
                sum = sum.add(employee.getSalary());
            }
        }
        return sum;
    }

    public Employee findEmployeeWithMinSalary() {
        Employee result = null;
        for (Employee employee : employees) {
            if (nonNull(employee) && (result == null || employee.getSalary().compareTo(result.getSalary()) < 0)) {
                result = employee;
            }
        }
        return result;
    }

    public Employee findEmployeeWithMaxSalary() {
        Employee result = null;
        for (Employee employee : employees) {
            if (nonNull(employee) && (result == null || employee.getSalary().compareTo(result.getSalary()) > 0)) {
                result = employee;
            }
        }
        return result;
    }


    public BigDecimal calculateAverageSalaryAllEmployees() {
        int count = getNumberOfEmployees();
        return count != 0 ? getTotalEmployeeSalaries().divide(BigDecimal.valueOf(count), 0, RoundingMode.DOWN) : ZERO;
    }

    public String getAllFullNameEmployees() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Employee employee : employees) {
            if (nonNull(employee)) {
                stringBuilder.append(employee.getFullName()).append("\n");
            }
        }
        return stringBuilder.toString();

    }

    public BigDecimal calculateIndexedSalaryAllEmployees() {
        return getTotalEmployeeSalaries().multiply(PERCENT_INCREASE);
    }

    public Employee findEmployeeWithMinSalaryByDepartment(int department) {
        Employee result = null;
        for (Employee employee : employees) {
            if (nonNull(employee) && department == employee.getDepartment()
                    && (result == null || employee.getSalary().compareTo(result.getSalary()) < 0)) {
                result = employee;
            }
        }
        return result;
    }

    public Employee findEmployeeWithMaxSalaryByDepartment(int department) {
        Employee result = null;
        for (Employee employee : employees) {
            if (nonNull(employee) && department == employee.getDepartment()
                    && (result == null || employee.getSalary().compareTo(result.getSalary()) > 0)) {
                result = employee;
            }
        }
        return result;
    }

    public BigDecimal getTotalEmployeeSalariesByDepartment(int department) {
        BigDecimal sum = ZERO;
        for (Employee employee : employees) {
            if (nonNull(employee) && department == employee.getDepartment()) {
                sum = sum.add(employee.getSalary());
            }
        }
        return sum;
    }

    public BigDecimal calculateAverageSalaryByDepartment(int department) {
        BigDecimal all = ZERO;
        int count = 0;
        for (Employee employee : employees) {
            if (nonNull(employee) && department == employee.getDepartment()) {
                all = all.add(employee.getSalary());
                count++;
            }
        }
        return count != 0 ? all.divide(valueOf(count), 0, RoundingMode.DOWN) : ZERO;
    }

    public BigDecimal getTotalIndexedSalaryByDepartment(int department) {
        return getTotalEmployeeSalariesByDepartment(department).multiply(PERCENT_INCREASE);
    }

    public void printAllEmployeesByDepartment(int department) {
        for (Employee employee : employees) {
            if (nonNull(employee) && department == employee.getDepartment()) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    public void printEmployeesWithSalaryLessThan(BigDecimal value) {
        for (Employee employee : employees) {
            if (nonNull(employee) && employee.getSalary().compareTo(value) < 0) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    public void printEmployeesWithSalaryMoreThan(BigDecimal value) {
        for (Employee employee : employees) {
            if (nonNull(employee) && employee.getSalary().compareTo(value) > 0) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }
}
