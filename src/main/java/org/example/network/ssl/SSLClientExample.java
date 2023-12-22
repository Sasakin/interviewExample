package org.example.network.ssl;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.KeyStore;

public class SSLClientExample {

    public static void main(String[] args) throws IOException {
        String serverHostname = "localhost";
        int serverPort = 8444;
        String keystorePath = "./secrets/keystore.jks";
        String keystorePassword = "123456";
        String keyPassword = "123456";

        try {
            // Загрузка keystore
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(new FileInputStream(ClassLoader.getSystemResource(keystorePath).getFile()), keystorePassword.toCharArray());

            // Получение KeyManagerFactory с использованием keystore
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(keystore, keyPassword.toCharArray());

            // Создание SSLContext с использованием KeyManagerFactory
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
            // Создание SSL-сокета
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(serverHostname, serverPort);

            // Получение потоков ввода-вывода для SSL-сокета
            PrintWriter out = new PrintWriter(sslSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));

            // Отправка сообщения на сервер
            out.println("Hello, server!");

            // Получение ответа от сервера
            String response = in.readLine();
            System.out.println("Server response: " + response);

            // Закрытие потоков и SSL-сокета
            out.close();
            in.close();
            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
