package com.hoangducduy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/clock")
    public ModelAndView showClock(@RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city){
        // Get current time at local
        Date date = new Date();
        // Get timezone by the local
        TimeZone local = TimeZone.getDefault();
        // Get timezone by the specified city
        TimeZone locale = TimeZone.getTimeZone(city);
        // Calculate the current time in the specified city
        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        // Reset the date by locale_time
        date.setTime(locale_time);

        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("date", date);
        return modelAndView;
    }

}