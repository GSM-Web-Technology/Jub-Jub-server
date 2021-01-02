package com.gsm.jupjup.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TestDTO {

    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    //안녕

}
