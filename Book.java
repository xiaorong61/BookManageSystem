/**
 * Book
 */
public class Book {
    String ID, name, author, summary, price, comment, press, quantity;

    void print() { // ������ӡ book ʵ����Ϣ
        System.out.println("-------------------");
        System.out.println("ID: \t" + ID);
        System.out.println("����: \t" + name);
        System.out.println("����: \t" + author);
        System.out.println("ժҪ: \t" + summary);
        System.out.println("�۸�: \t" + price);
        System.out.println("����: \t" + comment);
        System.out.println("����: \t" + press);
        System.out.println("����: \t" + quantity);
        System.out.println("-------------------");

    }
}