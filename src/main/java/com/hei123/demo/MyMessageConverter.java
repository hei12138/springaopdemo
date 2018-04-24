package com.hei123.demo;

import com.hei123.demo.dto.DemoObject;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObject> {

    public MyMessageConverter(){
        super(new MediaType("application","x-wisely", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    protected DemoObject readInternal(Class<? extends DemoObject> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        return new DemoObject(new Long(tempArr[0]),tempArr[1]);

    }

    @Override
    protected void writeInternal(DemoObject object, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out="hello:"+object.getId()+"-"+object.getName();
        httpOutputMessage.getBody().write(out.getBytes());
    }
}
