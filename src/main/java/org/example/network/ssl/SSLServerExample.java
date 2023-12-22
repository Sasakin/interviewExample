package org.example.network.ssl;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.BasicClientConnectionManager;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.SingleClientConnManager;

import javax.net.ServerSocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;

public class SSLServerExample {
    public static void main(String[] args) throws IOException {
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

            // Создание ServerSocketFactory из SSLContext
            ServerSocketFactory sslSocketFactory = sslContext.getServerSocketFactory();

            // Создание SSL-сокета
            ServerSocket serverSocket = (ServerSocket) sslSocketFactory.createServerSocket(8444);

            // Взаимодействие с SSL-сокетом
            // ...
            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Получение потоков ввода-вывода для SSL-сокета
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Чтение запроса от клиента
                String request = in.readLine();
                System.out.println("Received request: " + request);

                // Обработка запроса
                String response = "Hello, client!";
                // ... дополнительная обработка запроса ...

                // Отправка ответа клиенту
                out.println(response);

                // Закрытие потоков и сокета
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
