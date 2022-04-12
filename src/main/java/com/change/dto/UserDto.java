package com.change.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String name;
    private long id;

    public UserDto(String name) {
        this.name = name;
    }

    public UserDto() {

    }

    public Long getId() {
        return this.id;
    }
}
