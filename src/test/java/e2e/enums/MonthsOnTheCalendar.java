package e2e.enums;

import lombok.Getter;

@Getter
public enum MonthsOnTheCalendar {
    JANUAR("01.01.2024"),
    FEBRUAR("01.02.2024"),
    MÄRZ("01.03.2024"),
    APRIL("01.04.2024"),
    MAI("01.05.2024"),
    JUNI("01.06.2024"),

    JULI("01.07.2024"),
    AUGUST("01.08.2024"),
    SEPTEMBER("01.09.2024"),
    OKTOBER("01.10.2024"),
    NOVEMBER("01.11.2024"),
    DEZEMBER("01.12.2024");



    private final String listOfMonths;

    MonthsOnTheCalendar(String listOfMonths) {
        this.listOfMonths = "//*[@data-first-day='" + listOfMonths + "']//*";
    }
    public String getListOfMonths(){
        return listOfMonths;
    }
}

