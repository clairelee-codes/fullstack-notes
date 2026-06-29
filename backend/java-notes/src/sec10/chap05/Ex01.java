package sec10.chap05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex01 {
    static void main(String[] args) {
        String correctPath = "./src/sec09/chap04/turtle.txt";
        String wrongPath = "./src/sec09/chap04/rabbit.txt";

        openFile1(correctPath);
        openFile1(wrongPath);

        System.out.println("\n- - - - -\n");

        openFile2(correctPath);
        openFile2(wrongPath);
    }


    public static void openFile1(String path) {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new File(path));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("⚠️ %s 파일 없음%n", path);
        } finally {
            System.out.println("열었으면 닫아야지 ㅇㅇ");
            if (scanner != null) scanner.close();

            //  💡 만약 이 부분을 작성하는 것을 잊는다면?
        }
    }

    public static void openFile2(String path) {
        //  ⭐ Scanner가 Closable - AutoClosable를 구현함 확인

        try (Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.printf("⚠️ %s 파일 없음%n", path);
        }

        // 💡 .close를 작성하지 않아도 자동으로 호출됨
    }
}
