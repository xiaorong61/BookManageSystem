import java.io.FileWriter; //���� FileWriter��
import java.io.File;//���� File ��
import java.util.Arrays; //���� Arrays ��
import java.util.Scanner;//���� Scanner ��

public class MyFileMethods { // ������װ���ļ� io ������Ϊ�˸�����ء���ɾ��ġ��ļ�������ȫ����̬��

    static void delete(String path) {//�����������ɾ���ļ����ļ�
        File file = new File(path);//����·������ File ����
        if (file.isFile()) {//������·�����ļ�
            file.delete();//��ɾ��
        } else {
            //���ִ�е����˵�������ļ������ļ��С�
            Arrays.stream(file.list()).forEach(item -> delete(path + "/" + item));//�����ļ��к��ļ��ݹ���� delete
            file.delete();//���ļ�����ɾ�������ɾ���Լ������ļ��У�
        }
    }

    static String read(String path) {//������������ȡ�ļ�
        try {
            Scanner in = new Scanner(new File(path));// ���ļ�
            String result = in.nextLine();// ��ȡ��һ�в����浽 result ����
            in.close();//�ر��ļ�
            return result;//���ؽ��
        } catch (Exception e) {
            return path + "��ȡʧ��";
        }

    }

    static void write(String path, String value) throws Exception {//����������д�ļ�
        FileWriter writer = new FileWriter(path);//���ļ�
        writer.write(value);//д���ַ���
        writer.close();//�ر��ļ�

    }
}