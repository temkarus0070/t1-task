package org.temkarus0070.t1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.temkarus0070.t1.models.FrequencyDto;

import java.util.Map;

public interface FrequencyApi {


    @PostMapping
    @Operation(description = "Вычисление частоты символов в тексте",
               responses = {@ApiResponse(responseCode = "200", content = @Content(examples = {@ExampleObject(value = """
                                                                                                                     {
                                                                                                                     "a": 2,
                                                                                                                     "b": 1
                                                                                                                     }
                                                                                                                     """)},
                                                                                  schema = @Schema(example = """
                                                                                                             {"a": 2,
                                                                                                             "b: 1}
                                                                                                             """))),
                   @ApiResponse(responseCode = "400", content = @Content(examples = @ExampleObject(value = """
                                                                                                           {"timestamp": "2023-09-12T19:05:23.748+00:00",
                                                                                                                                                  "status": 400,
                                                                                                                                                  "error": "Bad Request",
                                                                                                                                                  "path": "/"}
                                                                                                                       """),
                                                                         schema = @Schema(example = """
                                                                                                    {"timestamp": "2023-09-12T19:05:23.748+00:00",
                                                                                                                                           "status": 400,
                                                                                                                                           "error": "Bad Request",
                                                                                                                                           "path": "/"}
                                                                                                                """)),
                                description = "Ошибка при вводе данных")})
    Map<Character, Integer> getCharsFrequency(@RequestBody @Valid FrequencyDto frequencyDto);
}


