 /*
  * Copyright (c) 2018年12月20日  by XuanWu Wireless Technology Co., Ltd
  *             All rights reserved
  */
 package mydemo.myerrorcontext;

 /**
  * @author <a href="mailto:zhaominglin@wxchina.com">minglin.Zhao</a>
  * @Description 我们的ErrorContext是与异常绑定进行输出的，这就意味着我们需要对抛出的异常进行包装，包装中放入我们的异常ErrorContext
  * @Date 2018/12/20
  * @Version 1.0.0
  */
 public class ExceptionFactory {

     /**
      * 包装异常获取异常信息
      */
     public static RuntimeException wrapException(Throwable e) {
         return new RuntimeException(MyErrorContext.getInstance().setCause(e).toString(), e);
     }
 }
