package com.yxbuild.service;

import com.yxbuild.entity.Dept;

import java.util.List;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 9:07 2019/1/10
 * @Modified By:
 */
public interface IDeptService {

    /**
     * 获取所有部门信息
     *
     * @return
     */
    List<Dept> getDeptList();

    /**
     * 根据部门数据标识获取部门信息
     *
     * @param deptId 部门数据标识
     * @return
     */
    Dept getDeptById(String deptId);

    /**
     * 新增部门信息
     *
     * @param dept
     */
    void addDept(Dept dept);

    /**
     * 根据部门数据标识修改名称
     *
     * @param dept
     */
    void updateDeptNameById(Dept dept);
}
