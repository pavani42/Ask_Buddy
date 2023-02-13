package com.hcl.ask_buddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;

@Service
public class GenarateUrl {
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	public String getBaseUrl(String microServiceName) {
        ServiceInstance instance = loadBalancerClient.choose(microServiceName);
        System.out.println("base url : " + instance.getUri().toString());
        return instance.getUri().toString();
    }
	

}
