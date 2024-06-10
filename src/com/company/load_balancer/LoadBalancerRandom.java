package com.company.load_balancer;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class LoadBalancerRandom implements LoadBalancer{
    private List<String> urls = new ArrayList<>();
    private AtomicInteger count = new AtomicInteger(0);

    public synchronized void add(String url) {
        urls.add(url);
    }

    public synchronized String getNext() {
        Random rand = new Random();
        return urls.get(rand.nextInt(urls.size()));
    }

    public AtomicInteger getCount() {
        return count;
    }

    @Test
    public void test() {
        LoadBalancerRandom loadBalancer = new LoadBalancerRandom();
        loadBalancer.add("http://www.google.com");
        loadBalancer.add("http://www.google1.com");


        Assert.assertEquals(loadBalancer.getNext(), "http://www.google.com");
        Assert.assertEquals(loadBalancer.getNext(), "http://www.google1.com");
    }

    @Test
    public void testRoundRobin() {
        LoadBalancerRandom loadBalancer = new LoadBalancerRandom();
        loadBalancer.add("http://www.google.com");
        loadBalancer.add("http://www.google1.com");


        Assert.assertEquals(loadBalancer.getNext(), "http://www.google.com");
        Assert.assertEquals(loadBalancer.getNext(), "http://www.google1.com");
        Assert.assertEquals(loadBalancer.getNext(), "http://www.google.com");
    }


    @Test
    public void testRoundRobinWhenAddNewURL() {
        LoadBalancerRandom loadBalancer = new LoadBalancerRandom();
        loadBalancer.add("http://www.google.com");
        loadBalancer.add("http://www.google1.com");


        Assert.assertEquals(loadBalancer.getNext(), "http://www.google.com");
        Assert.assertEquals(loadBalancer.getNext(), "http://www.google1.com");

        loadBalancer.add("http://www.google2.com");

        Assert.assertEquals(loadBalancer.getNext(), "http://www.google2.com");
    }
}
