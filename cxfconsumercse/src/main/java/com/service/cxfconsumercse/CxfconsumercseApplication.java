package com.service.cxfconsumercse;

import org.apache.servicecomb.foundation.common.utils.BeanUtils;
import org.apache.servicecomb.foundation.common.utils.Log4jUtils;

public class CxfconsumercseApplication {
    public static void main(String[] args) throws Exception {
        System.setProperty("http.proxyHost", "10.1.3.80");
        System.setProperty("http.proxyPort", "30101");

        Log4jUtils.init();
        BeanUtils.init();
    }
}
