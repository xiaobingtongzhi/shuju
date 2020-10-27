package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.Member;
import cn.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    //根据id查询产品
    @Select("select * from member where id=#{id}")
    public Member findById(String id) throws Exception;
}
