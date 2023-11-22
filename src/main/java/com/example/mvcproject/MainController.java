package com.example.mvcproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MainController {
    @GetMapping("")
    public String index() {
        return "index";
    }

    @GetMapping("time")
    public String time(Model model) {
        String currentTime = LocalDateTime.now().toString();
        model.addAttribute("nowTime", currentTime);
        return "time";
    }

    @GetMapping("info")
    public String info(Model model) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = currentDate.format(formatter);
        model.addAttribute("nowDate", formattedDate);

        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String osArch = System.getProperty("os.arch");
        //String total = String.format("Операционная система: %s \n Версия ОС: %s \n Архитектура: %s", osName, osVersion, osArch);
        model.addAttribute("nowInfoName", osName);
        model.addAttribute("nowInfoVersion", osVersion);
        model.addAttribute("nowInfoArch", osArch);
        return "info";
    }
}
