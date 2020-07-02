package com.kooniverse.farm.system.diagnosis;

import org.springframework.stereotype.Service;

@Service
public class MyBatisService {

    final MyBatisMapper myBatisMapper;

    public MyBatisService(MyBatisMapper myBatisMapper) {
        this.myBatisMapper = myBatisMapper;
    }

    public String currentDate() {
        String date = myBatisMapper.currentDate();
        return date;
    }
}
