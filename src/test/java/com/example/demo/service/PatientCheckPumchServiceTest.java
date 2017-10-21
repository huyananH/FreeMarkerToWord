package com.example.demo.service;

import com.example.demo.entity.extend.PatientCheckPumchExtend;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PatientCheckPumchServiceTest {

    @Autowired
    private PatientCheckPumchService patientCheckPumchService;

    @Test
    public void getfindById() {
        List<PatientCheckPumchExtend> extendList = patientCheckPumchService.findByInforId( 53L);

        System.out.println("你猜");
    }
}
