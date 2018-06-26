package com.peng.ajaxserver;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Spring切面处理
 * Created by PengHongfu 2018-06-22 16:02
 */
@ControllerAdvice
public class JsonAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonAdvice() {
        super("callback");
    }
}
