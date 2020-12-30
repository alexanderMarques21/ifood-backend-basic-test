package com.ifood.cache;

import com.hazelcast.config.*;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;


public class CacheClient {

    public static final String WEATHERS = "weathers";
    private final HazelcastInstance hazelcastInstance =
            Hazelcast.newHazelcastInstance(createConfig());


    private Config createConfig() {

        Config config = new Config();
        config.addMapConfig(mapConfig());
        return config;
    }

    private MapConfig mapConfig() {
        MapConfig mapConfig = new MapConfig(WEATHERS);
        //How long a entry stays in the cache
        mapConfig.setTimeToLiveSeconds(360);
        // How log a entry stay in cache without use
        mapConfig.setMaxIdleSeconds(10);
        mapConfig.setEvictionConfig(new EvictionConfig().setEvictionPolicy(EvictionPolicy.LRU)
        .setMaxSizePolicy(MaxSizePolicy.PER_NODE));
        return mapConfig;

    }

}
