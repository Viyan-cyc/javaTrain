package threadPool.step6;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileThread implements Runnable {
    private File file;
    private String search;

    public SearchFileThread(File file, String search) {
        this.file = file;
        this.search = search;
    }

    @Override
    public void run() {
        String fileContent = readFileContent(file);
        if (fileContent.contains(search)) {
            System.out.printf( "线程: %s 找到子目标字符串%s,在文件:%s%n",Thread.currentThread().getName(), search,file);
        }
    }

    public String readFileContent(File file) {
        System.out.println(Thread.currentThread() + "正在检索文件" + file.getName());
        try (FileReader fileReader = new FileReader(file)) {
            char[] data = new char[(int) file.length()];
            fileReader.read(data);
            return String.valueOf(data);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
