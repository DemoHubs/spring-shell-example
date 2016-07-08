package com.upsoft;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultPromptProvider;
import org.springframework.stereotype.Component;

/**
 * @author xsTao
 * @date 2016/6/29 13:16
 * @see
 * @since 1.0
 */
@Component
@Order( Ordered.HIGHEST_PRECEDENCE )
class PromptProvider extends DefaultPromptProvider {

        @Override
        public String getPrompt() {
                return "public-opinion>";
                }


        @Override
        public String getProviderName() {
                return  "public-opinion prompt provider ";
        }

}