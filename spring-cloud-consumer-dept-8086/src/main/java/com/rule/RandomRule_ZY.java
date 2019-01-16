package com.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @Author: WenxiangChen
 * @Description:
 * @Date: Create in 15:05 2019/1/14
 * @Modified By:
 */
public class RandomRule_ZY extends AbstractLoadBalancerRule {

    private int total = 0;// 记录服务被使用的次数

    private int currentIndex = 0;// 记录正在被使用的索引

    /**
     * 轮询每个服务地调用5次之后,才能进行下次的轮询
     *
     * @param loadBalancer
     * @param key
     * @return
     */
    public Server choose(ILoadBalancer loadBalancer,Object key) {
        if (loadBalancer == null) {
            return null;
        }
        Server server = null;
        while (server == null) {
            // 判断线程是否中断
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upServerList = loadBalancer.getReachableServers(); // 获取所有可用的服务
            List<Server> allServerList = loadBalancer.getAllServers(); // 获取所有的服务
            if (allServerList != null && allServerList.size() == 0) {
                return null;
            }
            // 如果当前服务被调用的次数小于5,则继续使用
            if (total < 5) {
                server = upServerList.get(currentIndex);
                total++;
            } else {
                total = 0;
                currentIndex++;// 下一个服务
                if (currentIndex >= upServerList.size()) {
                    currentIndex = 0;
                }
            }

            if (server == null) {
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return (server);
            }
            server = null;
            Thread.yield();
        }
        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(),key);
    }
}
