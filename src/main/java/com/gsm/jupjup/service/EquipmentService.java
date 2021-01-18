package com.gsm.jupjup.service;

import com.gsm.jupjup.dao.EquipmentRepository;
import com.gsm.jupjup.domain.EquipmentDomain;
import com.gsm.jupjup.dto.Equipment.EquipmentReqDto;
import com.gsm.jupjup.dto.Equipment.EquipmentUploadDto;
import com.gsm.jupjup.dto.Equipment.EquipmentResDto;
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
        byte[] img_equipmentToByte = img_equipment.getBytes();

        EquipmentReqDto equipmentReqDto =
                EquipmentReqDto.builder()
                        .img_equipment(img_equipmentToByte)
                        .content(equipmentUploadDto.getContent())
                        .name(equipmentUploadDto.getName())
                        .count(equipmentUploadDto.getCount())
                        .build();

        EquipmentDomain equipmentDomain = equipmentReqDto.toEntity();
        equipmentRepo.save(equipmentDomain);
    }

    @Transactional
    public Long update(String name, EquipmentReqDto equipmentReqDto){
        EquipmentDomain equipmentDomain = equipmentFindByName(equipmentRepo, name);
        equipmentDomain.update(equipmentReqDto);
        return equipmentDomain.getEq_Idx();
    };

    @Transactional
    public String updateAmount(String name, int count){
        EquipmentDomain equipmentDomain = equipmentFindByName(equipmentRepo, name);
        equipmentDomain.updateCount(count);
        equipmentRepo.save(equipmentDomain);
        return equipmentDomain.getName();
    }

    @Transactional
    public void deleteByName(String name){
        EquipmentDomain equipmentDomain = equipmentFindByName(equipmentRepo, name);
        equipmentRepo.delete(equipmentDomain);
    }

    @Transactional
    public byte[] findByNameGetEquipment_img(String name){
        return equipmentFindByName(equipmentRepo, name).getImg_equipment();
    }

    @Transactional(readOnly = true)
    public EquipmentResDto findByName(String name){
        EquipmentDomain equipmentDomain = equipmentFindByName(equipmentRepo, name);
        return new EquipmentResDto(equipmentDomain);
    }

    //Equipment를 name으로 찾고 Entity만드는 매서드
    @Transactional
    public EquipmentDomain equipmentFindByName(EquipmentRepository equipmentRepo, String name){
        return equipmentRepo.findByName(name).orElseThrow(()-> new IllegalArgumentException("해당 기자제는 없습니다. name="+name));
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
