import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BookManageService
 */
public class BookManageService {
    static String root = "./library/";

    static Book query(String ID) { // 通过 ID 查询书籍。

        Book book = new Book(); // 创建书类实例
        book.ID = ID; // 将传入的参数的 ID 赋值到 book.ID
        book.name = MyFileMethods.read(root + ID + "/name"); // 通过字符串拼接获得属性所在文件路径，并读取，赋值给变量
        book.author = MyFileMethods.read(root + ID + "/author"); // 通过字符串拼接获得属性所在文件路径，并读取，赋值给变量
        book.summary = MyFileMethods.read(root + ID + "/summary"); // 通过字符串拼接获得属性所在文件路径，并读取，赋值给变量
        book.price = MyFileMethods.read(root + ID + "/price"); // 通过字符串拼接获得属性所在文件路径，并读取，赋值给变量
        book.comment = MyFileMethods.read(root + ID + "/comment"); // 通过字符串拼接获得属性所在文件路径，并读取，赋值给变量
        book.press = MyFileMethods.read(root + ID + "/press"); // 通过字符串拼接获得属性所在文件路径，并读取，赋值给变量
        book.quantity = MyFileMethods.read(root + ID + "/quantity"); // 通过字符串拼接获得属性所在文件路径，并读取，赋值给变量
        return book; // 返回书对象

    }

    static boolean update(Book book) { // 更新书籍，返回的布尔值表示是否成功
        return insert(book); // update 和 insert 有着相同的逻辑，所以直接调用 insert

    }

    static boolean insert(Book book) { // 增加书籍，返回的布尔值表示是否成功
        try {
            new File(root + book.ID).mkdirs(); // 通过 ID 拼接出文件夹路径，并创建文件夹。
            MyFileMethods.write(root + book.ID + "/name", book.name); // 拼接出属性文件路径，并向路径对应的文件写入数据。
            MyFileMethods.write(root + book.ID + "/author", book.author); // 拼接出属性文件路径，并向路径对应的文件写入数据。
            MyFileMethods.write(root + book.ID + "/summary", book.summary); // 拼接出属性文件路径，并向路径对应的文件写入数据。
            MyFileMethods.write(root + book.ID + "/price", book.price); // 拼接出属性文件路径，并向路径对应的文件写入数据。
            MyFileMethods.write(root + book.ID + "/comment", book.comment); // 拼接出属性文件路径，并向路径对应的文件写入数据。
            MyFileMethods.write(root + book.ID + "/press", book.press); // 拼接出属性文件路径，并向路径对应的文件写入数据。
            MyFileMethods.write(root + book.ID + "/quantity", book.quantity); // 拼接出属性文件路径，并向路径对应的文件写入数据。
            return true; //如果执行到这里，说明没有抛出异常，则返回 true 表示执行成功。
        } catch (Exception e) {
            return false; // 有异常则返回 false 表示执行失败
        }
    }

    static boolean delete(String ID) { // 通过 ID 删除图书
        if (new File(root + ID).exists() && query(ID).quantity.equals("0")) { // 如果 ID 文件夹存在而且库存量不为 0
            MyFileMethods.delete(root + ID); //则删除 ID 文件夹
            return true; // 返回 true 表示成功
        }
        return false; // 如果 if 条件不满足，则返回 false 
    }

    static List<Book> queryByName(String string) {
        ArrayList<Book> list = new ArrayList<>(); // 创建 Arraylist
        Arrays.stream(new File(root).list()).filter(ID -> query(ID).name.equals(string))
                .forEach(ID -> list.add(query(ID)));
        // 先找到所有 ID 再筛选出对应 name 等于参数的 ID 再进行遍历执行 list.add(query(ID)) 将对应的 book 对象放入 list
        return list; // 返回 list
    }

    static List<Book> queryByAuthor(String string) { // 原理同上
        ArrayList<Book> list = new ArrayList<>();
        Arrays.stream(new File(root).list()).filter(ID -> query(ID).author.equals(string))
                .forEach(ID -> list.add(query(ID)));
        return list;
    }

    static List<Book> queryByPress(String string) { // 原理同上
        ArrayList<Book> list = new ArrayList<>();
        Arrays.stream(new File(root).list()).filter(ID -> query(ID).press.equals(string))
                .forEach(ID -> list.add(query(ID)));
        return list;
    }

    static List<Book> queryByPrice(float min, float max) { // 通过价格范围查询书籍
        ArrayList<Book> list = new ArrayList<>(); // 建立 Arraylist
        Arrays.stream(new File(root).list()).filter(ID -> {
            float price = Float.parseFloat(query(ID).price);
            return price >= min && price <= max;
        }).forEach(ID -> list.add(query(ID)));
        // 获得所有 ID 筛选出对应价格再给定范围内的 ID 再遍历执行 list.add(query(ID)) 来往 list 插入这些 ID 对应的 Book 类型对象
        return list; // 返回 list
    }

    static List<Book> queryAll() { // 得到所有 Book 对象构成的 list
        ArrayList<Book> list = new ArrayList<>(); // 建立 Arraylist
        Arrays.stream(new File(root).list()).forEach(ID -> list.add(query(ID)));
        // 找到所有的 ID 对它们执行 list.add(query(ID)) 来收集 Book 对象到 list
        return list; //返回
    }

}