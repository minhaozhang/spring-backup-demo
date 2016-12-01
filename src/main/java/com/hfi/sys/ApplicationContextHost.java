package com.hfi.sys;


import com.hfi.util.StackTraceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationContextHost {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextHost.class);
    static final int sleepScan=1000;
    public static AbstractRefreshableConfigApplicationContext BeanContext = new ClassPathXmlApplicationContext();
    private static String[] locations = { "/spring/ApplicationContext.xml" };

    public static void init() {
        BeanContext.setConfigLocations(locations);
        BeanContext.refresh();
        LOGGER.info("--------Spring start successful!-------");
        try {

            // 文件扫描启动线程
            Thread scanThread = new Thread() {
                public void run() {

                    LOGGER.info("扫描线程启动...");

                    while (true) {

                        // 线程休眠
                        try {
                            LOGGER.info("主线程sleep"+sleepScan/1000+"秒...");
                            sleep(sleepScan);
                        } catch (InterruptedException e) {
                            LOGGER.error(StackTraceUtil.getStackTrace(e));
                        }


                        // 开始比对数据
                    }
                }
            };
            scanThread.setName("scanThread");
            scanThread.start();
        } catch (Exception e) {
            LOGGER.error(StackTraceUtil.getStackTrace(e));
        }
    }

    public static Object getBean(String beanName) {
        return BeanContext.getBean(beanName);
    }
}
