package cn.yql.ejb.lifecycle;

public interface LifeCycleRemote {
    public String hello(String name);
    public void removeSession();
}
