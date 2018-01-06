/**
 * Book
 */
public class Book {
    String ID, name, author, summary, price, comment, press, quantity;

    void print() { // 用来打印 book 实例信息
        System.out.println("-------------------");
        System.out.println("ID: \t" + ID);
        System.out.println("书名: \t" + name);
        System.out.println("作者: \t" + author);
        System.out.println("摘要: \t" + summary);
        System.out.println("价格: \t" + price);
        System.out.println("评论: \t" + comment);
        System.out.println("出版: \t" + press);
        System.out.println("数量: \t" + quantity);
        System.out.println("-------------------");

    }
}