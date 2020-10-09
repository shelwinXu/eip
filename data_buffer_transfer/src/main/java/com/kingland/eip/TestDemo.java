package com.kingland.eip;

import com.kingland.eip.common.buffer.DataBuffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

public class TestDemo {
    public static void main(String[] args) throws Exception {

        /*RandomAccessFile aFile = new RandomAccessFile("buffer_data_transfer/src/main/resources/Files/dataSource.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        //create buffer with capacity of 1024 bytes
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //read into buffer.
        int bytesRead = inChannel.write(buf);
        while (bytesRead != -1) {
            //make buffer ready for read
            buf.flip();
            while(buf.hasRemaining()){
                // read 1 byte at a time
                System.out.print((char) buf.get());
            }
            //make buffer ready for writing
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();*/

        //String path = "buffer_data_transfer/src/main/resources/Files/designation.txt";
        String path = "buffer_data_transfer/src/main/resources/Files/dataSource.txt";
        //readFile(path);
        List<String> testlist = getStrings();

        DataBuffer dataBuffer = new DataBuffer(2);
        dataBuffer.enqueue(testlist);
        //List dequeue = dataBuffer.dequeue(1);

        System.out.println("test buffer");

    }

    private static List<String> getStrings() {
        List<String> testlist = new ArrayList<>();
        testlist.add("1");
        testlist.add("2");
        testlist.add("3");
        testlist.add("4");
        testlist.add("5");
        testlist.add("6");
        testlist.add("7");
        testlist.add("8");
        testlist.add("9");
        testlist.add("10");
        return testlist;
    }


    public static void readFile(String path) {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile(path, "rw");
            FileChannel fileChannel = file.getChannel(); //获取文件通道
            ByteBuffer buf = ByteBuffer.allocate(1024); //分配容积为2字节的一块Buffer，用来读取数据
            int bytesRead = fileChannel.read(buf); //从通道里读取数据到Buffer内（最大不超过Buffer容积）

            while (bytesRead != -1) { //当读不到任何东西时返回-1
                buf.flip(); //切换到Buffer读模式，读模式下可以读取到之前写入Buffer的数据
                while (buf.hasRemaining()) { //循环输出Buffer中的数据
                    System.out.print((char) buf.get());
                }
                buf.compact(); //或者调用clear，切换回Buffer的写模式
                bytesRead = fileChannel.read(buf); //跟上面一样，再次从通道读取数据到Buffer中
                System.out.println(bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}