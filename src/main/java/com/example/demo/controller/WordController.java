package com.example.demo.controller;

import com.example.demo.entity.extend.PatientCheckPumchExtend;
import com.example.demo.service.PatientCheckPumchService;
import com.example.demo.utils.FileUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class WordController {


    @Autowired
    private PatientCheckPumchService patientCheckPumchService;

    @Qualifier("freeMarkerConfiguration")
    @Autowired
    private Configuration configuration;

    //批量下载
    @ApiOperation(value = "下载孩子病例文档")

    @RequestMapping(value = "/batchDownload", method = RequestMethod.GET)
    public void batchDownload(@RequestParam  List<String> informationIds,
                              HttpServletRequest request,
                              HttpServletResponse response) throws TemplateException, UnsupportedEncodingException {

	    response.setCharacterEncoding("UTF-8");
	    request.setCharacterEncoding("UTF-8");
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String sb = dateFormat.format(new Date());
        StringBuilder docName = new StringBuilder();
        for (String id : informationIds) {
            docName.append(id);
        }

        try {
            File wordFile = new File("word/");
            if (!wordFile.exists()) {
                wordFile.mkdir();
            }
            File file = new File("word/"+sb);

            List<File> srcfile=new ArrayList<File>();
            for (String id : informationIds) {
                List<PatientCheckPumchExtend> extend = patientCheckPumchService.findByInforId(Long.parseLong(id));
                Map<String, Object> map = new HashMap<>();
                map.put("extend",extend);

                configuration = new Configuration(Configuration.getVersion());
                configuration.setDefaultEncoding("UTF-8");
                configuration.setDirectoryForTemplateLoading( new File("src/main/resources/templates"));
                Template t = configuration.getTemplate("wordSwitch.ftl");

                if (!file.exists()) {
                    file.mkdir();
                }
                String outNewFileName = "word/"+sb + "/" + extend.get(0).getPatientInformationPumchExtend().getOid()+".doc";
                File outNewFile = new File(outNewFileName);
                if (!outNewFile.exists()) {
                    outNewFile.createNewFile();
                }
                PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outNewFile), "UTF-8"));
                t.process(map, out);
                out.flush();
                out.close();
            }

            if (informationIds.size()==1) {
                FileUtils.downFile(response,"word/"+sb+"/", docName+".doc");
            }else {
                File zipFile = new File("word/"+sb+".zip");
                FileUtils.zipFiles("word/"+sb,zipFile);
                FileUtils.downFile(response,"word/", sb+".zip");

            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    //选择模块下载
    @RequestMapping(value = "/choiceCheckPumch" , method = RequestMethod.GET)
    public void choiceCheckPumch(@RequestParam List<String> checkPumchIds,
                                 HttpServletResponse response) throws IOException,TemplateException {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String sb = dateFormat.format(new Date());
            StringBuilder docName = new StringBuilder();
            for (String id : checkPumchIds) {
                docName.append(id);
            }

            File wordFile = new File("word/");
            if (!wordFile.exists()) {
                wordFile.mkdir();
            }
            File file = new File("word/"+sb);

            List<PatientCheckPumchExtend> extend = patientCheckPumchService.findByIds(checkPumchIds);
            Map<String, Object> map = new HashMap<>();
            map.put("extend",extend);

            configuration = new Configuration(Configuration.getVersion());
            configuration.setDefaultEncoding("UTF-8");
            configuration.setDirectoryForTemplateLoading( new File("src/main/resources/templates"));
            Template t = configuration.getTemplate("wordSwitch.ftl");

            if (!file.exists()) {
                file.mkdir();
            }
            String outNewFileName = "word/"+sb + "/" + docName+".doc";
            File outNewFile = new File(outNewFileName);
            if (!outNewFile.exists()) {
                outNewFile.createNewFile();
            }
            out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(outNewFile), "UTF-8"));
            t.process(map, out);

            FileUtils.downFile(response,"word/"+sb+"/", docName+".doc");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (out!=null) {
                out.flush();
                out.close();
            }
        }

    }

    //    @RequestMapping(value = "/", method = RequestMethod.GET)
    //    public String index() {
    //        System.out.println("swagger-ui.html");
    //        return "redirect:swagger-ui.html";
    //    }

    //    @RequestMapping("/writeDoc")
    //    public String writeDoc(@RequestParam String id) throws IOException, TemplateException {
    ////        PatientCheckPumchExtend extend = patientCheckPumchService.findById(Long.parseLong(id));
    //        List<PatientCheckPumchExtend> extend = patientCheckPumchService.findByInforId(Long.parseLong(id));
    //        Map<String, Object> map = new HashMap<>();
    //        map.put("extend",extend);
    //
    //
    //        configuration = new Configuration(Configuration.getVersion());
    //        configuration.setDirectoryForTemplateLoading( new File("src/main/resources/templates"));
    //        Template t = configuration.getTemplate("word.ftl");
    //        File outNewFile = new File("outbox/word.doc");
    //        if (!outNewFile.exists()) {
    //            outNewFile.createNewFile();
    //        }
    //
    //        Writer out = null;
    //        out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outNewFile), "UTF-8"));
    //
    //        t.process(map, out);
    //
    //        out.flush();
    //        out.close();
    //        return "word";
    //    }


        //批量下载
    //    @RequestMapping("/writeDocDownload")
    //    public String download(@RequestParam String informationIds) throws IOException, TemplateException{
    //        String[] ids = informationIds.split(",");
    //        File file = new File(informationIds);
    //        for (String id : ids) {
    //            List<PatientCheckPumchExtend> extend = patientCheckPumchService.findByInforId(Long.parseLong(id));
    //            Map<String, Object> map = new HashMap<>();
    //            map.put("extend",extend);
    //
    //
    //            configuration = new Configuration(Configuration.getVersion());
    //            configuration.setDirectoryForTemplateLoading( new File("src/main/resources/templates"));
    //            Template t = configuration.getTemplate("wordPic.ftl");
    //
    //            if (!file.exists()) {
    //                file.mkdir();
    //            }
    //            File outNewFile = new File(file.getName() + "/" + extend.get(0).getPatientInformationPumchExtend().getOid()+ "_" + extend.get(0).getPatientInformationPumchExtend().getName()+".doc");
    //            if (!outNewFile.exists()) {
    //                outNewFile.createNewFile();
    //            }
    //            Writer out = null;
    //            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outNewFile), "UTF-8"));
    //
    //            t.process(map, out);
    //            out.flush();
    //            out.close();
    //        }
    //        FileUtils.fileToZip(file.getPath(),informationIds);
    //        return "wordPic";
    //    }

        //批量下载返回Word文档
    //    @RequestMapping("/backWord")
    //    public void backWord(@RequestParam String id,
    //                           HttpServletResponse response) throws IOException, TemplateException {
    //        List<PatientCheckPumchExtend> extend = patientCheckPumchService.findByInforId(Long.parseLong(id));
    //        Map<String, Object> map = new HashMap<>();
    //        map.put("extend",extend);
    //
    //
    //        configuration = new Configuration(Configuration.getVersion());
    //        configuration.setDefaultEncoding("UTF-8");
    //        configuration.setDirectoryForTemplateLoading( new File("src/main/resources/templates"));
    //        Template t = configuration.getTemplate("wordPic.ftl");
    //
    //        response.setHeader("content-Type", "application/msword");
    //        String fileName = extend.get(0).getPatientInformationPumchExtend().getOid()+"_"+extend.get(0).getPatientInformationPumchExtend().getName();
    //        fileName = URLEncoder.encode(fileName,"UTF-8");
    //        response.setCharacterEncoding("UTF-8");
    //        response.setHeader("Content-Disposition", "attachment;filename="+fileName+".doc");
    //        PrintWriter writer = new PrintWriter(response.getOutputStream());
    //
    //        t.process(map, writer);
    //        writer.flush();
    //        writer.close();
    //    }
}
