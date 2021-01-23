package com.hm.minio.config;
import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfiguration {
    @Bean
    public Config hazelCastConfig() {
        return
            new Config().setInstanceName("hazelcast-instance").addMapConfig(new MapConfig()
                    .setName("configuration")
                    .setEvictionConfig(new EvictionConfig().setEvictionPolicy(EvictionPolicy.LRU))
                    .setTimeToLiveSeconds(1)
            );
        }
}
