 /*
  * Copyright (c) 2018年12月20日  by XuanWu Wireless Technology Co., Ltd
  *             All rights reserved
  */
 package mydemo.myerrorcontext;

 /**
  * @author <a href="mailto:zhaominglin@wxchina.com">minglin.Zhao</a>
  * @Description 操作入口
  * @Date 2018/12/20
  * @Version 1.0.0
  */
 public class App {

     public static void main(String[] args) {
         DemoService demoService = new DemoService();
//         demoService.doSomeBusiness(10);
         demoService.doSomeBusinessWithContextExchange(10);
     }
 }
