package com.saadeh.send_book_email_sb.config;

import com.saadeh.send_book_email_sb.job.SendBookLoanNotificationScheduleJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail quartzJobDetail() {
        return JobBuilder.newJob(SendBookLoanNotificationScheduleJob.class).storeDurably().build();
    }

    @Bean
    public Trigger jobTrigger() {
        String exp = "0 31 15 * * ?";
        return TriggerBuilder
                .newTrigger()
                .forJob(quartzJobDetail())
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule(exp))
                .build();
    }
}
