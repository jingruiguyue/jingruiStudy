package com.test.study.main.test;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @PACKAGE_NAME: com.test.study.main.test
 * @USER: xujingrui3
 * @DATE: 2020/1/4
 **/
public class TestJavaChangeHtml {

    public static void main(String[] args) {
        File fin = new File("D:\\MarkingCode\\yoda-mms\\yoda-mms-manage\\src\\main\\resources\\email\\TaskCreate.html");
        System.out.println("文件内容"+ fin);
        try (RandomAccessFile accessFile = new RandomAccessFile(fin, "r");
             FileChannel fcin = accessFile.getChannel()
        ){
            Charset charset = StandardCharsets.UTF_8;
            int bufSize = 100000;
            ByteBuffer rBuffer = ByteBuffer.allocate(bufSize);
            String enterStr = "\n";
            byte[] bs = new byte[bufSize];
            StringBuilder strline = new StringBuilder();
            StringBuilder strBuf = new StringBuilder();
            while (fcin.read(rBuffer) != -1) {
                int rSize = rBuffer.position();
                rBuffer.rewind();
                rBuffer.get(bs);
                rBuffer.clear();
                String tempString = new String(bs, 0, rSize,charset);
                tempString = tempString.replaceAll("\r", "");

                int fromIndex = 0;
                int endIndex = 0;
                while ((endIndex = tempString.indexOf(enterStr, fromIndex)) != -1) {
                    String line = tempString.substring(fromIndex, endIndex);
                    line = strBuf + line;
                    strline.append(line.trim());

                    strBuf.delete(0, strBuf.length());
                    fromIndex = endIndex + 1;
                }
                if (rSize > tempString.length()) {
                    strline.append(tempString.substring(fromIndex));
                    strBuf.append(tempString.substring(fromIndex));
                } else {
                    strline.append(tempString, fromIndex, rSize);
                    strBuf.append(tempString, fromIndex, rSize);
                }
            }
            System.out.println("转换结果"+ strline);
        } catch (Exception e) {

        }
    }
}
