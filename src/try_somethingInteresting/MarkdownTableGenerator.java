package try_somethingInteresting;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MarkdownTableGenerator {
    public static void main(String[] args) {
        // 定义起始日期和结束日期
        LocalDate startDate = LocalDate.of(2024, 4, 13);
        LocalDate endDate = LocalDate.of(2024, 11, 1);

        // 设置日期格式
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 初始化数字
        int number = 5;

        // 打印Markdown表格头部
        System.out.println("| Date       | Number | Todo      |");
        System.out.println("|------------|--------|-----------|");

        // 循环每一天，生成表格行
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            System.out.printf("| %s | %6d | - [ ]    |\n", date.format(dateFormatter), number);
            number += 5; // 每天增加5
        }
    }
}
