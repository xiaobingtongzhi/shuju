package cn.itcast.ssm.Service;

import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
     List<UserInfo> findAll() throws Exception;
     public void save(UserInfo userInfo) throws Exception;
     public UserInfo findById(String id)throws Exception;
     public List<Role> findOtherRoles(String userId)throws Exception;

     void addRoleToUser(String userId, String[] roleIds);
}
