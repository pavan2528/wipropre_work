package com.example.controller;

import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/tutorials")
@Tag(name = "Tutorial", description = "Tutorial management APIs")
public class TutorialController {

    @PostMapping
    @Operation(summary = "Save a tourist place")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Saved successfully"),
        @ApiResponse(responseCode = "404", description = "Not found")
    })
    public String saveTutorial(@RequestBody String tutorial) {
        return "Saved tutorial: " + tutorial;
    }
}
