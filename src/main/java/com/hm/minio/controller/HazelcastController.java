package com.hm.minio.controller;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HazelcastController {
    private HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
    Map<String, String> hazelcastMap = hazelcastInstance.getMap("hMap");
    @PostMapping("/put")
    public String put(){
        hazelcastMap.put("key", "value");
        return "OK";
    }
    @GetMapping("/get")
    public String get(){
        return hazelcastMap.get("key");
    }
}
