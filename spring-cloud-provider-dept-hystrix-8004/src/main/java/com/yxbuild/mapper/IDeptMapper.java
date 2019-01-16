package com.yxbuild.mapper;

import com.yxbuild.entity.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 9:45 2019/1/10
 * @Modified By:
 */
@Component
@Mapper
public interface IDeptMapper {

    /**
     * 获取所有部门信息
     *
     * @return
     */
    @Select(value = "select * from dept ")
    List<Dept> findDeptList();

    /**
     * 根据数据标识获取部门信息
     *
     * @param deptId 部门数据标识
     * @return
     */
    @Select(value = "select * from dept where deptId = #{deptId}")
    Dept findDeptById(String deptId);

    /**
     * 新增部门信息
     *
     * @param dept 部门信息
     */
    @Insert(value = "insert into dept(deptId,deptName,state,db_source) values(#{deptId},#{deptName},#{state},database())")
    void insertDept(Dept dept);

    /**
     * 根据部门数据标识修改名称
     *
     * @param dept
     */
    @Update(value = "update dept set deptName = #{deptName} where deptId = #{deptId}")
    void updateDeptNameById(Dept dept);
}
