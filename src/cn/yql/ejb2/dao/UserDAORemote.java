package cn.yql.ejb2.dao;

import java.util.List;
import javax.ejb.Remote;

import cn.yql.ejb2.User;

@Remote
public interface UserDAORemote {
    public List<User>  select(String sql);
    public boolean insert(User user);
}