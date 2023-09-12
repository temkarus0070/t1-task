package org.temkarus0070.t1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.temkarus0070.t1.service.FrequencyService;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class FrequenceServiceTest {

    @Autowired
    private FrequencyService frequencyService;

    @Test
    public void testEmptyStr() {
        Assertions.assertEquals(frequencyService.getCharacterFrequency(""), new HashMap<>());

    }

    @Test
    public void testCyrillicStrCharsSortedAndHasCorrectFrequences() {
        Map<Character, Integer> characterFrequency = frequencyService.getCharacterFrequency("вам приглашение к нам");
        Object[] array = characterFrequency.entrySet()
                                           .toArray();
        Map<Character, Integer> result = new HashMap<>();
        result.putAll(Map.of('в', 1, 'а', 3, 'м', 2, 'п', 1, 'р', 1, 'и', 2, 'г', 1));
        result.putAll(Map.of('л', 1, 'ш', 1, 'е', 2, 'н', 2, 'к', 1, ' ', 3));
        for (int i = 0; i < array.length - 1; i++) {
            Map.Entry<Character, Integer> prev = (Map.Entry<Character, Integer>) array[i];
            Map.Entry<Character, Integer> next = (Map.Entry<Character, Integer>) array[i + 1];

            Assertions.assertTrue(prev.getValue() >= next.getValue());
        }
        for (int i = 0; i < array.length; i++) {
            Map.Entry<Character, Integer> current = (Map.Entry<Character, Integer>) array[i];
            Assertions.assertEquals(result.get(current.getKey()), current.getValue());
            result.remove(current.getKey());
        }

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void testLatinStrCharsSortedAndHasCorrectFrequences() {
        Map<Character, Integer> characterFrequency = frequencyService.getCharacterFrequency("we have new guide to you");
        Object[] array = characterFrequency.entrySet()
                                           .toArray();
        Map<Character, Integer> result = new HashMap<>();
        result.putAll(Map.of('w', 2, 'e', 4, 'h', 1, 'a', 1, 'v', 1, 'n', 1, 'g', 1));
        result.putAll(Map.of('u', 2, 'i', 1, 'd', 1, 't', 1, 'o', 2, 'y', 1, ' ', 5));
        for (int i = 0; i < array.length - 1; i++) {
            Map.Entry<Character, Integer> prev = (Map.Entry<Character, Integer>) array[i];
            Map.Entry<Character, Integer> next = (Map.Entry<Character, Integer>) array[i + 1];

            Assertions.assertTrue(prev.getValue() >= next.getValue());
        }
        for (int i = 0; i < array.length; i++) {
            Map.Entry<Character, Integer> current = (Map.Entry<Character, Integer>) array[i];
            Assertions.assertEquals(result.get(current.getKey()), current.getValue());
            result.remove(current.getKey());
        }

        Assertions.assertTrue(result.isEmpty());
    }
}
