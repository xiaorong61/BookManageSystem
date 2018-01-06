import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BookManageService
 */
public class BookManageService {
    static String root = "./library/";

    static Book query(String ID) { // ͨ�� ID ��ѯ�鼮��

        Book book = new Book(); // ��������ʵ��
        book.ID = ID; // ������Ĳ����� ID ��ֵ�� book.ID
        book.name = MyFileMethods.read(root + ID + "/name"); // ͨ���ַ���ƴ�ӻ�����������ļ�·��������ȡ����ֵ������
        book.author = MyFileMethods.read(root + ID + "/author"); // ͨ���ַ���ƴ�ӻ�����������ļ�·��������ȡ����ֵ������
        book.summary = MyFileMethods.read(root + ID + "/summary"); // ͨ���ַ���ƴ�ӻ�����������ļ�·��������ȡ����ֵ������
        book.price = MyFileMethods.read(root + ID + "/price"); // ͨ���ַ���ƴ�ӻ�����������ļ�·��������ȡ����ֵ������
        book.comment = MyFileMethods.read(root + ID + "/comment"); // ͨ���ַ���ƴ�ӻ�����������ļ�·��������ȡ����ֵ������
        book.press = MyFileMethods.read(root + ID + "/press"); // ͨ���ַ���ƴ�ӻ�����������ļ�·��������ȡ����ֵ������
        book.quantity = MyFileMethods.read(root + ID + "/quantity"); // ͨ���ַ���ƴ�ӻ�����������ļ�·��������ȡ����ֵ������
        return book; // ���������

    }

    static boolean update(Book book) { // �����鼮�����صĲ���ֵ��ʾ�Ƿ�ɹ�
        return insert(book); // update �� insert ������ͬ���߼�������ֱ�ӵ��� insert

    }

    static boolean insert(Book book) { // �����鼮�����صĲ���ֵ��ʾ�Ƿ�ɹ�
        try {
            new File(root + book.ID).mkdirs(); // ͨ�� ID ƴ�ӳ��ļ���·�����������ļ��С�
            MyFileMethods.write(root + book.ID + "/name", book.name); // ƴ�ӳ������ļ�·��������·����Ӧ���ļ�д�����ݡ�
            MyFileMethods.write(root + book.ID + "/author", book.author); // ƴ�ӳ������ļ�·��������·����Ӧ���ļ�д�����ݡ�
            MyFileMethods.write(root + book.ID + "/summary", book.summary); // ƴ�ӳ������ļ�·��������·����Ӧ���ļ�д�����ݡ�
            MyFileMethods.write(root + book.ID + "/price", book.price); // ƴ�ӳ������ļ�·��������·����Ӧ���ļ�д�����ݡ�
            MyFileMethods.write(root + book.ID + "/comment", book.comment); // ƴ�ӳ������ļ�·��������·����Ӧ���ļ�д�����ݡ�
            MyFileMethods.write(root + book.ID + "/press", book.press); // ƴ�ӳ������ļ�·��������·����Ӧ���ļ�д�����ݡ�
            MyFileMethods.write(root + book.ID + "/quantity", book.quantity); // ƴ�ӳ������ļ�·��������·����Ӧ���ļ�д�����ݡ�
            return true; //���ִ�е����˵��û���׳��쳣���򷵻� true ��ʾִ�гɹ���
        } catch (Exception e) {
            return false; // ���쳣�򷵻� false ��ʾִ��ʧ��
        }
    }

    static boolean delete(String ID) { // ͨ�� ID ɾ��ͼ��
        if (new File(root + ID).exists() && query(ID).quantity.equals("0")) { // ��� ID �ļ��д��ڶ��ҿ������Ϊ 0
            MyFileMethods.delete(root + ID); //��ɾ�� ID �ļ���
            return true; // ���� true ��ʾ�ɹ�
        }
        return false; // ��� if ���������㣬�򷵻� false 
    }

    static List<Book> queryByName(String string) {
        ArrayList<Book> list = new ArrayList<>(); // ���� Arraylist
        Arrays.stream(new File(root).list()).filter(ID -> query(ID).name.equals(string))
                .forEach(ID -> list.add(query(ID)));
        // ���ҵ����� ID ��ɸѡ����Ӧ name ���ڲ����� ID �ٽ��б���ִ�� list.add(query(ID)) ����Ӧ�� book ������� list
        return list; // ���� list
    }

    static List<Book> queryByAuthor(String string) { // ԭ��ͬ��
        ArrayList<Book> list = new ArrayList<>();
        Arrays.stream(new File(root).list()).filter(ID -> query(ID).author.equals(string))
                .forEach(ID -> list.add(query(ID)));
        return list;
    }

    static List<Book> queryByPress(String string) { // ԭ��ͬ��
        ArrayList<Book> list = new ArrayList<>();
        Arrays.stream(new File(root).list()).filter(ID -> query(ID).press.equals(string))
                .forEach(ID -> list.add(query(ID)));
        return list;
    }

    static List<Book> queryByPrice(float min, float max) { // ͨ���۸�Χ��ѯ�鼮
        ArrayList<Book> list = new ArrayList<>(); // ���� Arraylist
        Arrays.stream(new File(root).list()).filter(ID -> {
            float price = Float.parseFloat(query(ID).price);
            return price >= min && price <= max;
        }).forEach(ID -> list.add(query(ID)));
        // ������� ID ɸѡ����Ӧ�۸��ٸ�����Χ�ڵ� ID �ٱ���ִ�� list.add(query(ID)) ���� list ������Щ ID ��Ӧ�� Book ���Ͷ���
        return list; // ���� list
    }

    static List<Book> queryAll() { // �õ����� Book ���󹹳ɵ� list
        ArrayList<Book> list = new ArrayList<>(); // ���� Arraylist
        Arrays.stream(new File(root).list()).forEach(ID -> list.add(query(ID)));
        // �ҵ����е� ID ������ִ�� list.add(query(ID)) ���ռ� Book ���� list
        return list; //����
    }

}