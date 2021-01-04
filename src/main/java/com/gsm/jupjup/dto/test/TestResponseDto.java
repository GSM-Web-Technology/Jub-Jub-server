package com.gsm.jupjup.dto.test;

import com.gsm.jupjup.domain.TestDomain;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
//게시물 1개 불러오기 DTO
public class TestResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;


    // 다수의 필드를 가지는 복잡한 클래스의 경우, 생성자 대신에 빌더를 사용하는 경우가 많다
    @Builder
    public TestResponseDto(TestDomain entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

}
