package com.gsm.jupjup.dto.test;

import com.gsm.jupjup.domain.TestDomain;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class TestSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public TestSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //builder를 구현한 객체의 인스턴스 생성
    //toEntity 호출 => TestDomain에 값 넘겨줌
    public TestDomain toEntity(){
        return TestDomain.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
