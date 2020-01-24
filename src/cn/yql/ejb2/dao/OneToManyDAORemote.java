package cn.yql.ejb2.dao;

import javax.ejb.Remote;
import cn.yql.ejb2.Department;

@Remote
public interface OneToManyDAORemote {
    public boolean inserDepartment(Department department);
    public Department getDepartmentById(Integer departmentid);
}