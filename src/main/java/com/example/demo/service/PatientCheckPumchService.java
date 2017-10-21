package com.example.demo.service;

import com.example.demo.entity.extend.PatientCheckPumchExtend;

import java.util.List;

public interface PatientCheckPumchService {
    public static final String SERVER_NAME = "com.example.demo.service.impl.PatientCheckPumchServiceImpl";

    public List<PatientCheckPumchExtend> findByIds(List<String> ids);

    public List<PatientCheckPumchExtend> findByInforId(Long patientInformationPumchId);
}
