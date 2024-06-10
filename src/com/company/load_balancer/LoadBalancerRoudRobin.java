package com.company.load_balancer;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadBalancerRoudRobin implements LoadBalancer {
    private List<String> urls = new ArrayList<>();
    private AtomicInteger count = new AtomicInteger(0);

    public void add(String url) {
        urls.add(url);
    }

    public String getNext() {
        if (count.get() >= urls.size()) {
            count = new AtomicInteger(0);
        }
        return urls.get(count.getAndIncrement());
    }

    public AtomicInteger getCount() {
        return count;
    }

    @Test
    public void test() {
        LoadBalancerRoudRobin loadBalancer = new LoadBalancerRoudRobin();
        loadBalancer.add("http://www.google.com");
        loadBalancer.add("http://www.google1.com");


        Assert.assertEquals(loadBalancer.getNext(), "http://www.google.com");
        Assert.assertEquals(loadBalancer.getNext(), "http://www.google1.com");
    }

    @Test
    public void testRoundRobin() {
        LoadBalancerRoudRobin loadBalancer = new LoadBalancerRoudRobin();
        loadBalancer.add("http://www.google.com");
        loadBalancer.add("http://www.google1.com");


        Assert.assertEquals(loadBalancer.getNext(), "http://www.google.com");
        Assert.assertEquals(loadBalancer.getNext(), "http://www.google1.com");
        Assert.assertEquals(loadBalancer.getNext(), "http://www.google.com");
    }


    @Test
    public void testRoundRobinWhenAddNewURL() {
        LoadBalancerRoudRobin loadBalancer = new LoadBalancerRoudRobin();
        loadBalancer.add("http://www.google.com");
        loadBalancer.add("http://www.google1.com");


        Assert.assertEquals(loadBalancer.getNext(), "http://www.google.com");
        Assert.assertEquals(loadBalancer.getNext(), "http://www.google1.com");

        loadBalancer.add("http://www.google2.com");

        Assert.assertEquals(loadBalancer.getNext(), "http://www.google2.com");
    }
}
