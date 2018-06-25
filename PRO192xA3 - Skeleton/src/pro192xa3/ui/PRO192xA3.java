/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro192xa3.ui;

import java.util.ArrayList;
import java.util.Scanner;
import jdk.nashorn.internal.parser.Lexer;
import pro192xa3.business.AllowanceCalulator;
import pro192xa3.business.EmployeeManagement;
import pro192xa3.entity.EDegree;
import pro192xa3.entity.EPosition;
import pro192xa3.entity.Employee;
import pro192xa3.entity.Staff;
import pro192xa3.entity.Teacher;

/**
 *
 * @author hp
 */
public class PRO192xA3 {

    //create an employee by inputing it's attribute values from keyboard
    static Employee createNewImployee() {
        System.out.print("Do you want to create a Staff or a Teacher (enter S for Staff, otherwise for Teacher)?");
        //accept Staff or Teacher details from keyboard        
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        if (choice.equalsIgnoreCase("s")) {
            Staff s = new Staff();
            //input staff details
            //your code
            System.out.print("Name: ");
            String name = scan.nextLine();
            s.setFullName(name);
            
            System.out.print("Salary Ratio: ");
            float salaryRatio = scan.nextFloat();
            s.setSalaryRatio(salaryRatio);
            
            scan.nextLine(); // Avoid skip to Position because nextFloat() appears before nextLine() 
            
            System.out.print("Department: ");
            String department = scan.nextLine();
            s.setDepartment(department);    
            
            System.out.print("Position (1= HEAD; 2=VICE_HEAD; 3=STAFF): ");
            int position_no = scan.nextInt();
            switch(position_no) {
            case 1: s.setPosition(EPosition.HEAD); break;
            case 2: s.setPosition(EPosition.VICE_HEAD);break;
            case 3: s.setPosition(EPosition.STAFF);break;
            }
            System.out.print("Number of working days: ");
            int noOfWorkingDay = scan.nextInt();
            s.setNoOfWorkingDay(noOfWorkingDay);          
            
            return s;

        } else {
            Teacher t = new Teacher();
            //inputs Teacher details
            //your code
            System.out.print("Name: ");
            String name = scan.nextLine();
            t.setFullName(name);
            
            System.out.print("Salary Ratio: ");
            float salaryRatio = scan.nextFloat();
            t.setSalaryRatio(salaryRatio);
            
            scan.nextLine(); // Avoid skip to Position because nextFloat() appears before nextLine() 
            
            System.out.print("Faculity: ");
            String faculty = scan.nextLine();
            t.setFaculty(faculty); 
            
            System.out.print("Position (1= BACHELOR; 2=MASTER; 3=DOCTOR): ");
            int degree = scan.nextInt();
            switch(degree) {            
            case 1: t.setDegree(EDegree.BACHELOR); break;
            case 2: t.setDegree(EDegree.MASTER);break;
            case 3: t.setDegree(EDegree.DOCTOR);break;
            }
            System.out.print("Number of teaching hours: ");
            int teachingHours = scan.nextInt();
            t.setTeachingHours(teachingHours);
            
            return t;
        }

    }

    //display a list of employee
    static void display(ArrayList<Employee> list) {
        System.out.println("Results:");
        System.out.println("Name, Fac/Dept, Deg/Pos, Sal Ratio, Allowance, T.Hours/W.Days, Salary");
        for (Employee e : list) {
            System.out.println(e.toString());
        }
    }
    
    private static int selectMenu(int choice, Scanner scan) {
        choice = -1;
        while (choice > 5 || choice < 1) {
            System.out.println("University Staff Management 1.0");
            System.out.println("\t1.Add staff");
            System.out.println("\t2.Search staff by name");
            System.out.println("\t3.Search staff by department/faculty");
            System.out.println("\t4.Display all staff");
            System.out.println("\t5.Exit");
            System.out.print("Select function (1,2,3,4 or 5): ");
            if (scan.hasNextInt()) {
            	choice = scan.nextInt();
            } else {
            	scan.next();
            }
        }
        return choice;
    }
    
    public static void main(String[] args) {
        // create employee management object
        EmployeeManagement empMan = new EmployeeManagement();
        //menu
        boolean keepRunning = true;
        Scanner scan = new Scanner(System.in);
        int choice = -1;
        while (keepRunning) {
        	choice = selectMenu(choice, scan);
            switch (choice) {
                case 1://add staff/teacher    
                    Employee emp = createNewImployee();
                    float allowance = AllowanceCalulator.calculateAllowance(emp);
                    emp.setAllowance(allowance);
                    empMan.addEmployee(emp);
                  /* Make a example Array List for more faster testing */
//                	  empMan.addEmployee(new Staff("Huy", 1, 2));
//                	  empMan.addEmployee(new Staff("Hieu", 2, 3));
//                	  empMan.addEmployee(new Teacher("Quang", 4, 5));
//                	  empMan.addEmployee(new Teacher("Hoang", 6, 7));
                	  choice = -1;
                    break;
                case 2://search by name                    
                    System.out.print("\tEnter name to search: ");
                    scan = new Scanner(System.in);
                    String name = scan.nextLine();
                    ArrayList<Employee> foundByName = empMan.searchByName(name);
                    display(foundByName);
                    choice = -1;
                    break;
                case 3://search by department
                    System.out.print("\tEnter dept/fac to search: ");
                    scan = new Scanner(System.in);
                    String dept = scan.nextLine();
                    ArrayList<Employee> foundByDept = empMan.searchByDept(dept);
                    display(foundByDept);
                    choice = -1;
                    break;
                case 4://display all
                    ArrayList<Employee> listE = empMan.listAll();
                    display(listE);
                    choice = -1;
                    break;
                case 5://exit
                    keepRunning = false;
            }
        }
    }

}
