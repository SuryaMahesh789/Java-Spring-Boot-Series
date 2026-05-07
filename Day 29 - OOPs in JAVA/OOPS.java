import java.util.*;

class Pen
{
    String color;
    String type;

    Pen(String color,String type)
    {
        this.color = color;
        this.type = type;
    }

    public void write()
    {
        System.out.println("Writing something...");
    }
    public void printColor()
    {
        System.out.println(this.color);
    }

    public void printType()
    {
        System.out.println(this.type);
    }

}

class Student
{

    String name;
    int age;

    Student()
    {
    this.name = "Mahesh";
    this.age = 23;
    }

    Student(String name,int age)
    {
        this.name = name;
        this.age = age;
    }

    Student(Student ss)
    {
        this.name = ss.name;
        this.age = ss.age;
    }

    public void printInfo()
    {
        System.out.println(this.name);
        System.out.println(this.age);
    }

    public void message()
    {
        System.out.println("Hiii Message");
    }

    public void message(String message)
    {
        System.out.println("Hiii "+message);
    }

    public void message(String message,String wish)
    {
        System.out.println(wish+message);
    }

}


class Shape
{
    String color;

    Shape()
    {
        this.color = "Black";
    }

    public void printInfo()
    {
        System.out.println("Color is : "+this.color);
    }

    public void area()
    {
        System.out.println("Shape Area...");
        System.out.println("Displays Area....");
    }
}

class Triangle extends Shape
{

    public void area(int l,int h)
    {
        System.out.println("Triangle Area...");
        System.out.println(0.5*l*h);
    }

}

class EquilateralTriangle extends Triangle{
    public void area(int l,int h)
    {
        System.out.println("Equilateral Triangle Area....");
        System.out.println(0.5*l*h);
    }
}

public class OOPS
{
    public static void main(String[] args) {



        Pen p = new Pen("Blue","Gel");
        p.printColor();
        p.printType();
        p.write();

        Student s = new Student("Surya",22);
        s.printInfo();

        Student s2 = new Student();
        s2.printInfo();

        Student s3 = new Student(s);
        s3.printInfo();

        s.message();
        s.message("Wakeuppp");
        s.message("Good bye","Have a nice day");

        Triangle t = new Triangle();
        System.out.println(t.color);
        t.printInfo();

        t.area();
        t.area(10,5);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your age: ");
//        int num = sc.nextInt();
//        System.out.println(num);



    }
}
