package com.gsm.jupjup.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EquipmentDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eq_Idx;

    @Column
    private String name;

    @Column
    @Lob
    private byte[] img_equipment; //BLOB

    @Column
    private String content;

    @Column
    private int count;

    @CreatedDate
    private LocalDateTime create_at_equipment;

    @Builder
    public EquipmentDomain(String name, byte[] img_equipment, String content, int count){
        this.name = name;
        this.img_equipment = img_equipment;
        this.content = content;
        this.count = count;
    }

    public void update(String name, byte[] img_equipment, String content, int count){
        this.name = name;
        this.img_equipment = img_equipment;
        this.content = content;
        this.count = count;
    }
}
