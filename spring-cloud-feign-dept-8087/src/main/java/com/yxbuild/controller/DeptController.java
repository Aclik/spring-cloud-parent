package com.yxbuild.controller;

import com.yxbuild.entity.Dept;
import com.yxbuild.service.IDeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 11:04 2019/1/10
 * @Modified By:
 */
@RestController
public class DeptController {

    private static Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private IDeptService deptService;

    /**
     * 根据部门数据标识获取数据详情信息
     *
     * @param deptId 部门数据标识
     * @return
     */
    @GetMapping(value = "/getDeptById")
    public Object getDeptById(String deptId) {
        logger.info("Feign负载均衡获取部门详情信息成功!",deptId);
        return deptService.getDeptById(deptId);
    }

    /**
     * 获取所有的部门信息
     *
     * @return
     */
    @GetMapping(value = "/getAllDept")
    public Object getAllDept() {
        return deptService.getAllDept();
    }
}
