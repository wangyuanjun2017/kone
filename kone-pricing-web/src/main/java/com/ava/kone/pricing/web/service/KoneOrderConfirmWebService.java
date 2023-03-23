package com.ava.kone.pricing.web.service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 下单版确认业务服务
 *
 * @author yuanjun.wang
 * @date 2022/8/9 16:56
 */
@Service
public class KoneOrderConfirmWebService {


	/**
     * 分页列表
     *
     * @param pageQuery 查询参数
     * @return 分页列表
     */
    public PageResult<KoneOrderConfirmPageRespVo> KoneOrderConfirmPage(KoneOrderConfirmPageQuery pageQuery) {
        PageResult<KoneOrderConfirmPageRespVo> pageDTOResult = demandOrderConfirmPage(pageQuery);
        return pageVoResult;
    }

}
