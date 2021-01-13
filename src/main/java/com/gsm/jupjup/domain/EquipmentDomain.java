package com.gsm.jupjup.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class EquipmentDomain extends BaseTimeEntity{
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
