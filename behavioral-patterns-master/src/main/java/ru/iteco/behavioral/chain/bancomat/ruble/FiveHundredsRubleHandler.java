package ru.iteco.behavioral.chain.bancomat.ruble;

import ru.iteco.behavioral.chain.bancomat.banknote.BanknoteHandler;

public class FiveHundredsRubleHandler extends RubleHandlerBase {

	private final int VALUE = 500;

	public FiveHundredsRubleHandler(BanknoteHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	protected int getValue() {
		return VALUE;
	}
}