/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro192xa3.entity;

/**
 *
 * @author hp
 */
public abstract class Employee implements Comparable<Employee> {
    private String fullName;
    private float salaryRatio;
    private float allowance;
    
    public Employee() {
	}

    public Employee(String fullName, float salaryRatio, float allowance) {
    	this.fullName = fullName;
    	this.salaryRatio = salaryRatio;
    	this.allowance = allowance;
    }


	public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getSalaryRatio() {
        return salaryRatio;
    }

    public void setSalaryRatio(float salaryRatio) {
        this.salaryRatio = salaryRatio;
    }

    public float getAllowance() {        
        return allowance;
    }

    public void setAllowance(float allowance) {
        this.allowance = allowance;
    } 
  
    public abstract float getSalary();
    
    /*Declaration compareTo()*/
    @Override
    public int compareTo(Employee emp){
		if (this instanceof Staff && emp instanceof Teacher) {
			return -1;
		} else if (this instanceof Teacher && emp instanceof Staff	 ) {
			return 1;
		} else {
			return (this.getFullName().compareTo(emp.getFullName()));
		}
		
    }
   
}
