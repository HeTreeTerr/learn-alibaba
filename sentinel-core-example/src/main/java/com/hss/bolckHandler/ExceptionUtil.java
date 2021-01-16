package com.hss.bolckHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * 控流反馈页面
 */
public class ExceptionUtil {

    public static String exHandler(BlockException ex){
        return "exHandler error";
    }

    public static String exHandlerParam(String type, BlockException ex){
        return "exHandler error";
    }
}
