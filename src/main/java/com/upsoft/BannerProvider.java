package com.upsoft;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultBannerProvider;
import org.springframework.shell.support.util.OsUtils;
import org.springframework.stereotype.Component;

/**
 * @author xsTao
 * @date 2016/6/29 13:20
 * @see
 * @since 1.0
 */
@Component
@Order( Ordered.HIGHEST_PRECEDENCE )
class BannerProvider extends DefaultBannerProvider  {

    public String getBanner() {
        StringBuffer buf = new StringBuffer();
        buf.append("=======================================" + OsUtils.LINE_SEPARATOR);
        buf.append("*                                     *"+ OsUtils.LINE_SEPARATOR);
        buf.append("*            public-opinion           *" +OsUtils.LINE_SEPARATOR);
        buf.append("*                                     *"+ OsUtils.LINE_SEPARATOR);
        buf.append("=======================================" + OsUtils.LINE_SEPARATOR);
        buf.append("Version:" + this.getVersion());
        return buf.toString();
    }

    public String getVersion() {
        return "1.0";
    }

    public String getWelcomeMessage() {
        return "Welcome to public-opinion CLI";
    }

    @Override
    public String getProviderName() {
        return "public-opinion-cli";
    }
}