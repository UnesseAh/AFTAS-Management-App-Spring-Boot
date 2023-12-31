package com.example.aftas.controller.vm.Level;

import com.example.aftas.entities.Level;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public record LevelRequestVM(
        @NotNull(message = "Code can't be null")
        Integer code,
        @NotBlank(message = "Description can't be blank")
        @Size(min = 2, max = 255, message = "Description must be between 10 and 20 characters")
        String description,
        @NotNull(message = "Code can't be null")
        Integer points
) {
    public Level toLevel(){
        return  Level.builder()
                .code(code)
                .description(description)
                .points(points)
                .build();
    }
}
