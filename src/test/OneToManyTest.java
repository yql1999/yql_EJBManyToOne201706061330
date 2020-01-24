package test;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import cn.yql.ejb2.User;
import cn.yql.ejb2.Department;
import cn.yql.ejb2.dao.OneToManyDAORemote;

public class OneToManyTest {

private static OneToManyDAORemote lookupRemoteStatelessEjbBean() throws NamingException {
        
		final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        
        final Context context = new InitialContext(jndiProperties);
        final String appName = "";
        final String moduleName = "ejb-project2";        
        final String distinctName = "";        
        final String beanName = "OneToManyDAO";       
        final String viewClassName = OneToManyDAORemote.class.getName();        
        final String namespace = "ejb:" + appName + "/" + moduleName 
			+ "/" + distinctName + "/" + beanName + "!" + viewClassName;
        
        System.out.println(namespace);
        
        return (OneToManyDAORemote) context.lookup(namespace);
        
    }
	public static void main(String[] args) {
		try{
			OneToManyDAORemote o2mdao = lookupRemoteStatelessEjbBean();			
			Department department=new Department();
			department.setDepartmentname("×éÖ¯²¿");
			User u1=new User();
			u1.setUsername("user01");
			User u2=new User();
			u2.setUsername("user02");
			department.addNewUser(u1);
			department.addNewUser(u2);
			o2mdao.inserDepartment(department);	
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
}
