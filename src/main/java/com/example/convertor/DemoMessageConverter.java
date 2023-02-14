package com.example.convertor;

import com.example.model.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class DemoMessageConverter extends AbstractHttpMessageConverter<DemoObj> {
    @Override
    protected boolean supports(Class<?> clazz) {
        return DemoObj.class.isAssignableFrom(clazz);   // 判断当前参数对象是否为DemoObj这个类
    }

    /**、
     * 处理请求数据，即将x-y转为DemoObj对象
     */
    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String tmp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));    // 将请求体转为String类型
        String[] tmpArr = tmp.split("-"); // 该请求参数的格式为x-y
        return new DemoObj(Integer.parseInt(tmpArr[0]),tmpArr[1]);  // 转换为目标对象
    }

    /**
     * 处理返回数据，即将DemoObj转为 x-y 的格式
     */
    @Override
    protected void writeInternal(DemoObj demoObj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String result = demoObj.getId() + "-" + demoObj.getName();
        outputMessage.getBody().write(result.getBytes());
    }
}
