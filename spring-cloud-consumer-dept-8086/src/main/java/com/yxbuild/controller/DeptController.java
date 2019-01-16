package com.yxbuild.controller;

import com.yxbuild.entity.Dept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 11:04 2019/1/10
 * @Modified By:
 */
@RestController
public class DeptController {

    private static final String REST_URL_PREFIX = "http://SPRING-CLOUD-DEPT-PROVIDER/dept-provider";

    private static Logger logger = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 通过部门服务提供者获取所有部门信息
     *
     * @return
     */
    @GetMapping(value = "/getDeptList")
    public Object getDeptList() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/getDeptList",List.class);
    }

    /**
     * 通过部门服务提供者获取部门信息
     *
     * @param deptId 部门数据标识
     * @return
     */
    @GetMapping(value = "/getDeptById")
    public Object getDeptById(String deptId) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/getDeptById?deptId=" + deptId,Dept.class);
    }

    /**
     * 新增部门信息
     *
     * @param multiValueMap
     * @return
     */
    @PostMapping(value = "/addDept")
    public Object addDept(@RequestParam MultiValueMap multiValueMap) {
        logger.info("参数值:" + multiValueMap);
        return restTemplate.postForObject(REST_URL_PREFIX + "/addDept",multiValueMap,Dept.class);
    }

    /**
     * 获取服务信息
     *
     * @return
     */
    @GetMapping(value = "/discoveryServer")
    public Object discoveryServer() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/discoveryServer",Object.class);
    }
}
