package com.tsc.iorder.controller;

import com.tsc.iorder.domain.Carousel;
import com.tsc.iorder.domain.SearchParam;
import com.tsc.iorder.service.CarouselService;
import com.tsc.iorder.util.SaveFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Carousel")
public class CarouselController {
    @Autowired
    private CarouselService service;
    public static String urlCarousel = "F:/ideaFile/Intelligent_ordering_system/IntelligentOrderingSystem/static/images/carousel";
    public static String dbUrlCarousel = "/static/images/carousel/";
    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> list(@RequestBody Map<String,Object> map){
        Map<String,Object> resMap = new HashMap<>();
        SearchParam searchParam = new SearchParam(map);
        List<Carousel> list =  this.service.list(searchParam);
        int count = this.service.listCount();
        resMap.put("count",count);
        resMap.put("list",list);
        return resMap;
    }
    @RequestMapping("/updateIsShow")
    @ResponseBody
    public void updateIsShow(@RequestBody Map<String,Object> map){
        SearchParam searchParam = new SearchParam();
        searchParam.setId((int) map.get("id"));
        searchParam.setEvent((int) map.get("event"));
        this.service.updateIsShow(searchParam);
    }
    @RequestMapping("/show")
    @ResponseBody
    public void show(@RequestBody Map<String,Object> map){
        SearchParam searchParam = new SearchParam();
        searchParam.setId((int) map.get("id"));
        this.service.show(searchParam);
    }
    @RequestMapping("/hidden")
    @ResponseBody
    public void hidden(@RequestBody Map<String,Object> map){
        SearchParam searchParam = new SearchParam();
        searchParam.setId((int) map.get("id"));
        this.service.hidden(searchParam);
    }
    @RequestMapping("/upload")
    @ResponseBody
    public boolean upload(@RequestParam("file") MultipartFile file, Carousel carousel) throws IOException {
        SaveFile save = new SaveFile();
        String fileName = save.saveFile(file, urlCarousel);
        carousel.setPath(dbUrlCarousel+fileName);
        return this.service.addCarousel(carousel);
    }
    @RequestMapping("/search")
    @ResponseBody
    public List<String> search() {
        return this.service.search();
    }
}
