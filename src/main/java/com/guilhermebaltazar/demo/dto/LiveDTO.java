package com.guilhermebaltazar.demo.dto;

public class LiveDTO {

    private Long id;
    private String name;

    public LiveDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
