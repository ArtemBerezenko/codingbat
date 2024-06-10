package com.company.load_balancer;

public interface LoadBalancer {
    void add(String url);
    String getNext();
}
