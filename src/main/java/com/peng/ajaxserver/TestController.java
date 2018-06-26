package com.peng.ajaxserver;

import org.springframework.web.bind.annotation.*;

/**
 * Created by PengHongfu 2018-06-21 10:57
 */
@RestController
@RequestMapping("/test")
//@CrossOrigin
public class TestController {

    @GetMapping("/get1")
    public ResulstBean get1(){
        System.out.println("get1");
        return new ResulstBean("get1 ok");
    }

    @PostMapping("/postJson")
    public ResulstBean postJSon(@RequestBody User user){
        System.out.println("postJson");
        return new ResulstBean("postJson "+user.getName());
    }

    @GetMapping("/getCookie")
    public ResulstBean getCookie(@CookieValue(value = "cookie1") String cookie1){
        System.out.println("getCookie");
        return new ResulstBean("getCookie "+cookie1);
    }

    @GetMapping("/getHeader")
    public ResulstBean getHeader(@RequestHeader(value = "x-header1") String header1,
                                 @RequestHeader(value = "x-header2") String header2){
        System.out.println("getHeader");
        return new ResulstBean("getHeader "+header1 +" "+header2);
    }
}
