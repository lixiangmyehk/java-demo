package com.mye.service.impl;

import com.mye.model.Record;
import com.mye.service.HelloService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HelloServiceImpl implements HelloService {


    public String Say(){
        return "hello world!";
    }

    @Override
    public List<Record> result() {
        // Set<String> keys = redisClient.keys("1*");
        // List<String> times = new ArrayList<>(keys);
        // Collections.sort(times, new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         return new Long(o2).compareTo(new Long(o1));
        //     }
        // });
        List<Record> records = new ArrayList<>();
        // for (String time : times) {
        //     Record record = new Record();
        //     record.setTime(time);
        //     record.setResult(redisClient.get(time));
        //     records.add(record);
        // }
        return records;
    }

}
