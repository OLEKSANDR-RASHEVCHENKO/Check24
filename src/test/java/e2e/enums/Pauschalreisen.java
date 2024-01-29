package e2e.enums;

import lombok.Getter;

@Getter
public enum Pauschalreisen {
    URLAUBREISEN("Urlaubsreisen"),
    FRÜHBUCHER("Frühbucher"),
    LAST_MINUTE("Last Minute"),
    ALL_INCLUSIVE("All Inclusive"),
    STÄDTE_REISEN("Städtereisen"),

    FAMILIEN_URLAUB("Familienurlaub");

    private final String listOfPauschalreisen;

    Pauschalreisen(String listOfPauschalreisen) {
        this.listOfPauschalreisen = "//*[@title='" + listOfPauschalreisen + "']";
    }
    public String getListOfPauschalreisen(){
        return listOfPauschalreisen;
    }
}
