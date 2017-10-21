package com.example.demo.service.impl;

import com.example.demo.entity.PatientCheckPumchEntity;
import com.example.demo.entity.PatientInformationPumchEntity;
import com.example.demo.entity.PictureInformationEntity;
import com.example.demo.entity.RegisterUserEntity;
import com.example.demo.entity.extend.PatientCheckPumchExtend;
import com.example.demo.entity.extend.PatientInformationPumchExtend;
import com.example.demo.entity.extend.RegisterUserExtend;
import com.example.demo.repository.*;
import com.example.demo.service.PatientCheckPumchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(PatientCheckPumchService.SERVER_NAME)
public class PatientCheckPumchServiceImpl implements PatientCheckPumchService {

    @Autowired
    private PatientInformationPumchRepository patientInformationPumchRepository;

    @Autowired
    private PictrueInformationRepository pictrueInformationRepository;

    @Autowired
    private PatientCheckPumchRepository patientCheckPumchRepository;

    @Autowired
    private RegisterUserRepository registerUserRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public List<PatientCheckPumchExtend> findByInforId(Long patientInformationPumchId) {
        List<PatientCheckPumchEntity> pcpList = patientCheckPumchRepository.findByPatientInformationPumchId(patientInformationPumchId);
        List<PatientCheckPumchExtend> list = new ArrayList<>();
        if (pcpList != null) {
            for (PatientCheckPumchEntity pcpEntity : pcpList) {
                PatientCheckPumchExtend pcpExtend = new PatientCheckPumchExtend();

                pcpExtend.getExtendFromEntity(pcpEntity, pcpExtend);

                PatientInformationPumchEntity pipEntity = patientInformationPumchRepository.findOne(pcpEntity.getPatientInformationPumchId());
                PatientInformationPumchExtend pipExtend = new PatientInformationPumchExtend();
                pipExtend.getExtendFromEntity(pipEntity, pipExtend);

                if (null != pipEntity.getCreateRegisterUserId() || !pipEntity.getCreateRegisterUserId().equals("")) {
                    RegisterUserEntity ruEntity = registerUserRepository.findOne(pipEntity.getCreateRegisterUserId());
                    RegisterUserExtend ruExtend = new RegisterUserExtend();
                    ruExtend.getExtendFromEntity(ruEntity, ruExtend);
                    ruExtend.setUserOrganization(organizationRepository.findOne(ruEntity.getUserOrganizationId()));
//                pipExtend.setCreateRegisterUser(registerUserRepository.findOne(pipEntity.getCreateRegisterUserId()));
                    pipExtend.setCreateRegisterUser(ruExtend);
                }
                pcpExtend.setPatientInformationPumchExtend(pipExtend);

                if (null != pcpEntity.getCreateRegisterUserId() || !pcpEntity.getCreateRegisterUserId().equals("")) {
                    RegisterUserEntity pcruEntity = registerUserRepository.findOne(pcpEntity.getCreateRegisterUserId());
                    RegisterUserExtend pcruExtend = new RegisterUserExtend();
                    pcruExtend.getExtendFromEntity(pcruEntity, pcruExtend);
                    pcruExtend.setUserOrganization(organizationRepository.findOne(pcruEntity.getUserOrganizationId()));
                    pcpExtend.setCreateRegisterUser(pcruExtend);
                }

                if (null != pcpEntity.getPictureIds()) {
                    String[] picIds = pcpEntity.getPictureIds().split(",");
                    List<PictureInformationEntity> piList = new ArrayList<>();
                    for (String picId : picIds) {
                        PictureInformationEntity piEntity = pictrueInformationRepository.findOne(Long.parseLong(picId));
                        String picName = piEntity.getPictureFileName();
                        String picFileName = "https://distribution.th-ehealth.org/medical-camera/picture/original/"+picName;
                        piEntity.setPictureFileName(picFileName);
                        piList.add(piEntity);
                    }
                    pcpExtend.setPictures(piList);
                }

                list.add(pcpExtend);
            }
            return list;
        }else {
            return null;
        }

    }

    //通过检验单号查询检验单
    @Override
    public List<PatientCheckPumchExtend> findByIds(List<String> ids) {
        List<PatientCheckPumchExtend> list = new ArrayList<>();
        PatientCheckPumchEntity pcpEntity = null;
        PatientCheckPumchExtend pcpExtend = null;
        PatientInformationPumchEntity pipEntity = null;
        PatientInformationPumchExtend pipExtend = null;
        RegisterUserEntity ruEntity = null;
        RegisterUserExtend ruExtend = null;
        PictureInformationEntity piEntity = null;
        List<PictureInformationEntity> piList = null;
        for (String id : ids) {
            pcpEntity = patientCheckPumchRepository.findOne(Long.parseLong(id));
            pcpExtend = new PatientCheckPumchExtend();
            pcpExtend.getExtendFromEntity(pcpEntity, pcpExtend);

            //孩子信息放入检验单中
            pipEntity = patientInformationPumchRepository.findOne(pcpEntity.getPatientInformationPumchId());
            pipExtend = new PatientInformationPumchExtend();
            pipExtend.getExtendFromEntity(pipEntity,pipExtend);

            if (null != pipEntity.getCreateRegisterUserId() || !pipEntity.getCreateRegisterUserId().equals("")) {
                //把创建者放入孩子的信息中
                ruEntity = registerUserRepository.findOne(pipEntity.getCreateRegisterUserId());
                ruExtend = new RegisterUserExtend();
                ruExtend.getExtendFromEntity(ruEntity, ruExtend);
                ruExtend.setUserOrganization(organizationRepository.findOne(ruEntity.getUserOrganizationId()));
                pipExtend.setCreateRegisterUser(ruExtend);
            }
            pcpExtend.setPatientInformationPumchExtend(pipExtend);

            //把图片信息放入检验单中
            if (null != pcpEntity.getPictureIds()) {
                String[] picIds = pcpEntity.getPictureIds().split(",");
                piList = new ArrayList<>();
                for (String picId : picIds) {

                    piEntity = pictrueInformationRepository.findOne(Long.parseLong(picId));
                    String picName = piEntity.getPictureFileName();
                    String picFileName = "https://distribution.th-ehealth.org/medical-camera/picture/original/"+picName;
                    piEntity.setPictureFileName(picFileName);
                    piList.add(piEntity);
                }
                pcpExtend.setPictures(piList);
            }

            if (null != pcpEntity.getCreateRegisterUserId() || !pcpEntity.getCreateRegisterUserId().equals("")) {
                //把创建者放入检验报告单
                ruEntity = registerUserRepository.findOne(pcpEntity.getCreateRegisterUserId());
                ruExtend = new RegisterUserExtend();
                ruExtend.getExtendFromEntity(ruEntity, ruExtend);
                ruExtend.setUserOrganization(organizationRepository.findOne(ruEntity.getUserOrganizationId()));
                pcpExtend.setCreateRegisterUser(ruExtend);
            }
            list.add(pcpExtend);
        }


        return list;
    }
}
