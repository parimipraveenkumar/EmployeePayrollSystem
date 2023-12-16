
import java.lang.*;
import java.util.*;


abstract class Employee
{
    private String name;
    private int id;
    
    public Employee(String name,int id)
    {
        this.name=name;
        this.id=id;
    }
    
    public String getname()
    {
        return name;
    }
    
    public int getid()
    {
        return id;
    }
    
    public abstract double calculateSalary();
    
    @Override
    public String toString()
    {
        return " Employee [ name: " + name + ", Id: " + id + ", Salary: " + calculateSalary() +  "]";
    }
     
}

class fullTimeEmployee extends Employee
{
    private double employeesalary;
    
    public fullTimeEmployee(String name,int id,double employeesalary)
    {
        super(name,id);
        this.employeesalary=employeesalary;
    }
    
    @Override
    public double calculateSalary()
    {
        return employeesalary;
    }
}

class partTimeEmployee extends Employee
{
    private int hours;
    private double hourly_rate;
    
    public partTimeEmployee(String name,int id,double rate,int hours)
    {
        super(name,id);
        this.hourly_rate=rate;
        this.hours=hours;
    }
    
    @Override
    public double calculateSalary()
    {
        return hours*hourly_rate;
    }
}

class payrolesystem
{
    private ArrayList<Employee> employee_list;
    
    public payrolesystem()
    {
        employee_list=new ArrayList<>();
    }
    
    public void addEmployee(Employee employee)
    {
        employee_list.add(employee);
    }
    
    public void removeEmployee(int id)
    {
        Employee Emp1=null;
        for(Employee employee:employee_list)
        {
            if(employee.getid()==id)
            {
                Emp1=employee;
                break;
            }
        }
        
        if(Emp1!=null)
        {
            employee_list.remove(Emp1);
        }
    }
    
    public void display()
    {
        for(Employee emp:employee_list)
        {
            System.out.println(emp);
        }
    }
    
}


public class EmployeePayroleSystem
{
    public static void main(String[] args)
    {
        payrolesystem payroll=new payrolesystem();
        int n;
        Scanner sc=new Scanner(System.in);
//        fullTimeEmployee emp1=new fullTimeEmployee("williams",101,70000);
//        partTimeEmployee emp2=new partTimeEmployee("Henricks",102,1000,45);
//        
//        payroll.addEmployee(emp1);
//        payroll.addEmployee(emp2);
//        System.out.println("Intial Employee details: ");
//        payroll.display();
//        System.out.println("Removing Employees");
//        payroll.removeEmployee(102);
//        payroll.display();
        boolean t=true;
        do
        {
            
            System.out.println("""
                               Enter the type of operation you want to perform
                                1.Add Employee
                                2.Remove Employee
                                3.Display Employee Details
                                4.To exit""");
            n=sc.nextInt();
            
            switch(n)
            {
                case 1:
                    System.out.println("If a Parttime Employee enter 3 or Enter 4");
                   // int z=sc.nextInt();
                    if(sc.nextInt()==3)
                    {
                        System.out.println("Enter the Employee Details");
                        partTimeEmployee emp1=new partTimeEmployee(sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextInt());

                        payroll.addEmployee(emp1);
                        System.out.println("Employee details added");
                        emp1=null;
                    }
                    else
                    {
                        System.out.println("Enter the Employee Details");
                        fullTimeEmployee emp2=new fullTimeEmployee(sc.next(),sc.nextInt(),sc.nextDouble());
                        payroll.addEmployee(emp2);
                        emp2=null;
                    }
                    break;

                case 2:
                    System.out.println("Enter the Id of the Employee");
                    payroll.removeEmployee(sc.nextInt());
                    System.out.println("The employee details has been Removed");
                    break;

                case 3:
                    System.out.println("The Details of the Employee's is ");
                    payroll.display();
                    break;

                case 4:
                    System.out.println("The payroll system is being closed\n");
                    t=false;
                    break;
            }
            
         }while(t==true);
         
         
         
        
        
        
    }  
}