package com.study.shardingjdbcdemo.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * order_id为UUID时的分配规则
 */
public class MySharding implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<String> preciseShardingValue) {
        String id = preciseShardingValue.getValue();

        int mode = id.hashCode() % collection.size();
        String[] strings = collection.toArray(new String[0]);
        mode = Math.abs(mode);

        System.out.println(strings[0]+"------"+strings[1]);
        System.out.println("mode="+mode);
        return strings[mode];
    }
}
