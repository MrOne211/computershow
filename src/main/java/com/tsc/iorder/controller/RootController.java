package com.tsc.iorder.controller;

import com.tsc.iorder.domain.Root;
import com.tsc.iorder.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Root")
public class RootController {
    @Autowired
    private RootService service;
    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> list(){
        Map<String,Object> map = new HashMap<>();
        List<Root> list = this.service.list();
        map.put("list",list);
        return map;
    }
}
