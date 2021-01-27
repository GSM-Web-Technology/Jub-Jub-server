package com.gsm.jupjup.domain;

import com.gsm.jupjup.dto.Equipment.EquipmentReqDto;
import lombok.*;

import javax.persistence.*;

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

    public void update(EquipmentReqDto equipmentReqDto){
        this.name = equipmentReqDto.getName();
        this.img_equipment = equipmentReqDto.getImg_equipment();
        this.content = equipmentReqDto.getContent();;
        this.count = equipmentReqDto.getCount();
    }

    public void updateCount(int Count){
        this.count = Count;
    }
}
