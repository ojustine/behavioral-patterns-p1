package ru.iteco.behavioral.chain.bancomat.banknote;

/**
 * CurrencyType.
 *
 * @author Ilya_Sukhachev
 */
public enum CurrencyType {
    EUR("euros"),
    USD("dollars"),
    RUB("rubles");

    private final String name;

    CurrencyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
