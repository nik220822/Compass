package com.nicode.cardinaldirections.controller;

import com.nicode.cardinaldirections.model.Compass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Controller {

    @PostMapping(value = "/span", consumes = "application/json")
    public static void setSpan(@RequestBody Map<String, String> map) {
        Compass.getInstance().setCompassMap(map);
    }

    @PostMapping(value = "/dir", consumes = "application/json", produces = "application/json")
    public static Map<String, String> analizeDirection(@RequestBody Map<String, String> map) {
        String side = Compass.getInstance().getSide(map.get("Degree"));
        return Map.of("Side", side);
    }
}
