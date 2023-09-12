package org.temkarus0070.t1.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.temkarus0070.t1.models.FrequencyDto;
import org.temkarus0070.t1.service.FrequencyService;

import java.util.Map;

@AllArgsConstructor
@RestController
public class FrequencyController implements FrequencyApi {

    private FrequencyService frequencyService;


    public Map<Character, Integer> getCharsFrequency(FrequencyDto frequencyDto) {
        return frequencyService.getCharacterFrequency(frequencyDto.getStr());
    }
}
