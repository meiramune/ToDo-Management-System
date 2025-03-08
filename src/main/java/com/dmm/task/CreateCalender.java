import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class CreateCalender{

	public static void main(String[] args) throws Exception {
		// ListのListを用意
		List<List<LocalDate>> monthList = new LinkedList<>();

		// 1週間分のLocalDateを格納するList
		List<LocalDate> weekList = new LinkedList<LocalDate>();

		// LocalDateで今の月の1日目を定義
		LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
		// LocalDateで今の月の月末を定義
		LocalDate endOfMonth = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());

		// 曜日を表すDayOfWeekを取得
		DayOfWeek w = startOfMonth.getDayOfWeek();
		
		//列挙型で曜日を数字に変換
		int dayOfWeekValue = w.getValue();

		int number = 7;
		if (dayOfWeekValue != number) {
			// マイナスして前月分のLocalDateを求める
			startOfMonth = startOfMonth.minusDays(dayOfWeekValue);
		}
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		System.out.println(dateTimeFormatter.format(startOfMonth));

		for (int i = 1; i <= number; i++) {

			weekList.add(startOfMonth);
			startOfMonth = startOfMonth.plusDays(1);
			
			
			//
			
			

		}
		System.out.println(weekList);
	}
}