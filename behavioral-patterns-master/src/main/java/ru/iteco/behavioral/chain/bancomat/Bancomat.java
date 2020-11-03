package ru.iteco.behavioral.chain.bancomat;

import ru.iteco.behavioral.chain.bancomat.banknote.Banknote;
import ru.iteco.behavioral.chain.bancomat.banknote.BanknoteHandler;
import ru.iteco.behavioral.chain.bancomat.banknote.CurrencyType;
import ru.iteco.behavioral.chain.bancomat.dollar.FiftyDollarHandler;
import ru.iteco.behavioral.chain.bancomat.dollar.HundredDollarHandler;
import ru.iteco.behavioral.chain.bancomat.dollar.TenDollarHandler;
import ru.iteco.behavioral.chain.bancomat.euro.FiftyEuroHandler;
import ru.iteco.behavioral.chain.bancomat.euro.HundredEuroHandler;
import ru.iteco.behavioral.chain.bancomat.euro.TenEuroHandler;
import ru.iteco.behavioral.chain.bancomat.ruble.FiveHundredsRubleHandler;
import ru.iteco.behavioral.chain.bancomat.ruble.HundredRubleHandler;
import ru.iteco.behavioral.chain.bancomat.ruble.ThousandRubleHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Bancomat.
 *
 * @author Ilya_Sukhachev
 */
public class Bancomat {

    private BanknoteHandler handler;

    public Bancomat() {
        handler = new HundredRubleHandler(null);
        handler = new FiveHundredsRubleHandler(handler);
        handler = new ThousandRubleHandler(handler);
        handler = new TenDollarHandler(handler);
        handler = new FiftyDollarHandler(handler);
        handler = new HundredDollarHandler(handler);
        handler = new TenEuroHandler(handler);
        handler = new FiftyEuroHandler(handler);
        handler = new HundredEuroHandler(handler);
    }

    public boolean validate(String banknote) {
        try {

            String[] banknoteAttr = banknote.split("\\s");
            int sum = resolveSum(banknoteAttr[0]);
            CurrencyType currency = resolveCurrency(banknoteAttr[1]);

            return handler.validate(new Banknote (currency, sum));

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public boolean cash(String amount) {
        try {

            String[] amountAttr = amount.split("\\s");
            int sum = resolveSum(amountAttr[0]);
            CurrencyType currency = resolveCurrency(amountAttr[1]);
            Map<Integer, Banknote> cashBox = new HashMap<>();

            if (handler.cash(sum, currency, cashBox)) {
                for (HashMap.Entry<Integer, Banknote> cash : cashBox.entrySet()) {
                    System.out.println(cash.getKey() + " x " + cash.getValue());
                }
                return true;
            }
            return false;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    private CurrencyType resolveCurrency(String banknote) {
        for (CurrencyType currency : CurrencyType.values()) {
            if (currency.getName().equalsIgnoreCase(banknote))
                return currency;
        }
        throw new IllegalArgumentException("Unknown currency");
    }

    private int resolveSum(String amount) {
        try {
            int sum = Integer.parseInt(amount);
            if (sum <= 0) {
                throw new NumberFormatException();
            }
            return sum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid sum");
        }
    }
}
