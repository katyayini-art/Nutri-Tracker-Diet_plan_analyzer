package com.nutri.controller;


import org.springframework.web.bind.annotation.*;

import com.nutri.model.NutritionResult;
import com.nutri.model.User;
import com.nutri.service.NutritionService;

@RestController
@RequestMapping("/nutrition")
@CrossOrigin(origins = "*")
public class NutritionController {

    private final NutritionService nutritionService;

    public NutritionController(NutritionService nutritionService) {
        this.nutritionService = nutritionService;
    }
     @GetMapping("/test")
public String test(){
    return "Nutrition Controller Working";
}

    @PostMapping("/calculate")
    public NutritionResult calculate(@RequestBody User user) {
        return nutritionService.calculateAndSave(user);
    }
   
}