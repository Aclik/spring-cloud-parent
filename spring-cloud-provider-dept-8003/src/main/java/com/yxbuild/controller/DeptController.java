package com.yxbuild.controller;

import com.yxbuild.entity.Dept;
import com.yxbuild.service.IDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 9:05 2019/1/10
 * @Modified By:
 */
@Controller
public class DeptController {

    private static Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private IDeptService deptService;

    /**
     * 获取所有部门信息
     *
     * @return
     */
    @GetMapping(value = "/getDeptList")
    @ResponseBody
    public Object getDeptList() {
        return deptService.getDeptList();
    }

    /**
     * 根据部门数据标识获取部门信息
     *
     * @param deptId 部门数据标识
     * @return
     */
    @GetMapping(value = "/getDeptById")
    @ResponseBody
    public Object getDeptById(String deptId) {
        return deptService.getDeptById(deptId);
    }

    /**
     * 新增部门信息
     *
     * @param dept
     * @return
     */
    @PostMapping(value = "/addDept")
    @ResponseBody
    public Object addDept(Dept dept){
        deptService.addDept(dept);
        return dept;
    }

    /**
     * 根据部门数据标识修改名称
     *
     * @param dept
     * @return
     */
    @PostMapping(value = "/updateDept")
    @ResponseBody
    public Object updateDeptNameById(Dept dept) {
        deptService.updateDeptNameById(dept);
        return dept;
    }

    @RequestMapping(value = "/discoveryServer")
    @ResponseBody
    public Object discoveryServer() {
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("SPRING-CLOUD-DEPT-PROVIDER");
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            logger.info(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t"
            + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
        }
        return discoveryClient;
    }
}
