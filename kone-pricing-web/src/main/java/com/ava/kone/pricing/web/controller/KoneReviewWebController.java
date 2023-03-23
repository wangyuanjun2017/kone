package com.ava.kone.pricing.web.controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yuanjun.wang
 * @since 2023.03.21
 */
@RestController
@RequestMapping("/kone")
public class KoneReviewWebController {


    @GetMapping("/count")
    @Operation(description = "快筛角标", security = {@SecurityRequirement(name = "review:count")})
    public Integer largeDemandMaterialReviewCount() {
        return Integer.MIN_VALUE ;
    }

}