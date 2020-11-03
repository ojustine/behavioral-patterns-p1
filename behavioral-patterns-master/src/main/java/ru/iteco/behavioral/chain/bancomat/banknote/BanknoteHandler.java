package ru.iteco.behavioral.chain.bancomat.banknote;

import java.util.Map;

/**
 * BanknoteHandler.
 *
 * @author Ilya_Sukhachev
 */
public abstract class BanknoteHandler {

    private BanknoteHandler nextHandler;

    protected BanknoteHandler(BanknoteHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public boolean validate(Banknote banknote) {
        return nextHandler != null && nextHandler.validate(banknote);
    }

    public boolean cash(int sum, CurrencyType currency, Map<Integer, Banknote> cashBox) {
        return nextHandler != null && nextHandler.cash(sum, currency, cashBox);
    }
}
