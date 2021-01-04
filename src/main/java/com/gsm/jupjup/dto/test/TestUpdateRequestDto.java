package com.gsm.jupjup.dto.test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TestUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public TestUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
