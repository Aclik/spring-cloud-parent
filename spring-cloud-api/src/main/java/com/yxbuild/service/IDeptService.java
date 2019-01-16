package com.yxbuild.service;

import com.yxbuild.entity.Dept;
import com.yxbuild.fallback.DeptServiceFallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 16:29 2019/1/14
 * @Modified By:
 */
@FeignClient(value = "SPRING-CLOUD-DEPT-PROVIDER",fallbackFactory = DeptServiceFallbackFactory.class)
public interface IDeptService {

    /**
     * 根据部门数据标识获取详情信息
     *
     * @param deptId 部门数据标识
     * @return
     */
    @GetMapping(value = "/dept-provider/getDeptById")
    Dept getDeptById(@RequestParam(value = "deptId") String deptId);

    /**
     * 获取所有部门信息
     *
     * @return
     */
    @GetMapping(value = "/dept-provider/getDeptList")
    List<Dept> getAllDept();

    /**
     * 新增部门信息
     *
     * @param dept
     * @return
     */
    @PostMapping(value = "/dept-provider/addDept")
    Dept addDept(Dept dept);
}
