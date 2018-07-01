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
import java.io.*;

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
    String linkFile = "PRO192xA3 - Skeleton/data.txt";
    
    public EmployeeManagement() {        
        listE = new ArrayList<>();
        /*Loading file data.txt*/
       	try {
    		File file = new File(linkFile);
    		if(!file.exists()) {
    			System.out.println("*****Load data: data.txt file not found.");
   				file.createNewFile();
   			}
    		else {
    			load(linkFile);
    		}
    	}
    	catch (IOException e) {
    		e.printStackTrace();
		}
    }
    // LoadData from file
    public void load(String fileName) throws IOException,FileNotFoundException {
    		BufferedReader br = null;
    		try {
    			br = new BufferedReader(new FileReader(fileName));
    			String line;
    			while ((line = br.readLine()) != null){
    				System.out.println(line);
    			}
    			
    		}
    		catch (IOException e) {
    			e.printStackTrace();
    		}
    		finally {
    			try {
    				br.close();
    			}
    			catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    }
    
    public void save(String fileName,String inputString) throws IOException, FileNotFoundException {
    	BufferedWriter br= null;
    	try {
    		 br = new BufferedWriter(new FileWriter(fileName,true));
    		 br.newLine();
    		 br.write(inputString);
    		 br.close();
    		}
    	catch (IOException e){
    		e.printStackTrace();
    	}
    }
    
    public void addEmployee(Employee emp) {
        //add emp to listE
        //your code
    	listE.add(emp);
        try {
        	if (emp instanceof Staff) {
			save(linkFile,"Staff, "+emp.toString());
        	}
        	else if(emp instanceof Teacher) {
    		save(linkFile,"Teacher, "+emp.toString());
        	}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	
    }
    //search by staff/teacher's name
    public ArrayList<Employee> searchByName(String name) {
    	if (listE.isEmpty()) {
    		return null;
    	}
    	
        //store all matching staff or teacher
        ArrayList<Employee> empFound = new ArrayList<>();
        //your code
        for( Employee emp : listE) {
        	 // Using equals() to compare values of object instead of using "==" just compare reference of this object
        	// equalsIgnoreCase()         	
        	if(emp.getFullName().equalsIgnoreCase(name)) {
        		empFound.add(emp);
        	}
        	else System.out.println("This name is not exist in list! ");
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
    	        	else System.out.println("This department is not exist in list! ");
    	        }
    		   else if (emp instanceof Teacher) {
    				if(((Teacher) emp).getFaculty().equalsIgnoreCase(dept)) {
    	        		empFound.add(emp);
    	        	}
    				else System.out.println("This faculty is not exist in list! ");
    		   }
    		   
    	}     
        return empFound;
    }
    
    public ArrayList<Employee> listAll() {
        //sort the list of staff/teacher before return
        //your code
  	   	
    	// sort data
    	 Collections.sort(listE);

        return listE;
    }
    

}
    


