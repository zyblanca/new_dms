package com.example.dms;

import javafx.application.Application;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.Buffer;
import java.security.Principal;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class DmsApplicationTests {

    @Test
    void contextLoads() throws IOException {
        File file = new File("C:\\Users\\zhouy\\Desktop\\IO.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[1024];
        int len = 0;
        while ((len = fis.read(data)) != -1){
            System.out.println(Arrays.toString(data));
        }
        fis.close();
    }

    @Test
    void outPutStream() throws IOException {
        File file = new File("C:\\Users\\zhouy\\Desktop\\IO.txt");
        OutputStream fis = new FileOutputStream(file,true);
        fis.write("策划思路的方式".getBytes("UTF-8"));
        fis.flush();
        fis.close();
    }

    @Test
    void copy() throws IOException {
        File file = new File("C:\\Users\\zhouy\\Desktop\\IO.txt");
        InputStream is = new FileInputStream(file);
        File file1 = new File("C:\\Users\\zhouy\\Desktop\\good.txt");
        OutputStream fis = new FileOutputStream(file1,true);
        byte[] data = new byte[1024];
        int len = 0;
        while ((len = is.read(data)) !=-1){
           fis.write(data);
        }
        is.close();

        fis.flush();
        fis.close();
    }

    @Test
    void writer() throws IOException {
        File file = new File("C:\\Users\\zhouy\\Desktop\\IO.txt");
        Writer writer = new FileWriter(file);
        writer.append("老师的分类算法\n");
        writer.write("十六点三零点\n");
        writer.write("四点零四".toCharArray());
        writer.write("\n");
        writer.write("十六点三零点".toCharArray(),0,3);
        writer.write("\n");
        writer.append("sldsl", 0, 2);
        writer.flush();
        writer.close();
    }

    @Test
    void reader() throws IOException {
        File file = new File("C:\\Users\\zhouy\\Desktop\\IO.txt");
        Reader writer = new FileReader(file);
        int g = -1;
        while ((g = writer.read()) != -1){
            System.out.println(g);
        }

        char[] data = new char[1024];
        int len = 0;
        while ((len = writer.read(data)) != -1){
            System.out.println(len);
            System.out.println(new String(data,0,len));
        }
        while ((len = writer.read(data,0,2)) != -1){
            System.out.println(len);
            System.out.println(new String(data,0,len));
        }
        writer.close();
    }
    @Test
    void stringCopy() throws IOException {
        File file = new File("C:\\Users\\zhouy\\Desktop\\IO.txt");
        File file1 = new File("C:\\Users\\zhouy\\Desktop\\string.txt");
        Reader writer = new FileReader(file);
        Writer out = new FileWriter(file1);
        char[] data = new char[1024];
        int len = 0;
        while ((len = writer.read(data)) != -1){
            out.write(data,0,len);
        }
        out.flush();
        writer.close();
        out.close();
    }

    @Test
    void bufferByte() throws IOException {
        File file = new File("C:\\Users\\zhouy\\Desktop\\IO.txt");
        BufferedInputStream bs = new BufferedInputStream(new FileInputStream(file));

        byte[] data = new byte[1024];
        int len = 0;
        while ((len = bs.read(data)) != -1){
            System.out.println(Arrays.toString(data));
        }
        bs.close();

        File out = new File("C:\\Users\\zhouy\\Desktop\\outBuffer.txt");
        OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(file));
        os.write("十六点十六分\n");
        os.append("老师的分类算法\n");
        os.write("十六点零四",0,5);
        os.write("\n");
        os.write(String.valueOf("六十多岁了".getBytes("UTF-8")),1,3);
        os.flush();
        os.close();
    }

    @Test
    void bufferChar() throws IOException {
        File file = new File("C:\\Users\\zhouy\\Desktop\\IO.txt");
        BufferedReader bs = new BufferedReader(new FileReader(file));
        File out = new File("C:\\Users\\zhouy\\Desktop\\bufferOut.txt");
        BufferedWriter bf = new BufferedWriter(new FileWriter(out));
        bf.write("sdlsd");
        bf.newLine();
        bf.write("sldksld");
        bf.flush();
        bf.close();
    }

    @Test
    void byteArray() throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();

        ByteArrayInputStream bi = new ByteArrayInputStream("算了算了".getBytes() );
        byte[] data = new byte[1024];
        int len = 0;
        while ((len = bi.read(data))!= -1){
            System.out.println(new String(data,0,len));
            bo.write(data);
        }
    }

}
