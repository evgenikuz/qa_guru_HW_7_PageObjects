package pages.components;

import pages.PracticeFormPage;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public static void setDate(String day, String month, String year) {
        $(".react-datepicker__month-container .react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-container .react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__month-container .react-datepicker__day--007").click();
        // как указать день?
    }
}
