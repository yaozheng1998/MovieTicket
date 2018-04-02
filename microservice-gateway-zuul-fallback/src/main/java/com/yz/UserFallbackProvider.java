package com.yz;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @Author YZ
 * @Date 2018/4/2
 */
public class UserFallbackProvider implements ZuulFallbackProvider {
    public String getRoute() {
        //表明是哪个微服务提供回退
        return "microservice-provider-user";
    }

    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();
            }

            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();
            }

            public void close() {

            }

            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("用户微服务不可用，请稍后再试".getBytes());
            }

            public HttpHeaders getHeaders() {
                HttpHeaders headers=new HttpHeaders();
                MediaType mt=new MediaType("application","json", Charset.forName("UTF-8"));
                headers.setContentType(mt);
                return headers;
            }
        };
    }
}
