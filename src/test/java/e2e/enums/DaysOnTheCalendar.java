package e2e.enums;

import lombok.Getter;

@Getter
public enum DaysOnTheCalendar {
    Enamuary_1st("1"),
    Enamuary_2nd("2"),
    Enamuary_3rd("3"),
    Enamuary_4th("4"),
    Enamuary_5th("5"),
    Enamuary_6th("6"),
    Enamuary_7th("7"),
    Enamuary_8th("8"),
    Enamuary_9th("9"),
    Enamuary_10th("10"),
    Enamuary_11th("11"),
    Enamuary_12th("12"),
    Enamuary_13th("13"),
    Enamuary_14th("14"),
    Enamuary_15th("15"),
    Enamuary_16th("16"),
    Enamuary_17th("17"),
    Enamuary_18th("18"),
    Enamuary_19th("19"),
    Enamuary_20th("20"),
    Enamuary_21st("21"),
    Enamuary_22nd("22"),
    Enamuary_23rd("23"),
    Enamuary_24th("24"),
    Enamuary_25th("25"),
    Enamuary_26th("26"),
    Enamuary_27th("27"),
    Enamuary_28th("28"),
    Enamuary_29th("29"),
    Enamuary_30th("30"),
    Enamuary_31st("31");

    private final String listOfDays;

    DaysOnTheCalendar(String listOfDays) {
        this.listOfDays = "//*[@data-day='" + listOfDays + "']";
    }
    public String getListOfDays(){
        return listOfDays;
    }
}
