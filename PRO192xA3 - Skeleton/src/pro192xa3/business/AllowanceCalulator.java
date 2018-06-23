/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro192xa3.business;

import pro192xa3.entity.EDegree;
import pro192xa3.entity.EPosition;
import pro192xa3.entity.Employee;
import pro192xa3.entity.Staff;
import pro192xa3.entity.Teacher;

/**
 *
 * @author hp
 */
public class AllowanceCalulator {
     /*
    for teacher:
    bachelor / 300
    master  / 500
    doctor / 1000
    
    for staff:
    head       / 2000
    vice-head / 1000
    staff    / 500
    */
    public static float calculateAllowance(Employee emp){        
        float allowance=0;
        if(emp instanceof Staff){
            Staff s = (Staff) emp;
            //head/
            if(s.getPosition()==EPosition.HEAD) allowance = 2000;
            
            //vice-head/
            //your code
            if(s.getPosition()==EPosition.VICE_HEAD) allowance = 1000;
            //staff/
            //your code
            if(s.getPosition()==EPosition.STAFF) allowance = 500;
            
        }
        if(emp instanceof Teacher){
            Teacher t = (Teacher) emp;
           //your code          
            if(t.getDegree()==EDegree.BACHELOR) allowance = 300;
            if(t.getDegree()==EDegree.MASTER) allowance = 500;
            if(t.getDegree()==EDegree.DOCTOR) allowance = 1000;

        }
        return allowance;
    }
}
