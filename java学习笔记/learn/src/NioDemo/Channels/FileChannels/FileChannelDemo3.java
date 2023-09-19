package NioDemo.Channels.FileChannels;

//    FileChannel 类的 position() 方法：获取 FileChannel 当前的位置
//                    position(long pos) 方法：设置 FileChannel 当前的位置
//                    size() 方法：返回文件的大小
//                    truncate(long size) 方法：截取一个文件，文件 size 位置后的数据会被删掉
//                    force() 方法：将通道中尚未写入到硬盘中的数据强制写入到硬盘中
//                    transferTo(), transferFrom()方法：用于通道之间的数据传输，把一个通道中的数据写入到另一个通道中

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileChannelDemo3 {
    public static void main(String[] args) throws IOException {
        // 创建两个 FileChannel
        RandomAccessFile aFile = new RandomAccessFile("hello.txt", "rw");
        FileChannel fromChannel = aFile.getChannel();

        RandomAccessFile bFile = new RandomAccessFile("reader.txt", "rw");
        FileChannel toChannel = bFile.getChannel();

        // fromChannel 中的数据 传入到 toChannel 中去
        toChannel.transferFrom(fromChannel, 0, fromChannel.size());
//       等同于 fromChannel.transferTo(0, fromChannel.size(), toChannel);

        aFile.close();
        bFile.close();
        System.out.println("传输完毕");
    }
}
