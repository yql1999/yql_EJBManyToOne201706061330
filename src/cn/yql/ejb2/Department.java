package cn.yql.ejb2;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "department")

public class Department implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "t_id")
//    private Long tId;
//    @Column(name = "t_name")
//    private String tName;
//    @OneToMany(targetEntity = Student.class)
//    @JoinColumn(name = "s_t_id",referencedColumnName = "t_id")
//    private Set<Student> students = new HashSet<>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "departmentid")
    private Integer departmentid;

    @Column(name = "departmentname")
    private String departmentname;

    /*Department��UserΪһ�Զ��ϵ�����ҵ�ǰ���Ͷ�Ӧ����User��Department���ݳ�Ա	��ʵ�����еļ������������Ҽ��ؼ����е����ݣ�����)Ϊ�ӳټ���*/
    @OneToMany(targetEntity = User.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    @OrderBy(value="userid ASC")
    @JoinColumn(name = "departmentid",referencedColumnName = "departmentid")
    private Set<User> users=new HashSet<User>();

    public Department() { }


    public Integer getDepartmentid() { return departmentid; }
    public void setDepartmentid(Integer departmentid) { this.departmentid = departmentid; }

    public String getDepartmentname() {
        return departmentname;
    }
    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public Set<User> getUsers() {
        return users;
    }
    public void setUsers(Set<User> users) { this.users = users; }

    public void addNewUser(User user){
        if(!this.users.contains(user)){
            this.users.add(user);
            user.setDepartment(this);
        }
    }
    public void removeUser(User user){
        user.setDepartment(null);
        this.users.remove(user);
    }
}
