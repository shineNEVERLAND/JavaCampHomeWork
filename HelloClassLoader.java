import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        try {
            Class<?> helloClass = new HelloClassLoader().findClass("Hello");
            Method helloMetod = helloClass.getMethod("hello");
            helloMetod.invoke(helloClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] byteArray = new byte[0];

        try {
            Path path = Paths.get("Hello.xlass");
            byteArray = Files.readAllBytes(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < byteArray.length; i++) {
            byteArray[i] = (byte) (((byte) 255) - byteArray[i]);
        }
        return defineClass(name, byteArray, 0, byteArray.length);

    }
}