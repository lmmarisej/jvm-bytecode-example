package me.ya.classloader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created By Arthur Zhang at 2019/10/9
 */
public class MyCustomClassLoader extends ClassLoader {
    static {
        System.load("/Users/lmmarise.j/develop/java_web_project_list/jvm-bytecode-book-example/CustomClassLoaderJniDemo/src/main/c/libdecrypt.dylib");
    }

    public static native byte[] decryptJni(byte[] bytes);

    @Override
    protected Class<?> findClass(String name) {
        byte[] bytes = getClassFileBytesInDir(name);
        byte[] decodedBytes = decryptJni(bytes);
        return defineClass(name, decodedBytes, 0, bytes.length);
    }

    private static byte[] getClassFileBytesInDir(String className) {
        try {
            return FileUtils.readFileToByteArray(new File("/Users/lmmarise.j/develop/java_web_project_list/jvm-bytecode-book-example/CustomClassLoaderJniDemo/encrypt_classes/" +
                    className + ".class_"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("");
    }

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new MyCustomClassLoader();
        Class clz = classLoader.loadClass("MyService");
        clz.newInstance();
    }
}
