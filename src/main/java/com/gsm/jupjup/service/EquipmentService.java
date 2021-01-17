package com.gsm.jupjup.service;

import com.gsm.jupjup.dao.EquipmentRepository;
import com.gsm.jupjup.domain.EquipmentDomain;
import com.gsm.jupjup.dto.Equipment.EquipmentRequestDto;
import com.gsm.jupjup.dto.Equipment.EquipmentUploadDto;
import com.gsm.jupjup.dto.Equipment.EquipmentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class EquipmentService {
    @Autowired
    EquipmentRepository equipmentRepo;

    @Transactional
    public void save(EquipmentUploadDto equipmentUploadDto) throws IOException {
        MultipartFile img_equipment = equipmentUploadDto.getImg_equipment();
        byte[] conversionImg_equipment = img_equipment.getBytes();

        EquipmentRequestDto equipmentRequestDto =
                EquipmentRequestDto.builder()
                        .img_equipment(conversionImg_equipment)
                        .content(equipmentUploadDto.getContent())
                        .name(equipmentUploadDto.getName())
                        .count(equipmentUploadDto.getCount())
                        .build();

        EquipmentDomain equipmentDomain = equipmentRequestDto.toEntity();
        equipmentRepo.save(equipmentDomain);
    }

    @Transactional
    public Long update(String name, EquipmentRequestDto equipmentRequestDto){
        EquipmentDomain equipmentDomain = equipmentRepo.findByName(name).orElseThrow(() -> new IllegalArgumentException("해당 기자재는 없습니다. name="+name));
        equipmentDomain.update(equipmentRequestDto.getName(), equipmentRequestDto.getImg_equipment(), equipmentRequestDto.getContent(), equipmentRequestDto.getCount());
        return equipmentDomain.getEq_Idx();
    };

    @Transactional
    public String updateAmount(String name, int count){
        EquipmentDomain equipmentDomain = equipmentRepo.findByName(name).orElseThrow(() -> new IllegalArgumentException("해당 기자재는 없습니다. name="+name));
        equipmentDomain.updateCount(count);
        equipmentRepo.save(equipmentDomain);
        return equipmentDomain.getName();
    }

    @Transactional
    public void deleteByName(String name){
        EquipmentDomain equipmentDomain = equipmentRepo.findByName(name).orElseThrow(() -> new IllegalArgumentException("해당 기자재는 없습니다. name="+name));
        equipmentRepo.delete(equipmentDomain);
    }

    @Transactional
    public byte[] findByNameGetEquipment_img(String name){
        return equipmentRepo.findByName(name).orElseThrow(() -> new IllegalArgumentException("해당 기자재는 없습니다. name="+name)).getImg_equipment();
    }

    @Transactional(readOnly = true)
    public EquipmentResponseDto findByName(String name){
        EquipmentDomain equipmentDomain = equipmentRepo.findByName(name).orElseThrow(() -> new IllegalArgumentException("해당 기자재는 없습니다. name="+name));
        return new EquipmentResponseDto(equipmentDomain);
    }

//    @Transactional(readOnly = true)
//    public BufferedImage findByName(String name) throws IOException {
//        EquipmentDomain equipmentDomain = equipmentRepo.findByName(name).orElseThrow(() -> new IllegalArgumentException("해당 기자재는 없습니다. name="+name));
//        BufferedImage equipment_img = null;
//        ByteArrayInputStream bis = new ByteArrayInputStream(equipmentDomain.getImg_equipment());
//        equipment_img = ImageIO.read(bis);
//        bis.close();
//
//        return equipment_img;
//    }

}
