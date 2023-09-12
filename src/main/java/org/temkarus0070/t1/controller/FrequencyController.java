package org.temkarus0070.t1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.temkarus0070.t1.service.FrequencyService;

import java.util.Map;

@RestController
@AllArgsConstructor
public class FrequencyController {

    private FrequencyService frequencyService;

    @PostMapping
    public Map<Character, Integer> getCharsFrequency(@RequestBody String str) {
        return frequencyService.getCharacterFrequency(str);
    }
}
