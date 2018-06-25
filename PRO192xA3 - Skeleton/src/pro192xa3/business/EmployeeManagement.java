/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro192xa3.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import pro192xa3.entity.Employee;
import pro192xa3.entity.Staff;
import pro192xa3.entity.Teacher;

/**
 *
 * @author hp
 */
public class EmployeeManagement {

    //store all staff/teacher
    ArrayList<Employee> listE;

    public EmployeeManagement() {        
        listE = new ArrayList<>();
        
    }

    public void addEmployee(Employee emp) {
        //add emp to listE
        //your code
    	listE.add(emp);
    	
    }
    //search by staff/teacher's name
    public ArrayList<Employee> searchByName(String name) {
        //store all matching staff or teacher
        ArrayList<Employee> empFound = new ArrayList<>();
        //your code
        for( Employee emp : listE) {
        	 // Using equals() to compare values of object instead of using "==" just compare reference of this object
        	// equalsIgnoreCase() 
        	if(emp.getFullName().equalsIgnoreCase(name)) {
        		empFound.add(emp);
        	}
        }
        return empFound;
    }
    //search by staff/teacher's department/faculty
    public ArrayList<Employee> searchByDept(String dept) {
        
    	ArrayList<Employee> empFound = new ArrayList<>();

        //your code
    	for (Employee emp : listE) {
    		   if(emp instanceof Staff){
    	        	if(((Staff) emp).getDepartment().equalsIgnoreCase(dept)) {
    	        		empFound.add(emp);
    	        	}
    	        }
    		   if (emp instanceof Teacher) {
    				if(((Teacher) emp).getFaculty().equalsIgnoreCase(dept)) {
    	        		empFound.add(emp);
    	        	}
    		   }
    	}     
        return empFound;
    }

    public ArrayList<Employee> listAll() {
        //sort the list of staff/teacher before return
        //your code
    	 Collections.sort(listE);

        return listE;
    }

}
