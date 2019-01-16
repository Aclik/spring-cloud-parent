package com.yxbuild.fallback;

import com.yxbuild.entity.Dept;
import com.yxbuild.service.IDeptService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 10:31 2019/1/15
 * @Modified By:
 */
@Component
public class DeptServiceFallbackFactory implements FallbackFactory<IDeptService> {

    @Override
    public IDeptService create(Throwable throwable) {
        return new IDeptService() {
            @Override
            public Dept getDeptById(String deptId) {
                Dept dept = new Dept();
                dept.setDeptName("没有找到相关的部门信息!");
                return dept;
            }

            @Override
            public List<Dept> getAllDept() {
                return null;
            }

            @Override
            public Dept addDept(Dept dept) {
                return null;
            }
        };
    }
}
