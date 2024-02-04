package e2e.enums;

import lombok.Getter;

@Getter
public enum OnlyNameOfMonths {
    JANUAR("2024-1"),
    FEBRUAR("2024-2"),
    MÄRZ("2024-3"),
    APRIL("2024-4"),
    MAI("2024-5"),
    JUNI("2024-6"),

    JULI("2024-7"),
    AUGUST("2024-8"),
    SEPTEMBER("2024-9"),
    OKTOBER("2024-10"),
    NOVEMBER("2024-11"),
    DEZEMBER("2024-12");
    public final String listOfMonths;

    OnlyNameOfMonths(String listOfMonths) {
        this.listOfMonths = listOfMonths;
    }
    public String getListlistOfMonths(){
        return listOfMonths;
    }
}
