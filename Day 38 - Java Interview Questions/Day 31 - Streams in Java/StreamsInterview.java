import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

class Employeee
{
    private int id;
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employeee(int id,String name,int age,String department,double salary)
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


public class StreamsInterview
{
    public static void main(String[] args) {


//        Examples
        List<Integer>nums = Arrays.asList(10,3,2,1,4,5,6,7,8,9);
        System.out.println("Array - For Loop");
        nums.forEach(n -> System.out.println(n));

        Stream<Integer>data = nums.stream();
        System.out.println("Count Stream");
        System.out.println(data.count());

        data = nums.stream();
        System.out.println("Stream - ForEach Loop");
        data.forEach(n -> System.out.println(n));


        System.out.println("Sorted Stream");
        data = nums.stream();
        data = data.sorted();
        data.forEach(n -> System.out.println(n));

        data = nums.stream();
        System.out.println("Sorted Stream");
        data = data.sorted(Comparator.reverseOrder());
        data.forEach(n -> System.out.println(n));

        System.out.println("Stream MAP");
        data = nums.stream().map(n -> n*2);
        data.forEach(n -> System.out.println(n));

        System.out.println("Stream map shorthand");
        nums.stream().sorted().map(n ->n*2).forEach(n -> System.out.println(n));

        System.out.println("Odd sorted, double it and print");
        nums.stream().filter(n -> n%2==1).sorted().map(n -> n*2).forEach(n -> System.out.println(n));

        System.out.println("Odd sorted, double it and Sum");
        System.out.println(nums.stream().filter(n -> n%2==1).sorted().map(n -> n*2).reduce(0,Integer::sum));;

        System.out.println("Odd sorted, double it and Sum");
        System.out.println(nums.stream().filter(n -> n%2==1).sorted().map(n -> n*2).reduce(0,(a,b)->a+b));;



        List<String>names = Arrays.asList("alice","bob");

//        What are streams
//        Java streams basically represents Pipeline, Through which data will flow
//         Streams will transform the data into some other form


//        How to Create a Stream
//        1. List to Stream
        Stream<String> stream = names.stream();
        System.out.println(stream);

//        2. Arrays to Stream()
        String[]arr = {"Java","Python","C++"};
        stream = Arrays.stream(arr);
        System.out.println(stream);

//        3. Using Stream.of()
        Stream<Integer>int_stream = Stream.of(1,2,3,4,5);

        Stream<String>string_stream = Stream.of("Surya","Mahesh","Teja","Gaja");

//        4. Using generate()
        Stream<Double>double_stream = Stream.generate(Math::random).limit(5);

//        Filter Even Numbers

        List<Integer>array =  Arrays.asList(1,1,1,2,3,4,5,6,7,8,9,10,100,1000);
        System.out.println("Filter Even Numbers");
        array.stream().filter(n -> n%2==0).forEach(n -> System.out.println(n));

//        Convert Numbers into List of Their Squares

        System.out.println("List of Squares");
        array.stream().map(n -> n*n).forEach(n -> System.out.println(n));

//        squares even numbers in a list

        System.out.println("Square even numbers in a list");
        array.stream().filter(n -> n%2==0).map(n -> n*n).forEach(n -> System.out.println(n));

        System.out.println("printing array");
        array.forEach(n -> System.out.println(n));
//Find First number greater than 10 in List
        System.out.println("Find First Number greater than 10 in List");
        System.out.println(array.stream().filter(n -> n>10).findFirst());;

        System.out.println(array.stream().filter(n -> n>10).sorted().findFirst());

//        Count how many numbers are greater than 5
        System.out.println("Count how many numbers are greater than 5");
        System.out.println(array.stream().filter(n -> n>5).count());

//        Find the sum/product of all numbers in list
        System.out.println("Find the sum of all numbers in list");
        System.out.println(array.stream().reduce(Integer::sum));
        System.out.println(array.stream().reduce(0,Integer::sum));
        System.out.println(array.stream().reduce(0,(a,b)->a+b));

        System.out.println("Find the product of all numbers in list");
        System.out.println(array.stream().reduce(1,(a,b)->a*b));

//        find sum of Even numbers only
        System.out.println("find sum of Even numbers only");
        System.out.println(array.stream().filter(n -> n%2==0).reduce(0,(a,b)->a+b));

        System.out.println(array.stream().filter(n -> n%2==0).reduce(Integer::sum));

//        find maximum number in the list
        System.out.println("Find maximum number in the list");
        System.out.println(array.stream().reduce(Integer::max));
        System.out.println(array.stream().reduce(0,(a,b)->Integer.max(a,b)));

//        sum squares even numbers in a list

        System.out.println("Sum of Square even numbers in a list");
        System.out.println(array.stream().filter(n -> n%2==0).map(n -> n*n).reduce(Integer::sum));


        System.out.println("Remove Duplicates / Only Distinct");
        array.stream().collect(Collectors.toSet()).forEach(n -> System.out.println(n));
        System.out.println("Remove Duplicates / Only Distinct");
        array.stream().distinct().forEach(n -> System.out.println(n));
        System.out.println("Remove Duplicates / Only Distinct");
        array.stream().distinct().toList().forEach(n -> System.out.println(n));

        System.out.println("Find the Average Of All Numbers in a list");
        System.out.println(array.stream().mapToInt(Integer::intValue).average());
        System.out.println(array.stream().mapToInt(n -> n).average());
        System.out.println(array.stream().mapToInt(n -> n).average().orElse(-1));

        System.out.println("Sort a list of integers in Asc  order");
        array.stream().sorted().forEach(n -> System.out.println(n));
        System.out.println("Sort a list of integers in  Desc order");
        array.stream().sorted(Comparator.reverseOrder()).forEach(n -> System.out.println(n));
        System.out.println("Sort a list of integers in  Desc order");
        array.stream().distinct().sorted(Comparator.reverseOrder()).forEach(n -> System.out.println(n));

        System.out.println("Remove Duplicates -- Sort a list of integers in  Desc order");
        array.stream().sorted(Comparator.reverseOrder()).forEach(n -> System.out.println(n));


        List<String> sarr = Arrays.asList("Mahesh","Arush","Arya");
        System.out.println("String List");
        sarr.forEach(s -> System.out.println(s));
        System.out.println("Count Number of Strings Starts with a specific letter like 'A'");
        sarr.stream().filter(s -> s.startsWith("A")).count();
        System.out.println("Print Strings Starts with a specific letter like 'A'");
        sarr.stream().filter(s -> s.startsWith("A")).forEach(s -> System.out.println(s));

        System.out.println("Join all strings in a list into a single comma seperated string");
        System.out.println(sarr.stream().collect(Collectors.joining(",")));;

        System.out.println("Join all strings in a list into a single comma seperated string,with prefix and suffix");
        System.out.println(sarr.stream().collect(Collectors.joining(",","[","]")));

        System.out.println("Check if all the elements are positive numbers");
        System.out.println(array.stream().allMatch(n -> n>0));

        System.out.println("Check if Any number is Divisible by 3");
        System.out.println(array.stream().anyMatch(n -> n%3==0));

        System.out.println("Flatten the list of List");

        List<List<Integer>>listofLists = Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(4,5),Arrays.asList(6,7,8));
        System.out.println(listofLists);

        List<Integer>list = listofLists.stream().flatMap(List::stream).toList();
        System.out.println(list);

        System.out.println("Printing String List");
        System.out.println(sarr);
        System.out.println("Find FIrst Non Empty String in a list");
        System.out.println(sarr.stream().filter(s -> s.length()!=0).findFirst().orElse(null));;
        System.out.println(sarr.stream().filter(s -> !s.isEmpty()).findFirst().orElse(null));

        System.out.println("Second Highest Number in a List");
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst());
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());


        List<Employeee> employees = Arrays.asList(
                new Employeee(1,"Surya",25,"IT",60000),
                new Employeee(2,"Mahesh",30,"HR",50000),
                new Employeee(3,"Kiran",28,"IT",75000),
                new Employeee(4,"Anil",35,"Finance",90000),
                new Employeee(5,"Suresh",40,"IT",120000),
                new Employeee(6,"Ravi",22,"HR",40000),
                new Employeee(7,"John",29,"Finance",85000),
                new Employeee(8,"Sam",31,"IT",95000)
        );

        System.out.println("Employeees List");
        employees.forEach(n -> System.out.println(n));
        System.out.println("Sort List Of Employees By Salary");
        employees.stream().sorted(Comparator.comparing(Employeee :: getSalary)).toList().forEach(n-> System.out.println(n));
        System.out.println("Sort List Of Employees By Salary Desc Order");
        employees.stream().sorted(Comparator.comparing(Employeee :: getSalary).reversed()).toList().forEach(n-> System.out.println(n));
        System.out.println("Employee with Highest Salary");
        System.out.println(employees.stream().sorted(Comparator.comparing(Employeee::getSalary).reversed()).findFirst().get());
        System.out.println(employees.stream().sorted(Comparator.comparing(Employeee::getSalary).reversed()).findFirst().orElse(null));
        System.out.println(employees.stream().sorted(Comparator.comparing(Employeee::getSalary).reversed()).findFirst());

        System.out.println("Employee with Second Highest Salary");
        System.out.println(employees.stream().sorted(Comparator.comparing(Employeee::getSalary).reversed()).skip(1).findFirst().get());

        System.out.println("List of all employee Ages");
        employees.stream().mapToInt(Employeee::getAge).asLongStream().forEach(n -> System.out.println(n));
        System.out.println("Average Age of Employees");
        System.out.println(employees.stream().mapToInt(Employeee::getAge).average());
        System.out.println(employees.stream().mapToInt(Employeee::getAge).average().getAsDouble());

//        Partition numbers into Even and Odd
        System.out.println("Numbers list");
        nums.forEach(n -> System.out.println(n));
        System.out.println("Partition numbers into Even and Odd");
        Map<Boolean,List<Integer>>result = nums.stream().collect(Collectors.partitioningBy(n -> n%2==0));
        System.out.println(result);
        System.out.println("Even Numbers: "+result.get(true));
        System.out.println("Odd Numbers:  "+result.get(false));

//        group a list of words by their length using streams
        List<String>words = Arrays.asList("apple","bat","ball","cat","banana","dog","bat","banana","apple");
        Map<Integer,List<String>>wordMap = words.stream().collect(Collectors.groupingBy( s->s.length()));
        System.out.println(wordMap);
        wordMap = words.stream().collect(Collectors.groupingBy( String:: length));
        System.out.println(wordMap);

//        count Occurence of Each Element in a list
       Map<String,Long> wordsOccurenceMap=  words.stream().collect(Collectors.groupingBy(s->s,Collectors.counting()));
        System.out.println(wordsOccurenceMap);

        wordsOccurenceMap=  words.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(wordsOccurenceMap);

//        group Employees by Department

        System.out.println("Group Employees By Department");
       Map<String,List<Employeee>> deptMap =  employees.stream().collect(Collectors.groupingBy(Employeee::getDepartment));
       System.out.println(deptMap);

        deptMap =  employees.stream().collect(Collectors.groupingBy(Employeee::getDepartment,Collectors.toList()));
        System.out.println(deptMap);

//        group employees by department and calculate average salary
        System.out.println("Departwise Employees Average Salary");
        Map<String,Double> deptWiseAvgSalary = employees.stream().collect(Collectors.groupingBy(Employeee::getDepartment,Collectors.averagingDouble(Employeee::getSalary)));
        System.out.println(deptWiseAvgSalary);

        System.out.println("Department Wise Highest Salaried Employee");
        Map<String,Optional<Employeee>>deptWiseMaxSalary =  employees.stream().collect(Collectors.groupingBy(Employeee::getDepartment,Collectors.maxBy(Comparator.comparing(Employeee::getSalary))));
        System.out.println(deptWiseMaxSalary);


        System.out.println("Find department wise employee count");

       Map<String,Long> deptWiseEmployeeCount =  employees.stream()
                                                          .collect(Collectors.groupingBy(Employeee::getDepartment,Collectors.counting()));
       System.out.println(deptWiseEmployeeCount);

        System.out.println("Find all departments with more than 2 Employees");
        System.out.println(deptWiseEmployeeCount.entrySet().stream().filter(e -> e.getValue()>2).toList());
        System.out.println(deptWiseEmployeeCount.entrySet().stream().filter(e -> e.getValue()>2).map(e -> e.getKey()).toList());
        System.out.println(deptWiseEmployeeCount.entrySet().stream().filter(e -> e.getValue()>2).map(Map.Entry::getKey).toList());

        System.out.println("Find all departments with more than 2 Employees into Single Stream");
        employees.stream()
                .collect(Collectors.groupingBy(Employeee::getDepartment,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue()>2)
                .map(e -> e.getKey())
                .toList()
                .forEach(d -> System.out.println(d));


        System.out.println("Department wise Average Salary");
        System.out.println
                (
                employees.stream()
                         .collect(Collectors.groupingBy(Employeee::getDepartment,Collectors.averagingDouble(Employeee::getSalary)))
        );

        System.out.println("Find Department with Highest Average Salary");
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employeee::getDepartment,Collectors.averagingDouble(Employeee::getSalary))).entrySet().stream().sorted(Comparator.comparing(e -> e.getValue(),Comparator.reverseOrder())).findFirst().get().getKey());

        System.out.println("Find Department with Second Highest Average Salary");
        System.out.println(
                employees.stream()
                        .collect(Collectors.groupingBy(Employeee::getDepartment,Collectors.averagingDouble(Employeee::getSalary)))
                        .entrySet()
                        .stream()
                        .sorted(Comparator.comparing(e -> e.getValue(),Comparator.reverseOrder()))
                        .skip(1).findFirst()
                        .get().getKey());

        System.out.println("Find Employee with Second Highest Salary");
        System.out.println(employees.stream().sorted(Comparator.comparing(Employeee::getSalary)).skip(1).findFirst().get());

        String word = "My Name is Apple, and Fav Fruit is Apppppppppppppple";
        System.out.println(word);

        System.out.println("Find Frequency of each character in String");

        System.out.println(word.chars().mapToObj(c -> c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
        System.out.println(word.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

        System.out.println("Find Most Frequent character in String");
        System.out.println(
                word.chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet()
                        .stream()
                        .collect(Collectors.maxBy(Comparator.comparing(e -> e.getValue())))
                        .get()
                        .getKey()
        );

        String str = "swiss";
        System.out.println("String is : "+str);
        System.out.println("Find First Non Repeating Character");
        System.out.println(
                str.chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(e -> e.getValue()==1)
                        .findFirst()
                        .get()
                        .getKey()
        );

        System.out.println("Frequency of Employee Names with First Letter");
        System.out.println(
                employees.stream()
                        .map(e -> e.getName())
                        .collect(Collectors.groupingBy(e -> e.charAt(0),Collectors.counting())));

        System.out.println("Find the most common first letter among all employee names");
        System.out.println(employees.stream().map(e -> e.getName()).collect(Collectors.groupingBy(e -> e.charAt(0),Collectors.counting())).entrySet().stream().sorted(Comparator.comparing(e -> e.getValue(),Comparator.reverseOrder())).findFirst().get().getKey());

        System.out.println(sarr);

        sarr = Arrays.asList("","Mahesh","Arush","Arya");
        System.out.println(sarr.stream().filter(s -> !s.isEmpty()).findFirst());
        System.out.println(sarr.stream().filter(s -> !s.isEmpty()).findFirst().get());

    }
}
