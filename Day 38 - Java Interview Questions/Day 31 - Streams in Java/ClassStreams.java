import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

class Employee
{
    private int id;
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee(int id,String name,int age,String department,double salary)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public  int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public String getDepartment()
    {
        return department;
    }
    public double getSalary()
    {
        return salary;
    }

    @Override
    public String toString()
    {
        return id+" - "+name+" - "+age+" - "+department+" - "+salary;
    }

}


public class ClassStreams
{
    public static void main(String[] args)
    {
//        List<Employee>employees = Arrays.asList(
//                new Employee(1,"Suryai",25,"IT",60000),
//                new Employee(2,"Mahesh",30,"HR",50000),
//                new Employee(3,"Kiran",28,"IT",75000),
//                new Employee(4,"Sanil",35,"Finance",50000),
//                new Employee(6,"Ravi",22,"HR",40000)
//        );

        List<Employee> employees = Arrays.asList(
                new Employee(1,"Surya",25,"IT",60000),
                new Employee(2,"Mahesh",30,"HR",50000),
                new Employee(3,"Kiran",28,"IT",75000),
                new Employee(4,"Anil",35,"Finance",90000),
                new Employee(5,"Suresh",40,"IT",120000),
                new Employee(6,"Ravi",22,"HR",40000),
                new Employee(7,"John",29,"Finance",85000),
                new Employee(8,"Sam",31,"IT",95000)
        );

        System.out.println("All Employees");
        System.out.println(employees);

        System.out.println("FILTER - Streams");
//        Employees with Salary > 7000
        System.out.println("Employees with Salary > 7000");
        List<Employee>res= employees.stream().filter(e -> e.getSalary()>7000).toList();
        System.out.println(res);

//        Employees age greater than 25
        System.out.println("Employees age greater than 25");
        res =  employees.stream().filter(e -> e.getAge() > 25).toList();
        System.out.println(res);

//        Employees from IT department
        System.out.println("Employees from IT department");
        res = employees.stream().filter(e -> e.getDepartment() == "IT").toList();
        System.out.println(res);

        System.out.println("Employees from HR department");
        res = employees.stream().filter(e -> e.getDepartment().equals("HR")).toList();
        System.out.println(res);

        System.out.println("REDUCE - Streams");

        System.out.println("Get all Employee Names");
        List<String>emp_names = employees.stream().map(e -> e.getName()).toList();
        System.out.println(emp_names);

        System.out.println("Get all Employee Ages");
        List<Integer>emp_ages = employees.stream().map(e -> e.getAge()).toList();
        System.out.println(emp_ages);

        System.out.println("Get Salary List...");
        List<Double>emp_salaries = employees.stream().map(e -> e.getSalary()).toList();
        System.out.println(emp_salaries);

        System.out.println("Sum of Salaries");
        double sum_salary = employees.stream().map(e -> e.getSalary()).reduce(0.0,Double::sum);
        System.out.println(sum_salary);

        System.out.println("Sum of Ages");
        int sum_age = employees.stream().map( e -> e.getAge()).reduce(0,Integer::sum);
        System.out.println(sum_age);

        System.out.println("Filter + Map + Reduce");
        System.out.println("Sum of IT Employees Salaries");
        double sum_it_salaries = employees.stream().filter(e -> e.getDepartment().equals("IT")).map(e -> e.getSalary()).reduce(0.0,Double::sum);
        System.out.println(sum_it_salaries);


//        MAX / MIN
        System.out.println("Highest Salary Employees");
        Employee highest_emp = employees.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
        System.out.println(highest_emp);

        System.out.println("Youngest Employee");
        Employee youngest_emp = employees.stream().min(Comparator.comparing(Employee::getAge)).orElse(null);
        System.out.println(youngest_emp);

        System.out.println("Youngest Employee Age");
        int yooungestEmpAge = employees.stream().map(e -> e.getAge()).reduce(Integer.MAX_VALUE,Integer::min);
        System.out.println(yooungestEmpAge);

        System.out.println("Highest Salaried Employees Salary");
        double highest_salary = employees.stream().map( e -> e.getSalary()).reduce(Double.MIN_VALUE,Double::max);
        System.out.println(highest_salary);

        System.out.println("Count Employees in HR");
        long hrcount = employees.stream().filter(e -> e.getDepartment()=="HR").count();
        System.out.println(hrcount);

        System.out.println("Distinct Departments...");
        List<String>distinctDept = employees.stream().map(e -> e.getDepartment()).distinct().toList();
        System.out.println(distinctDept);

        System.out.println("Sort Employees - Ascending");
        List<Employee>sortedSalaries = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).toList();
        System.out.println(sortedSalaries);

        System.out.println("Sort Employees - Descending");
        List<Employee>sortedDescSalaries = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();
        System.out.println(sortedDescSalaries);

        System.out.println("Sort By Department, then by Salary");
        List<Employee>emp_dept_salary = employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary)).toList();
        System.out.println(emp_dept_salary);

        System.out.println("Sort by Department, then Salary Descending");
        List<Employee>emp_dept_salary_desc = employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Comparator.comparing(Employee::getSalary).reversed())).toList();
        System.out.println(emp_dept_salary_desc);

        System.out.println("Sort by Salary Descending, then Dept Ascending");
        List<Employee>emp_salary_desc_dept = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getDepartment)).toList();
        System.out.println(emp_salary_desc_dept);

        System.out.println("Find FIrst");
        System.out.println("Find First Employee With Salary > 80000");
        Employee first_emp_gt80k = employees.stream().filter(e -> e.getSalary()>80000).findFirst().orElse(null);
        System.out.println(first_emp_gt80k);

        System.out.println("Find First IT Employee with Salary >50000 and Department IT");
        Employee first_it_emp_gt50k = employees.stream().filter(e -> ((e.getDepartment()=="IT") && (e.getSalary()>50000))).findFirst().orElse(null);
        System.out.println(first_it_emp_gt50k);

        System.out.println("Find Second IT Employee with Salary >50000 and Department IT");
        Employee second_it_emp_get50k = employees.stream().filter(e -> ((e.getSalary()>50000) && (e.getDepartment()=="IT"))).skip(1).findFirst().orElse(null);
        System.out.println(second_it_emp_get50k);

        System.out.println("Find Any IT Employee");
        Employee anyItEmp = employees.stream().filter(e -> e.getDepartment()=="IT").findAny().orElse(null);
        System.out.println(anyItEmp);

        System.out.println("Starts with / Ends with");
        System.out.println("Employees names starts with S");
        List<Employee>emp_starts_with_S = employees.stream().filter(e -> e.getName().startsWith("S")).toList();
        System.out.println(emp_starts_with_S);

        System.out.println("Employees names ends with i");
        List<Employee>emp_ends_with_i = employees.stream().filter(e -> e.getName().endsWith("i")).collect(Collectors.toUnmodifiableList());
        System.out.println(emp_ends_with_i);

        System.out.println("ANYMATCH / ALLMATCH / NONEMATCH");
        System.out.println("ANY High Salary Employees >70000");
        boolean anyHighSalary = employees.stream().anyMatch(e -> e.getSalary()>70000);
        System.out.println(anyHighSalary);

        System.out.println("All Employees Age 20 ?");
        boolean all_emp_age_gt20 = employees.stream().allMatch(e -> e.getAge()>20);
        System.out.println(all_emp_age_gt20);

        System.out.println("None of the Employees are Sales dept?");
        boolean none_sales_emp = employees.stream().noneMatch(e -> e.getDepartment()=="Sales");
        System.out.println(none_sales_emp);

        System.out.println("Average");
        System.out.println("Average Salary");
        double avgSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        System.out.println(avgSalary);

        System.out.println("First Highest Salary Employee");
        Employee firstHighestSalaryEmp = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).findFirst().orElse(null);
        System.out.println(firstHighestSalaryEmp);

        System.out.println("Second highest Salary Employee");
        Employee secondHighestSalaryEmp = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().orElse(null);
        System.out.println(secondHighestSalaryEmp);

        System.out.println("Grouping");
        System.out.println("Group By Department");
        Map<String,List<Employee>>groupByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println(groupByDept);

        System.out.println("Count Employees per dept");
        Map<String,Long>deptCount = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
        System.out.println(deptCount);

        System.out.println("Count Employees by ");

        System.out.println("Average Salary");
        double avgSalaryy = employees.stream().mapToDouble(e -> e.getSalary()).average().orElse(0);
        System.out.println(avgSalaryy);


//        Interview Questions SET
        System.out.println("-------------Interview Questions---------------");
        for(Employee i:employees)
        {
            System.out.println(i);
        }


        System.out.println("\n Highest Salary\n");

        Employee Highest = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .findFirst()
                .orElse(null);

        System.out.println(Highest);

        System.out.println("\nSecond Highest Salary\n");

        Employee secondHighest = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println(secondHighest);


    }
}
