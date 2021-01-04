package com.gsm.jupjup.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TestDomain {
    //Test Data Class
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private String author;

    // 다수의 필드를 가지는 복잡한 클래스의 경우, 생성자 대신에 빌더를 사용하는 경우가 많다
    @Builder
    public TestDomain(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //update문에 사용할 생성자 정의
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}