package org.temkarus0070.t1.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FrequencyService {

    public Map<Character, Integer> getCharacterFrequency(String str) {
        return str.chars()
                  .mapToObj(e -> (char) e)
                  .collect(Collectors.<Character, Character, Integer>toMap(e -> e, e -> 1, Integer::sum))
                  .entrySet()
                  .stream()
                  .sorted(Map.Entry.<Character, Integer>comparingByValue()
                                   .reversed())
                  .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum, LinkedHashMap::new));
    }
}
