package com.hei123.demo.annotation;

public @interface NeedServer {
    boolean value() default true;
}
