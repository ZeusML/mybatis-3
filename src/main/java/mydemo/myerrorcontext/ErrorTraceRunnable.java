 /*
  * Copyright (c) 2018年12月20日  by XuanWu Wireless Technology Co., Ltd
  *             All rights reserved
  */
 package mydemo.myerrorcontext;


 import java.util.Objects;

 /**
  * @author <a href="mailto:zhaominglin@wxchina.com">minglin.Zhao</a>
  * @Description 错误追踪运行类
  * @Date 2018/12/20
  * @Version 1.0.0
  */
 public class ErrorTraceRunnable implements Runnable{

     private final Runnable runnable;
     private final MyErrorContext errorContext;

     public ErrorTraceRunnable(Runnable runnable) {

         /** 完成线程切换 */
         this.errorContext = MyErrorContext.getInstance().deepCopy();
         this.runnable = runnable;
     }

     @Override
     public void run() {

         if (Objects.nonNull(errorContext)) {
             MyErrorContext.getInstance().setErrorContext(errorContext);
         }

         runnable.run();
     }

 }
