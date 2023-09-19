package NioDemo.Channels.FileChannels;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo2 {
    public static void main(String[] args) throws IOException {
        FileChannel channel = new FileOutputStream("hello.txt").getChannel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        byte[] bytes = new String("01234556789").getBytes();
        buf.put(bytes);
        buf.flip();
        while (buf.hasRemaining()) {
            channel.write(buf);
        }

        channel.close();
    }
}
