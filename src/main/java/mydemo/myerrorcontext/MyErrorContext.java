 /*
  * Copyright (c) 2018年12月20日  by XuanWu Wireless Technology Co., Ltd
  *             All rights reserved
  */
 package mydemo.myerrorcontext;



 import java.util.Objects;

 /**
  * @author <a href="mailto:zhaominglin@wxchina.com">minglin.Zhao</a>
  * @Description
  * @Date 2018/12/20
  * @Version 1.0.0
  */
 public class MyErrorContext {

     private static final String LINE_SEPARATOR = System.getProperty("line.separator", "\n");

     /**
      * 错误信息跟踪本地方法
      */
     private static final ThreadLocal<MyErrorContext> errorTrace = new ThreadLocal<MyErrorContext>();

     private String message;
     private String clazz;
     private String method;
     private Throwable cause;

     /**
      * 获取errorContext的实例
      *
      * @return errorContext的实例
      */
     public static MyErrorContext getInstance() {
         MyErrorContext errorContext = errorTrace.get();
         if (Objects.isNull(errorContext)) {
             errorContext = new MyErrorContext();
             errorTrace.set(errorContext);
         }
         return errorContext;
     }

     /**
      * 设置错误信息
      *
      * @param message 错误信息
      * @return this
      */
     public MyErrorContext setMessage(String message) {
         this.message = message;
         return this;
     }

     /**
      * 设置发生错误的class文件
      *
      * @return this
      */
     public MyErrorContext setClass(String clazz) {
         this.clazz = clazz;
         return this;
     }

     /**
      * 设置方法名称
      *
      * @param method 方法名称
      * @return this
      */
     public MyErrorContext setMethod(String method) {
         this.method = method;
         return this;
     }

     /**
      * 设置异常信息
      *
      * @return this
      */
     public MyErrorContext setCause(Throwable cause) {
         this.cause = cause;
         return this;
     }

     /**
      * 清理对象
      */
     public MyErrorContext clear() {

         /** errorTrace remove */
         errorTrace.remove();

         /** 信息内容清空 */
         this.message = null;
         this.method = null;
         this.clazz = null;
         this.cause = null;
         return this;
     }

     /**
      * 设置errorContext
      * @param errorContext
      */
     public void setErrorContext(MyErrorContext errorContext){
         errorTrace.set(errorContext);
     }

     /**
      * 拷贝相关的内容
      * @return
      */
     public MyErrorContext deepCopy() {
         try {
             return (MyErrorContext) this.clone();
         } catch (CloneNotSupportedException e) {
             return new MyErrorContext().setCause(e);
         }
     }

     @Override
     protected Object clone() throws CloneNotSupportedException {

         MyErrorContext errorContext = new MyErrorContext();
         errorContext.setCause(this.cause).setMethod(this.method).setMessage(this.message).setClass(this.clazz);

         return errorContext;
     }

     @Override
     public String toString() {

         StringBuilder description = new StringBuilder();

         if (Objects.nonNull(message)) {
             description.append(LINE_SEPARATOR);
             description.append("### ");
             description.append(this.message);
         }

         if (Objects.nonNull(clazz)) {
             description.append(LINE_SEPARATOR);
             description.append("### happen error may at: ");
             description.append(this.clazz);
         }

         if (Objects.nonNull(method)) {
             description.append(LINE_SEPARATOR);
             description.append("### happen method may at: ");
             description.append(this.method);
         }

         if (Objects.nonNull(cause)) {
             description.append(LINE_SEPARATOR);
             description.append("### Cause: ");
             description.append(this.cause.toString());
         }

         return description.toString();
     }
 }
