package cn.yql.ejb.lifecycle;

import javax.ejb.*;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Init;
import javax.ejb.Remove;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

@Stateful(name = "LifeCycleEJB")
@Remote(LifeCycleRemote.class)

public class LifeCycleBean implements LifeCycleRemote {
    public LifeCycleBean() { }

    public String hello(String name) {
        try {
            Thread.sleep(1000 * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello" + name + "!";
    }

    @Init
    public void init() {
    	//初始化
        System.out.println("the init() method was invoked");
    }

    @PostConstruct
    public void construct() {
    	//创建
        System.out.println("the postConstruct() method was invoked");
    }

    @PreDestroy
    public void exit() {
    	//销毁
        System.out.println("the preDestroy() method was invoked");
    }

    @PostActivate
    public void activate() {
    	//激活
        System.out.println("the postActivate() method was invoked");
    }

    @PrePassivate
    public void prePassivate() {
    	//钝化
        System.out.println("the prePassivate() method was invoked");
    }

    @Remove
    public void removeSession() {
    	//移除
        System.out.println("the remove() method was invoked");
    }
}