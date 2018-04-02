package com.yz;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author YZ
 * @Date 2018/4/2
 */
public class PreRequestLogFilter extends ZuulFilter {
    private static final Logger LOGGER= LoggerFactory.getLogger(PreRequestLogFilter.class);

    //过滤器的类型
    public String filterType() {
        return "pre";
    }

    //指定过滤器的执行顺序，不同的过滤器允许返回相同的数字
    public int filterOrder() {
        return 1;
    }

    //返回一个boolean值判断该过滤器是否要执行
    public boolean shouldFilter() {
        return true;
    }

    //过滤器的具体逻辑；本例中让它打印了请求的HTTP方法以及请求的地址
    public Object run() {
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        PreRequestLogFilter.LOGGER.info(String.format("send %s request to %s",request.getMethod(),request.getRequestURL().toString()));
        return null;
    }
}
