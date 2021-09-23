import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer03 {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors() * 4);
        final ServerSocket serverSocket = new ServerSocket(9803);
        while (true) {
            try {
                final Socket socket = serverSocket.accept();
                executorService.execute(() -> service(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void service(Socket socket) {
        try {
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "\" Zip炸弹\"是一个用于攻击向量的术语，其中一个小的zip文件会扩展为一个非常大的未压缩文件，因此会引起诸如耗尽内存或磁盘空间等问题。\n" +
                    "\n" +
                    "通常，创建此类zip的目的是在从外部来源接收zip文件的系统上引起拒绝服务攻击。\n" +
                    "\n" +
                    "由于.xlsx文件实际上是包含XML文件的压缩文件，因此有可能在POI中引起这种zip bomb漏洞。\n" +
                    "\n" +
                    "为了防止这种情况的发生，Apache POI内置了一些防护措施，并且默认情况下启用了这些防护措施。因此，如果您创建的文件包含异常内容，例如如果许多行/列具有相同的内容，则可以使用这些保护措施并收到上述异常。\n" +
                    "\n" +
                    "如果完全控制已处理文件的创建，则可以调整错误消息中给出的设置以避免异常。\n" +
                    "\n" +
                    "请参阅https://bz.apache.org/bugzilla/show_bug.cgi?id=58499，以获取相关问题和ZIp-bomb异常，同时编写较大格式的Excel(.xlsx)，以及如何确定何时出现Zip Bomb错误检索Excel文件样式表是否合法？进行类似的讨论。\n" +
                    "————————————————\n";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
