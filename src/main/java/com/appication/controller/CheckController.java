package com.appication.controller;

import com.appication.pojo.StaticMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: WeiChaoChao
 * @Description TODO
 * @Date 2018/11/28
 */
@Controller
@RequestMapping(path = "/check")
public class CheckController {
    @RequestMapping("1")
    public void showUserInfo(String name) {
        System.out.println(name);
        if (StaticMap.staticMap.containsKey(name)) {
            System.out.println("我已经存在:当前线程为" + Thread.currentThread().getId() + StaticMap.staticMap.get("name"));
        } else {
            System.out.println("我不存在我要添加数据,当前线程为:" + Thread.currentThread().getId());
            StaticMap.staticMap.put("name", name);
        }
    }

}
