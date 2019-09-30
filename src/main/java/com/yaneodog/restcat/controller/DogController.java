package com.yaneodog.restcat.controller;

import com.yaneodog.restcat.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
 * @RestController 가 붙으면 Rest API 용 컨트롤러 클래스란 의미인데
 * 이게 Http 통신에 대해 아주 쉽게 주소 정의를 해주게 된다
 * 아래의 경우에는 localhost:8080/dog/add  와 같이 된다.
 */
@RestController
@RequestMapping(value="/dog/*")
public class DogController {
    @Autowired
    DogService dogService;

    @RequestMapping(value="/add", method={RequestMethod.POST, RequestMethod.GET})
    public Map AddDog(@RequestParam String name, @RequestParam Integer year) {
        HashMap<String, Object> result = new HashMap<>();

        try {
            dogService.AddDogInfo(name, year);
            result.put("state", "success");
        } catch(Exception e) {
            result.put("state", "failed");
        }

        return result;
    }

    @RequestMapping(value="/get", method={RequestMethod.POST, RequestMethod.GET})
    public Map GetDog(@RequestParam Integer uid) {
        HashMap<String, Object> result = new HashMap<>();

        try {
            Map dogInfo = dogService.GetDogInfo(uid);
            result.put("dogInfo", dogInfo);
            result.put("state", "success");
        } catch(Exception e) {
            result.put("state", "success");
        }

        return result;
    }
}