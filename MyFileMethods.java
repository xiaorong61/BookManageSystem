import java.io.FileWriter; //导入 FileWriter类
import java.io.File;//导入 File 类
import java.util.Arrays; //导入 Arrays 类
import java.util.Scanner;//导入 Scanner 类

public class MyFileMethods { // 这个类封装了文件 io 操作，为了更方便地“增删查改”文件。方法全部静态。

    static void delete(String path) {//这个方法用来删除文件和文件
        File file = new File(path);//根据路径创建 File 对象
        if (file.isFile()) {//如果这个路径是文件
            file.delete();//则删除
        } else {
            //如果执行到这里，说明不是文件而是文件夹。
            Arrays.stream(file.list()).forEach(item -> delete(path + "/" + item));//对子文件夹和文件递归调用 delete
            file.delete();//子文件都已删除，最后删除自己（空文件夹）
        }
    }

    static String read(String path) {//本方法用来读取文件
        try {
            Scanner in = new Scanner(new File(path));// 打开文件
            String result = in.nextLine();// 读取第一行并保存到 result 变量
            in.close();//关闭文件
            return result;//返回结果
        } catch (Exception e) {
            return path + "读取失败";
        }

    }

    static void write(String path, String value) throws Exception {//本方法用来写文件
        FileWriter writer = new FileWriter(path);//打开文件
        writer.write(value);//写入字符串
        writer.close();//关闭文件

    }
}