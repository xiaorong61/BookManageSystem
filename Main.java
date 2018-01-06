import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // 创建 Scanner 实例，用来读取标准输入流。
        while (true) { // 一直循环， 直到 break 或 return 或 System.exit(0)
            System.out.println("******************************************");
            for (int i = 1; i <= 5; i++) { // 这个嵌套循环用来打y印两个图案 ： X
                for (int j = 1; j <= 42; j++) {
                    System.out.print(j == i || j == 5 - i + 1 || j == 42 - 5 + i || j == 42 - i + 1 ? "X" : " ");
                }
                System.out.println();
            }
            System.out.println("******************************************");
            System.out.println("********^_^欢迎访问图书管理系统^_^********");
            System.out.println("********   1.图书信息录入         ********");
            System.out.println("********   2.图书信息查询         ********");
            System.out.println("********   3.图书信息删除         ********");
            System.out.println("********   4.图书信息修改         ********");
            System.out.println("********   0.退出                 ********");
            System.out.println("******************************************");
            System.out.println("********   请输入菜单号以执行操作 ********");
            switch (in.nextLine()) {
            case "0": //0.退出
                in.close(); // 关闭 Scanner
                System.out.println("结束"); //显示结束
                return; //退出 main 函数， 即结束整个程序
            case "1": //1.图书信息录入
                do {
                    Book book = new Book(); // 创建书对象
                    System.out.println("***********请输入ID***********");
                    book.ID = in.nextLine(); // 接收一行字符串，存到书对象
                    System.out.println("***********请输入书名*********");
                    book.name = in.nextLine(); // 接收一行字符串，存到书对象
                    System.out.println("***********请输入作者*********");
                    book.author = in.nextLine(); // 接收一行字符串，存到书对象
                    System.out.println("***********请输入摘要*********");
                    book.summary = in.nextLine(); // 接收一行字符串，存到书对象
                    System.out.println("***********请输入价格*********");
                    book.price = in.nextLine(); // 接收一行字符串，存到书对象
                    System.out.println("***********请输入评论*********");
                    book.comment = in.nextLine(); // 接收一行字符串，存到书对象
                    System.out.println("***********请输入出版社*******");
                    book.press = in.nextLine(); // 接收一行字符串，存到书对象
                    System.out.println("***********请输入库存量*******");
                    book.quantity = in.nextLine(); // 接收一行字符串，存到书对象
                    if (BookManageService.insert(book)) {
                        System.out.println("***录入成功，要继续吗？Y/N*****");
                    } else {
                        System.out.println("***录入失败，要继续吗？Y/N*****"); //询问是否继续
                    }

                    System.out.println("******************************");
                } while (in.nextLine().equals("Y")); //如果接下来的输入是字符串 "Y"，则循环上面的代码块， 否则跳出
                break;
            case "2": // 2.图书信息查询
                innerLoop: while (true) { // 为这个循环设置标签，以便在 switch 中 break innerLoop 直接跳出循环
                    System.out.println("*********************************************");
                    System.out.println("********   1. 按ID查询              *********");
                    System.out.println("********   2.按书名查询             *********");
                    System.out.println("********   3.按作者查询             *********");
                    System.out.println("********   4.按出版社查询           *********");
                    System.out.println("********   5.按价格范围查询         *********");
                    System.out.println("********   6.查询所有图书           *********");
                    System.out.println("********   7.返回上级菜单           *********");
                    System.out.println("********   0.退出                   *********");
                    System.out.println("*********************************************");
                    System.out.println("********   请输入菜单号以执行操作   *********");
                    switch (in.nextLine()) {
                    case "0": // 0.退出
                        in.close(); // 关闭 scanner
                        System.out.println("结束"); //打印提示信息
                        return; // 退出 main 函数，即退出整个程序
                    case "1": // 1. 按ID查询
                        System.out.println("***********输入 ID:***********");
                        BookManageService.query(in.nextLine()).print(); // 找到书对象并执行其 print 实例方法
                        break;
                    case "2": // 2.按书名查询
                        System.out.println("***********输入书名************");
                        BookManageService.queryByName(in.nextLine()).forEach(book -> book.print());
                        // 得到对应的 List<Book> 并对每个元素执行实例方法 print
                        break;
                    case "3": // 3.按作者查询
                        System.out.println("***********输入作者************");
                        BookManageService.queryByAuthor(in.nextLine()).forEach(book -> book.print());
                        // 得到对应的 List<Book> 并对每个元素执行实例方法 print
                        break;
                    case "4": // 4.按出版社查询
                        System.out.println("***********输入出版社************");
                        BookManageService.queryByPress(in.nextLine()).forEach(book -> book.print());
                        // 得到对应的 List<Book> 并对每个元素执行实例方法 print
                        break;
                    case "5": // 5.按价格范围查询
                        System.out.println("***********输入价格*************");
                        System.out.println("***********输入最小值************");
                        float min = Float.parseFloat(in.nextLine()); // 存取最小值
                        System.out.println("***********输入最大值************");
                        float max = Float.parseFloat(in.nextLine()); // 存取最大值
                        BookManageService.queryByPrice(min, max).forEach(book -> book.print());
                        // 得到对应的 List<Book> 并对每个元素执行实例方法 print
                        break;
                    case "6": // 6.查询所有图书
                        BookManageService.queryAll().forEach(book -> book.print());
                        // 得到对应的 List<Book> 并对每个元素执行实例方法 print
                        break;
                    case "7": // 7.返回上级菜单
                        break innerLoop;

                    default: // 未匹配则执行 default, 提示错误
                        System.err.println("错误指令");
                        break;
                    }
                }

                break;
            case "3": // 3.图书信息删除
                System.out.println("******输入要删除的书的 ID*********");
                System.out.println(BookManageService.delete(in.nextLine()) ? "成功" : "书不存在或库存量不为0");
                // 根据布尔值打印是否成功
                break;
            case "4": // 4.图书信息修改
                do {
                    System.out.println("输入ID");
                    Book book = BookManageService.query(in.nextLine()); // 获取对应 ID 的书对象
                    System.out.println("输入库存量");
                    book.quantity = in.nextLine(); // 修改库存量
                    System.out.println(BookManageService.update(book) ? "成功" : "失败"); // 执行 update 根据返回值判断是否成功
                    System.out.println("是否继续？Y / N");
                } while (in.nextLine().equals("Y"));

                break;
            default: // 未匹配则执行 default, 提示错误
                System.err.println("错误指令");
            }
        }
    }
}