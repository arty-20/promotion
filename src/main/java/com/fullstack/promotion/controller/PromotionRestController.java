package com.fullstack.promotion.controller;

import com.fullstack.promotion.service.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author arturo
 */
@AllArgsConstructor
@RestController
@RequestMapping("api")
public class PromotionRestController {

    private final PromotionService promotionService;



    @GetMapping("$birthdate")
    public ResponseEntity<?> sendBirthdayMessage(){

        promotionService.sendMail();
        return new ResponseEntity<>("", HttpStatus.OK);
    }
}
