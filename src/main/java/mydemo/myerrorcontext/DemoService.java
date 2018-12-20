 /*
  * Copyright (c) 2018年12月20日  by XuanWu Wireless Technology Co., Ltd
  *             All rights reserved
  */
 package mydemo.myerrorcontext;

 import org.apache.ibatis.executor.ErrorContext;

 /**
  * @author <a href="mailto:zhaominglin@wxchina.com">minglin.Zhao</a>
  * @Description
  * @Date 2018/12/20
  * @Version 1.0.0
  */
 public class DemoService {
     public void doSomeBusiness(Integer id) {

         /** 入口信息 */
         MyErrorContext.getInstance().setClass(this.getClass().getName()).setMethod("doSomeBusiness").setMessage("准备查询数据" + id);

         try {

             /** 模拟异常 */
             Object o = doQuery(id);
             o.toString();

         } catch (Throwable e) {
             throw ExceptionFactory.wrapException(e);
         } finally {
             MyErrorContext.getInstance().clear();
         }
     }

     public void doSomeBusinessWithContextExchange(Integer id) {

         /** 入口信息 */
         MyErrorContext.getInstance().setClass(this.getClass().getName()).setMethod("doSomeBusiness").setMessage("准备查询数据" + id);

         try {

             /** 查询信息 */
             Object result = doQuery(id);

             /** 使用线程去执行一定的业务逻辑*/
             new Thread(new ErrorTraceRunnable(new ServiceRunnable(result))).start();

         } catch (Throwable e) {
             throw ExceptionFactory.wrapException(e);
         } finally {
             MyErrorContext.getInstance().clear();
         }
     }


     private Object doQuery(Integer id) {
         return null;
     }
 }
