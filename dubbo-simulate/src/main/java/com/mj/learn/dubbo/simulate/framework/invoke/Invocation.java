package com.mj.learn.dubbo.simulate.framework.invoke;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Invocation implements Serializable {
    private String interfaceName;
    private String methodName;
    private Class[] paramsType;
    private Object[] params;
}
