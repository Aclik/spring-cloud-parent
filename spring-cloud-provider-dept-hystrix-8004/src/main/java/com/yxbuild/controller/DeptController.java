package com.yxbuild.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
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
    private IDeptService deptService;


    /**
     * 根据部门数据标识获取部门信息
     *
     * @param deptId 部门数据标识
     * @return
     */
    @GetMapping(value = "/getDeptById")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Object getDeptById(String deptId) {
        Dept dept = deptService.getDeptById(deptId);
        if (dept == null) {
            throw new RuntimeException("");
        }
        return dept;
    }

    public String processHystrix_Get(String deptId) {
        return deptId + "没有找到相对应的部门信息!";
    }
}
