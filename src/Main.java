// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }

        StringBuilder sb = new StringBuilder("Hello ");  // 初始化
        sb.append("World");  // 拼接字符串
        System.out.println(sb);

        for (int i = 0; i < sb.length(); i ++ ) {
            sb.setCharAt(i, (char)(sb.charAt(i) + 1));  // 读取和写入字符
        }

        System.out.println(sb);

    }
}