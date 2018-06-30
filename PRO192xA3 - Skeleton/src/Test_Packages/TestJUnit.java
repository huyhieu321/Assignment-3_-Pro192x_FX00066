package Test_Packages;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import pro192xa3.business.EmployeeManagement;
import pro192xa3.entity.Employee;
import pro192xa3.entity.Staff;
import pro192xa3.entity.Teacher;

public class TestJUnit {

	@Test
	public void testTeacher() {
		Teacher emp = new Teacher();
		emp.setAllowance(500); // Master
		emp.setSalaryRatio(3);
		emp.setTeachingHours(48);
		float k = emp.getSalary();
		assertFalse( 4850 != k);
	}
	@Test
	public void testStaff() {
		Staff emp = new Staff();
		emp.setAllowance(1000); // Vice Head
		emp.setSalaryRatio(3);
		emp.setNoOfWorkingDay(2);
		float i = emp.getSalary();
		assertFalse(3250 != i);
	}
	@Test
	public void testSearchByName() {
	
		Employee sm = new Employee() {
			@Override
			public float getSalary() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		sm.setFullName("Huy");
		
		
		EmployeeManagement em = new EmployeeManagement();
		em.addEmployee(sm);
		ArrayList<Employee> f = em.searchByName("Huy");
		assertNotNull(f);
	}
	
	@Test
	public void testSearchByDept() {
		Employee sm = new Employee() {
			@Override
			public float getSalary() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		if(sm instanceof Staff) {
			((Staff) sm).setDepartment("IT");
		}
		else if(sm instanceof Teacher) {
			((Teacher) sm).setFaculty("Eng");
		}
		
		
		EmployeeManagement em = new EmployeeManagement();
		em.addEmployee(sm);
		ArrayList<Employee> f = em.searchByDept("IT");
		ArrayList<Employee> j = em.searchByDept("eng");
		assertNotNull(f);
		assertNotNull(j);
	}
}
