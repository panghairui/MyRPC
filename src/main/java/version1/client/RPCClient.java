package version1.client;

import version1.server.domain.UserDTO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

public class RPCClient {

    public static void main(String[] args) {
        try {
            // 建立Socket连接,包括目标ip和目标端口
            Socket socket = new Socket("127.0.0.1", 8899);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            // 传给服务器id
            objectOutputStream.writeInt(new Random().nextInt());
            objectOutputStream.flush();
            // 服务端查询数据，返回对应的对象
            UserDTO userDTO = (UserDTO) objectInputStream.readObject();
            System.out.println("服务端返回的User:" + userDTO);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("客户端启动失败");
        }
    }

}
