package com.stocks.project.myassetportfolio.controller;

import com.stocks.project.myassetportfolio.service.impl.StockActuatorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/v1/stockActuator")
public class StockActuatorController {
  final private StockActuatorService stockActuatorService;

}
