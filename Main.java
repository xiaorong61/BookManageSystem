import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // ���� Scanner ʵ����������ȡ��׼��������
        while (true) { // һֱѭ���� ֱ�� break �� return �� System.exit(0)
            System.out.println("******************************************");
            for (int i = 1; i <= 5; i++) { // ���Ƕ��ѭ��������yӡ����ͼ�� �� X
                for (int j = 1; j <= 42; j++) {
                    System.out.print(j == i || j == 5 - i + 1 || j == 42 - 5 + i || j == 42 - i + 1 ? "X" : " ");
                }
                System.out.println();
            }
            System.out.println("******************************************");
            System.out.println("********^_^��ӭ����ͼ�����ϵͳ^_^********");
            System.out.println("********   1.ͼ����Ϣ¼��         ********");
            System.out.println("********   2.ͼ����Ϣ��ѯ         ********");
            System.out.println("********   3.ͼ����Ϣɾ��         ********");
            System.out.println("********   4.ͼ����Ϣ�޸�         ********");
            System.out.println("********   0.�˳�                 ********");
            System.out.println("******************************************");
            System.out.println("********   ������˵�����ִ�в��� ********");
            switch (in.nextLine()) {
            case "0": //0.�˳�
                in.close(); // �ر� Scanner
                System.out.println("����"); //��ʾ����
                return; //�˳� main ������ ��������������
            case "1": //1.ͼ����Ϣ¼��
                do {
                    Book book = new Book(); // ���������
                    System.out.println("***********������ID***********");
                    book.ID = in.nextLine(); // ����һ���ַ������浽�����
                    System.out.println("***********����������*********");
                    book.name = in.nextLine(); // ����һ���ַ������浽�����
                    System.out.println("***********����������*********");
                    book.author = in.nextLine(); // ����һ���ַ������浽�����
                    System.out.println("***********������ժҪ*********");
                    book.summary = in.nextLine(); // ����һ���ַ������浽�����
                    System.out.println("***********������۸�*********");
                    book.price = in.nextLine(); // ����һ���ַ������浽�����
                    System.out.println("***********����������*********");
                    book.comment = in.nextLine(); // ����һ���ַ������浽�����
                    System.out.println("***********�����������*******");
                    book.press = in.nextLine(); // ����һ���ַ������浽�����
                    System.out.println("***********����������*******");
                    book.quantity = in.nextLine(); // ����һ���ַ������浽�����
                    if (BookManageService.insert(book)) {
                        System.out.println("***¼��ɹ���Ҫ������Y/N*****");
                    } else {
                        System.out.println("***¼��ʧ�ܣ�Ҫ������Y/N*****"); //ѯ���Ƿ����
                    }

                    System.out.println("******************************");
                } while (in.nextLine().equals("Y")); //������������������ַ��� "Y"����ѭ������Ĵ���飬 ��������
                break;
            case "2": // 2.ͼ����Ϣ��ѯ
                innerLoop: while (true) { // Ϊ���ѭ�����ñ�ǩ���Ա��� switch �� break innerLoop ֱ������ѭ��
                    System.out.println("*********************************************");
                    System.out.println("********   1. ��ID��ѯ              *********");
                    System.out.println("********   2.��������ѯ             *********");
                    System.out.println("********   3.�����߲�ѯ             *********");
                    System.out.println("********   4.���������ѯ           *********");
                    System.out.println("********   5.���۸�Χ��ѯ         *********");
                    System.out.println("********   6.��ѯ����ͼ��           *********");
                    System.out.println("********   7.�����ϼ��˵�           *********");
                    System.out.println("********   0.�˳�                   *********");
                    System.out.println("*********************************************");
                    System.out.println("********   ������˵�����ִ�в���   *********");
                    switch (in.nextLine()) {
                    case "0": // 0.�˳�
                        in.close(); // �ر� scanner
                        System.out.println("����"); //��ӡ��ʾ��Ϣ
                        return; // �˳� main ���������˳���������
                    case "1": // 1. ��ID��ѯ
                        System.out.println("***********���� ID:***********");
                        BookManageService.query(in.nextLine()).print(); // �ҵ������ִ���� print ʵ������
                        break;
                    case "2": // 2.��������ѯ
                        System.out.println("***********��������************");
                        BookManageService.queryByName(in.nextLine()).forEach(book -> book.print());
                        // �õ���Ӧ�� List<Book> ����ÿ��Ԫ��ִ��ʵ������ print
                        break;
                    case "3": // 3.�����߲�ѯ
                        System.out.println("***********��������************");
                        BookManageService.queryByAuthor(in.nextLine()).forEach(book -> book.print());
                        // �õ���Ӧ�� List<Book> ����ÿ��Ԫ��ִ��ʵ������ print
                        break;
                    case "4": // 4.���������ѯ
                        System.out.println("***********���������************");
                        BookManageService.queryByPress(in.nextLine()).forEach(book -> book.print());
                        // �õ���Ӧ�� List<Book> ����ÿ��Ԫ��ִ��ʵ������ print
                        break;
                    case "5": // 5.���۸�Χ��ѯ
                        System.out.println("***********����۸�*************");
                        System.out.println("***********������Сֵ************");
                        float min = Float.parseFloat(in.nextLine()); // ��ȡ��Сֵ
                        System.out.println("***********�������ֵ************");
                        float max = Float.parseFloat(in.nextLine()); // ��ȡ���ֵ
                        BookManageService.queryByPrice(min, max).forEach(book -> book.print());
                        // �õ���Ӧ�� List<Book> ����ÿ��Ԫ��ִ��ʵ������ print
                        break;
                    case "6": // 6.��ѯ����ͼ��
                        BookManageService.queryAll().forEach(book -> book.print());
                        // �õ���Ӧ�� List<Book> ����ÿ��Ԫ��ִ��ʵ������ print
                        break;
                    case "7": // 7.�����ϼ��˵�
                        break innerLoop;

                    default: // δƥ����ִ�� default, ��ʾ����
                        System.err.println("����ָ��");
                        break;
                    }
                }

                break;
            case "3": // 3.ͼ����Ϣɾ��
                System.out.println("******����Ҫɾ������� ID*********");
                System.out.println(BookManageService.delete(in.nextLine()) ? "�ɹ�" : "�鲻���ڻ�������Ϊ0");
                // ���ݲ���ֵ��ӡ�Ƿ�ɹ�
                break;
            case "4": // 4.ͼ����Ϣ�޸�
                do {
                    System.out.println("����ID");
                    Book book = BookManageService.query(in.nextLine()); // ��ȡ��Ӧ ID �������
                    System.out.println("��������");
                    book.quantity = in.nextLine(); // �޸Ŀ����
                    System.out.println(BookManageService.update(book) ? "�ɹ�" : "ʧ��"); // ִ�� update ���ݷ���ֵ�ж��Ƿ�ɹ�
                    System.out.println("�Ƿ������Y / N");
                } while (in.nextLine().equals("Y"));

                break;
            default: // δƥ����ִ�� default, ��ʾ����
                System.err.println("����ָ��");
            }
        }
    }
}