package com.example.demo.repository;

import com.example.demo.entity.PatientCheckPumchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientCheckPumchRepository extends JpaRepository<PatientCheckPumchEntity, Long> {

    public List<PatientCheckPumchEntity> findByPatientInformationPumchId(Long patientInformationPumchId);
}
