package com.ava.kone.pricing.web.health;

/**
 * @author: create by yuanjun.wang
 * 就绪检测 存活检测
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    @RequestMapping("/check")
    public String check() {
        return "kone-pricing-web is ok";
    }

}
