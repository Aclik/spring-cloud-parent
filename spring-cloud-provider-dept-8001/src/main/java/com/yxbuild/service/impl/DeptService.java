package com.yxbuild.service.impl;

import com.yxbuild.entity.Dept;
import com.yxbuild.mapper.IDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yxbuild.service.IDeptService;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 9:07 2019/1/10
 * @Modified By:
 */
@Service
public class DeptService implements IDeptService {

    @Autowired
    private IDeptMapper deptMapper;

    @Override
    public List<Dept> getDeptList() {
        return deptMapper.findDeptList();
    }

    @Override
    public Dept getDeptById(String deptId) {
        return deptMapper.findDeptById(deptId);
    }

    @Override
    public void addDept(Dept dept) {
        if (StringUtils.isEmpty(dept.getDeptId())){
            dept.setDeptId(UUID.randomUUID().toString());
        }
        deptMapper.insertDept(dept);
    }

    @Override
    public void updateDeptNameById(Dept dept) {
        deptMapper.updateDeptNameById(dept);
    }
}
