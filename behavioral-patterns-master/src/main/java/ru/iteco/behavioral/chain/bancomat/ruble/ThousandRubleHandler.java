package ru.iteco.behavioral.chain.bancomat.ruble;

import ru.iteco.behavioral.chain.bancomat.banknote.BanknoteHandler;

public class ThousandRubleHandler extends RubleHandlerBase {

	private final int VALUE = 1000;

	public ThousandRubleHandler(BanknoteHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	protected int getValue() {
		return VALUE;
	}
}