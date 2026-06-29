package sec12.chap03;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Ex01 {

    public static final String SONG_PATH = "src/sec12/chap03/beatles.txt";

    static void main(String[] args) {
        String fis1 = measureTime(Ex01::fileInputStrmEx1);
        String fis2 = measureTime(Ex01::fileInputStrmEx2);
        String fis3 = measureTime(Ex01::fileInputStrmEx3);
        String bis = measureTime(Ex01::bufferedInputEx);
    }

    public static void fileInputStrmEx1() {

        //  💡 FileInputStream
        //  - InputStream으로부터 상속
        //  - 파일로부터 데이터를 받아오는데 사용
        //  - try-with-resources로 스트림 열고 닫음
        try (FileInputStream fis = new FileInputStream(SONG_PATH)) {
            int readByte;
            //  💡 read : 파일로부터 1바이트씩 읽어옴 - 성능 저하
            //  - 더 읽어올 것이 없을 시 -1 반환
            while ((readByte = fis.read()) != -1) {
                char readChar = (char) readByte;

                System.out.print(readChar); // 한 글자씩 나란히 출력
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // ⚠️ 한글은 인코딩 설정이 안 되어있으므로 깨져서 나옴

    public static void fileInputStrmEx2() {

        //  ⭐️ 인코딩 설정 - UTF-8
        Charset charset = StandardCharsets.UTF_8;

        try (
                FileInputStream fis = new FileInputStream(SONG_PATH);

                //  💡 InputStreamReader : 바이트 스트림을 문자열 스트림으로
                //  - 인코딩 적용 등에 사용
                InputStreamReader isr = new InputStreamReader(fis, charset)
        ) {
            int readByte;
            while ((readByte = isr.read()) != -1) {
                char readChar = (char) readByte;
                System.out.print(readChar);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // ⚠️ 주어진 바이트 수가 다 채워지지 않을 시
        // - (즉 마지막에 바구니가 다 차지 않을 때)
        // - 남은 부분을 0으로 채움 - 비효율적
        // - 때문에 바로 다음의 BufferedInputStream을 사용
    }

    public static void fileInputStrmEx3() {

        //  💡 버퍼를 사용
        //  - 하나씩 손에 들고 오는 게 아니라 바구니에 담아옴
        //  - 1바이트씩 받아올 때보다는 효율적
        byte[] buffer = new byte[1024]; // 바이트 1024개가 담기는 🧺 바구니

        Charset charset = StandardCharsets.UTF_8;

        try (FileInputStream fis = new FileInputStream(SONG_PATH)) {
            int readByte;
            int count = 0;

            //  bytes[]를 인자로 넣을 시 그 용량만큼 받아옴
            while ((readByte = fis.read(buffer)) != -1) {

                //  💡 byte[]로부터 지정된 범위와 인코딩의 문자열 생성
                String readStr = new String(
                        buffer, 0, readByte, charset
                );

                System.out.printf(
                        "\n⭐️- - - %d : %d - - -\n%n",
                        ++count, readByte
                );
                System.out.println(readStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void bufferedInputEx() {
        Charset charset = StandardCharsets.UTF_8;

        try (
                //  💡 BufferedInputStream
                //  - 내부에 버퍼를 가짐 (기본 8192 바이트)
                //    - 🚚 트럭에 실어옴
                //  - FileInputStream을 생성자 인자로 받음
                BufferedInputStream bis = new BufferedInputStream(
                        new FileInputStream(SONG_PATH)
                        //, 4096 // 또는 원하는 크기 지정 가능
                )
        ) {
            //  트럭에 실려온 것 🧺 바구니에 담아 while 문에서 문자열 변환
            //  - 즉 두 번의 버퍼 사용
            byte[] buffer = new byte[1024];
            int readByte;
            int count = 0;

            //  ⭐ FileInputStream의 read(byte[]) 메소드와의 차이
            //  - 1. 내부 버퍼(트럭)으로부터 가져오므로 더 빠름
            //  - 2. 바구니 크기보다 적게 남았을 때 그만큼만 담아옴
            while ((readByte = bis.read(buffer)) != -1) {
                String readStr = new String(
                        buffer, 0, readByte, charset
                );
                System.out.printf(
                        "\n⭐️- - - %d : %d - - -\n%n",
                        ++count, readByte
                );
                System.out.println(readStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String measureTime(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long endTime = System.nanoTime();
        return String.valueOf("%,d 나노초")
                .formatted(endTime - startTime);
    }
}
