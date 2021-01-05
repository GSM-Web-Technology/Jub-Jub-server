package com.gsm.jupjup.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

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

    @CreatedDate
    private LocalDateTime create_at_equipment;

    @Builder
    public EquipmentDomain(String name, byte[] img_equipment, String content){
        this.name = name;
        this.img_equipment = img_equipment;
        this.content = content;
    }
}
