package com.yaneodog.restcat.service;

import com.yaneodog.restcat.mapper.CatTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/*
 * Service 클래스는 하나의 큰 틀에서 말 그대로 서비스 해주는 애라고 생각하면 됨.
 * 이것처럼 도그 서비스라고 했으면 개와 관련된 뭔가 역할을 하는 애구나 하고 유추 가능.
 */
@Service
public class DogService {
    @Autowired
    public CatTest catTest;

    public void AddDogInfo(String name, Integer year) {
        try {
            HashMap<String, Object> param = new HashMap<>();
            param.put("uid", 1);
            param.put("name", name);
            param.put("year", year);

            catTest.AddDog(param);
        } catch (Exception e) {
            throw e;
        }
    }

    public Map GetDogInfo(int uid) {
        try {
            HashMap<String, Object> param = new HashMap<>();
            param.put("uid", uid);

            return catTest.GetDog(param);
        } catch (Exception e) {
            throw e;
        }
    }
}
