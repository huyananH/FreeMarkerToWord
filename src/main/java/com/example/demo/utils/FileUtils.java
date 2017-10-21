package com.example.demo.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileUtils {

    //压缩文件
    public static boolean fileToZip(String sourceFilePath ,String fileName){
        boolean flag = false;
        File sourceFile = new File(sourceFilePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        ZipOutputStream zos = null;

        if(sourceFile.exists() == false){
            System.out.println("待压缩的文件目录："+sourceFilePath+"不存在.");
        }else{
            try {
                File zipFile = new File( fileName +".zip");
                if(zipFile.exists()){
                    System.out.println("根目录下存在名字为:" + fileName +".zip" +"打包文件.");
                }else{
                    File[] sourceFiles = sourceFile.listFiles();
                    if(sourceFiles == null || sourceFiles.length<1) {
                        System.out.println("待压缩的文件目录：" + sourceFilePath + "里面不存在文件，无需压缩.");
                    }else{
                        fos = new FileOutputStream(zipFile);
                        zos = new ZipOutputStream(new BufferedOutputStream(fos));
                        byte[] bufs = new byte[1024*10];
                        for(int i=0;i<sourceFiles.length;i++){
                            //创建ZIP实体，并添加进压缩包
                            ZipEntry zipEntry = new ZipEntry(sourceFiles[i].getName());
                            zos.putNextEntry(zipEntry);
                            //读取待压缩的文件并写进压缩包里
                            fis = new FileInputStream(sourceFiles[i]);
                            bis = new BufferedInputStream(fis, 1024*10);
                            int read = 0;
                            while((read=bis.read(bufs, 0, 1024*10)) != -1){
                                zos.write(bufs,0,read);
                            }
                        }
                        flag = true;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally{
                //关闭流
                try {
                    if(bis != null) bis.close();
                    if(zos != null) zos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

    //解压文件
    public boolean decompression(String zipFilePath, String savePath) throws IOException {
        boolean flag = true;
        ZipInputStream zin = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        FileOutputStream out = null;
        try {
            //读入zip文件
            zin = new ZipInputStream(new FileInputStream(new File(zipFilePath)));
            bis = new BufferedInputStream(zin);

            //创建ZipEntry实体
            ZipEntry zipEntry;
            //解压后的文件
            File decomFile = null;

            //如果zipEntry存在
            while ((zipEntry = zin.getNextEntry()) != null && !zipEntry.isDirectory()) {
                decomFile = new File( savePath, zipEntry.getName() );
                if(!decomFile.exists()){
//                    (new File(decomFile.getParent())).mkdirs();
                    decomFile.createNewFile();
                }
                out=new FileOutputStream(decomFile);
                bos=new BufferedOutputStream(out);
                int b;
                while((b=bis.read())!=-1){
                    bos.write(b);
                }
                bos.close();
                out.close();
                System.out.println(decomFile+"解压成功");

            }


        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (zin != null) {
                zin.close();
            }
            if (bis != null) {
                bis.close();
            }
            if (bos != null) {
                bos.close();
            }
            if (out != null) {
                out.close();
            }
        }
        return flag;
    }


    public static void zipFiles(String sourceFilesPath, File zipfile) {
        File sourceFile = new File(sourceFilesPath);
        File[] srcfiles = sourceFile.listFiles();
        List<File> srcfile = new ArrayList<File>();
        Collections.addAll(srcfile, srcfiles);
//        File[] sourceFiles = sourceFile.listFiles();
        byte[] buf = new byte[1024];
        try {
            // Create the ZIP file
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
            // Compress the files
            for (int i = 0; i < srcfile.size(); i++) {
                File file = srcfile.get(i);
                FileInputStream in = new FileInputStream(file);
                // Add ZIP entry to output stream.
                out.putNextEntry(new ZipEntry(file.getName()));
                // Transfer bytes from the file to the ZIP file
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                // Complete the entry
                out.closeEntry();
                in.close();
            }
            // Complete the ZIP file
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downFile(HttpServletResponse response, String serverPath, String str) {
        try {
            String path = serverPath + str;
            File file = new File(path);
            if (file.exists()) {
                InputStream ins = new FileInputStream(file);
                BufferedInputStream bins = new BufferedInputStream(ins);// 放到缓冲流里面
                OutputStream outs = response.getOutputStream();// 获取文件输出IO流
                BufferedOutputStream bouts = new BufferedOutputStream(outs);
                response.setContentType("application/x-download");// 设置response内容的类型
                response.setHeader("Content-disposition","attachment;filename="+str);// 设置头部信息
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                //开始向网络传输文件流
                while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
                    bouts.write(buffer, 0, bytesRead);
                }
                bouts.flush();// 这里一定要调用flush()方法
                ins.close();
                bins.close();
                outs.close();
                bouts.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
