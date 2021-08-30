package com.hss.bolckHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 控流反馈页面
 */
public class ExceptionUtil {

    public static String exHandler(BlockException ex){
        return "exHandler error--限流";
    }

    public static String exHandlerParam(String type, BlockException ex){
        return "exHandler error--限流";
    }

    public static String fallbackHandler(String param){
        return "fallbackHandler error--熔断";
    }
}
