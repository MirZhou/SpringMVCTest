package com.mir.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Jobs {
    private static final long ONE_MINUTE = 60 * 1000; // 一分钟

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedDelay = ONE_MINUTE)
    public void fixedDelayJob() {
        System.out.println(FORMATTER.format(LocalDateTime.now()) + " >>fixedDelay执行....");
    }

    @Scheduled(fixedRate = ONE_MINUTE)
    public void fixedRateJob() {
        System.out.println(FORMATTER.format(LocalDateTime.now()) + " >>fixedRate执行....");
    }

    @Scheduled(cron = "0 30 * * * ?")
    public void cronJob() {
        System.out.println(FORMATTER.format(LocalDateTime.now()) + " >>cron执行....");
    }
}
