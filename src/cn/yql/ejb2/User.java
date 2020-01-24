package cn.yql.ejb2;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="userlist",schema = "public")

public class User implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "s_id")
//    private Long sId;
//    @Column(name = "s_name")
//    private String sName;
//    @ManyToOne(targetEntity = Teacher.class)
//    @JoinColumn(name = "s_t_id",referencedColumnName = "t_id")
//    private Teacher teacher;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userid;

    @Column(name="username", length=50)
    private String username;

    @Column(name="userpwd", length=50)
    private String userpwd;

    @Column(name="age")
    private Integer age;

    /*��������DepartmentΪ�����һ��������ͨ��@ManyToOneע��ָ����ͨ��departmentid�ֶ��У��������Department������� */
    @ManyToOne(targetEntity = Department.class,cascade=CascadeType.ALL,optional=false)
    @JoinColumn(name = "departmentid",referencedColumnName = "departmentid")
    private Department department;


    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }

    public Integer getUserid() { return userid; }
    public void setUserid(Integer userid) { this.userid = userid; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getUserpwd() { return userpwd; }
    public void setUserpwd(String userpwd) { this.userpwd = userpwd; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

}