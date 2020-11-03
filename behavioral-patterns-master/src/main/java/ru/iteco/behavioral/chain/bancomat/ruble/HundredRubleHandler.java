package ru.iteco.behavioral.chain.bancomat.ruble;

import ru.iteco.behavioral.chain.bancomat.banknote.BanknoteHandler;

public class HundredRubleHandler extends RubleHandlerBase {

    private final int VALUE = 100;

    public HundredRubleHandler(BanknoteHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    protected int getValue() {
        return VALUE;
    }
}
