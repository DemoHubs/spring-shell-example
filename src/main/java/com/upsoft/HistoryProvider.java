package com.upsoft;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultHistoryFileNameProvider;
import org.springframework.stereotype.Component;

/**
 * @author xsTao
 * @date 2016/6/29 14:33
 * @see
 * @since 1.0
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
class HistoryProvider extends DefaultHistoryFileNameProvider {

    public String getHistoryFileName() {
        return "my.log";
    }

    @Override
    public String getProviderName() {
        return "My history file name provider";
    }

}

