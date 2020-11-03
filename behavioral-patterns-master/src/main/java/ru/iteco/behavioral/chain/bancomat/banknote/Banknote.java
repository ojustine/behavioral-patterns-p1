package ru.iteco.behavioral.chain.bancomat.banknote;

/**
 * Banknote.
 *
 * @author Ilya_Sukhachev
 */
public class Banknote {

    private final CurrencyType currency;
    private final int value;

    public Banknote(CurrencyType currency, int value) {
        this.currency = currency;
        this.value = value;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue() + " " + this.currency.getName();
    }
}
