package com.tong.hellodoubledatasource.config;


import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ...
 * @date
 */
@Configuration
public class DataSourceConfig {



    public static Map<String, String> getProperties() {
        Map<String, String> map = new HashMap<>();
        map.put("format_sql", "true");
        map.put("max_fetch_depth", "1");
        return map;
    }

}
