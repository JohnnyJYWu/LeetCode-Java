package com.johnnyjywuu;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientManager {
    private static final String TAG = "ClientManager";

    private volatile static ClientManager clientManager = null;
    public static ClientManager getInstance() {
        if (null == clientManager) {
            synchronized (ClientManager.class) {
                if (null == clientManager) {
                    clientManager = new ClientManager();
                }
            }
        }
        return clientManager;
    }

    private Map<String, Socket> clientList = new HashMap<>();
    private ServerThread serverThread = null;
    private PrintStream writer;

    public ServerThread startServer() {
        System.out.println("开启服务");
        if (serverThread != null) {
            shutDown();
        }
        serverThread = new ServerThread();
        new Thread(serverThread).start();
        System.out.println("开启服务成功");
        return serverThread;
    }

    // 关闭所有server socket 和 清空Map
    public void shutDown() {
        if (serverThread != null && clientList != null) {
            for (Socket socket : clientList.values()) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                writer.close();
            }
            serverThread.stop();
            clientList.clear();
        }
    }

    // 群发的方法
    public boolean sendMsgAll() {
        try {
            for (Socket socket : clientList.values()) {
                String msg = "jsonp_callback({\"name\": \"123123\"})";
                if (writer != null) {
                    writer.close();
                }
                writer = new PrintStream(socket.getOutputStream());//告诉客户端连接成功 并传状态过去
                writer.println("HTTP/1.1 200 OK");// 返回应答消息,并结束应答
                writer.println("Content-Length: " + msg.getBytes().length);// 返回内容字节数
                writer.println("Content-Type: text/plain;charset=utf-8");
                writer.println();// 根据 HTTP 协议, 空行将结束头信息
                writer.write(msg.getBytes());
                writer.flush();
                // 关闭输出流
                socket.shutdownOutput();

//                OutputStream outputStream = socket.getOutputStream();
//                outputStream.write("文件接收成功".getBytes());
//                outputStream.flush();//直接返回缓存区数据
//                outputStream.close();
//                writer.write(msg.getBytes());
//                writer.close();
//                OutputStream outputStream = socket.getOutputStream();
//                outputStream.write(msg.getBytes("utf-8"));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public class ServerThread implements Runnable {
        private int port = 8080;
        private boolean isExit = false;
        private ServerSocket server;

        public ServerThread() {
            try {
                server = new ServerSocket(port);
                System.out.println("启动服务成功" + "port:" + port);
            } catch (IOException e) {
                System.out.println("启动server失败，错误原因：" + e.getMessage());
            }
        }

        @Override
        public void run() {
            try {
                while (!isExit) {
                    // 进入等待环节
                    System.out.println("等待设备的连接... ... ");
                    final Socket socket = server.accept();
                    // 获取手机连接的地址及端口号
                    final String address = socket.getRemoteSocketAddress().toString();
                    System.out.println("连接成功，连接的设备为：" + address);

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                // 单线程索锁
                                synchronized (this) {
                                    // 放进到Map中保存
                                    clientList.put(address, socket);
                                }
                                // 定义输入流
                                InputStream inputStream = socket.getInputStream();
                                InputStreamReader isr = new InputStreamReader(socket.getInputStream(), "UTF-8");
                                byte[] buffer = new byte[1024];
                                int len;
                                while ((len = inputStream.read(buffer)) != -1) {
                                    String text = new String(buffer, 0, len);
                                    System.out.println("收到的数据为：\n" + text);
                                    // 必须先关闭输入流才能获取下面的输出流
                                    socket.shutdownInput();
                                    // 在这里群发消息
                                    sendMsgAll();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("错误信息为：" + e.getMessage());
                            } finally {
                                synchronized (this) {
                                    System.out.println("关闭链接：" + address);
                                    clientList.remove(address);
                                }
                            }
                        }
                    }).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void stop() {
            isExit = true;
            if (server != null) {
                try {
                    server.close();
                    System.out.println("已关闭server");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
