package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private static SelenideElement yearPicker = $(".react-datepicker__year-select"),
                            monthPicker = $(".react-datepicker__month-select");
    private static String dayPicker = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";

    public static void setDate(String day, String month, String year) {
        yearPicker.selectOption(year);
        monthPicker.selectOption(month);
        $(String.format(dayPicker, day)).click();
    }
}
