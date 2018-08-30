package com.mir.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Jobs {
    private static final long ONE_MINUTE = 60 * 1000; // 一分钟

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 从程序启动时间开始，一分钟执行一次
     * 执行结果如下：
     2018-08-30 11:21:45 >>fixedDelay执行....
     2018-08-30 11:22:45 >>fixedDelay执行....
     2018-08-30 11:23:45 >>fixedDelay执行....
     */
    @Scheduled(fixedDelay = ONE_MINUTE)
    public void fixedDelayJob() {
        System.out.println(FORMATTER.format(LocalDateTime.now()) + " >>fixedDelay执行....");
    }

    /**
     * 从程序启动时间开始，一分钟执行一次
     * 执行结果如下：
     2018-08-30 11:21:45 >>fixedRate执行....
     2018-08-30 11:22:45 >>fixedRate执行....
     2018-08-30 11:23:45 >>fixedRate执行....
     */
    @Scheduled(fixedRate = ONE_MINUTE)
    public void fixedRateJob() {
        System.out.println(FORMATTER.format(LocalDateTime.now()) + " >>fixedRate执行....");
    }

    /**
     * 一分钟执行一次
     * 执行结果如下：
     * 2018-08-30 11:22:00 >>cron执行....
     * 2018-08-30 11:23:00 >>cron执行....
     * 2018-08-30 11:24:00 >>cron执行....
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void cronJob() {
        System.out.println(FORMATTER.format(LocalDateTime.now()) + " >>cron执行....");
    }
}
