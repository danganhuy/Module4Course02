package huy.module4course02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

@Controller
public class Exercise2 {
    @GetMapping("/world-clock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city) {
        ZoneId localZone = ZoneId.systemDefault();
        ZoneId targetZone = ZoneId.of(city);

        LocalDateTime localDateTime = LocalDateTime.now();

        ZonedDateTime zonedDate = localDateTime.atZone(localZone).withZoneSameInstant(targetZone);
        LocalDateTime date = zonedDate.toLocalDateTime();
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "exercise2/world-clock";
    }
}
