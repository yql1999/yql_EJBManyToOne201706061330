package cn.yql.ejb2.dao;


import javax.ejb.Stateful;
import javax.persistence.*;
import cn.yql.ejb2.*;

@Stateful
public class OneToManyDAO implements OneToManyDAORemote {

    @PersistenceContext(type=PersistenceContextType.EXTENDED, unitName="departmentpu")
    EntityManager em;

    public boolean inserDepartment(Department department){
        try{
            em.persist(department);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Department getDepartmentById(Integer departmentid) {
        Department department=em.find(Department.class, departmentid);
        department.getUsers().size();
        return department;
    }
}