package cn.itcast.ssm.Service;

import cn.itcast.ssm.domain.Permission;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface PermissionService {

    public List<Permission> findAll()throws Exception;
    public void save(Permission permission)throws Exception;
}
