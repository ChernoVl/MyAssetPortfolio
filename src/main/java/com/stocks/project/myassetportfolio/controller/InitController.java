package com.stocks.project.myassetportfolio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class InitController {

    @GetMapping("/home")
    public String getInput(@RequestParam(required = false) String ticker ,Model model){
        log.info(ticker);
        model.addAttribute("ticker", "ticker" + "##");
        return "homePage";
    }

}
