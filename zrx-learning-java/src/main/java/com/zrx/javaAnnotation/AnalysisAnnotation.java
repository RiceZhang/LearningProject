package com.zrx.javaAnnotation;

import java.lang.reflect.Method;

/**
 * Function:    AnalysisAnnotation
 * Author:      zhangrixiong
 * DateTime:    2016/8/23 12:47
 *
 * 自定义注解，可以应用到反射中，如实现实体类某些属性不自动赋值，或者验证某个对象属性完整性等
 *
 * 那些偷师之地：
 *     http://blog.csdn.net/tengdazhang770960436/article/details/37886361
 */
public class AnalysisAnnotation {

    /**
     * 在运行时分析处理annotation类型的信息
     */
    public static void main(String[] args) {
        try {
            //通过运行时反射API获得annotation信息，Class 反射类级别，java.lang.reflect.Method 反射方法级别
            Class rt_class = Class.forName("com.zrx.javaAnnotation.Utility");
            Method[] methods = rt_class.getMethods();
            boolean flag = rt_class.isAnnotationPresent(Description.class);
            if(flag)
            {
                Description description = (Description)rt_class.getAnnotation(Description.class);
                System.out.println("Utility's Description--->"+description.value());
                for (Method method : methods) {
                    if(method.isAnnotationPresent(Author.class))
                    {
                        Author author = (Author)method.getAnnotation(Author.class);
                        System.out.println("Utility's Author--->"+author.name()+" from "+author.group());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
