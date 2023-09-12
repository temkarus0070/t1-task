package org.temkarus0070.t1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.temkarus0070.t1.service.FrequencyService;

import java.util.HashMap;

@SpringBootTest
public class FrequenceServiceTest {
    @Autowired
    private FrequencyService frequencyService;

    @Test
    public void testEmptyStr(){
        Assertions.assertEquals(frequencyService.getCharacterFrequency(""),
                                new HashMap<>());

    }
    @Test
    public void testCyrillicStr(){
       frequencyService.getCharacterFrequency("Спроектировать(продумать формат");

    }
}
