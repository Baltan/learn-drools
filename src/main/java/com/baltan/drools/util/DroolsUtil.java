package com.baltan.drools.util;

import org.drools.core.spi.KnowledgeHelper;

/**
 * Description:
 *
 * @author Baltan
 * @date 2020-06-28 08:49
 */
public class DroolsUtil {
    /***
     * 打印被触发的规则
     * @param drools
     */
    public static void helper(final KnowledgeHelper drools) {
        System.out.println("rule triggered: " + drools.getRule().getName());
    }
}
