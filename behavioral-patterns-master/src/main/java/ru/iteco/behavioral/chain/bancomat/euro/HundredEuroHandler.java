package ru.iteco.behavioral.chain.bancomat.euro;

import ru.iteco.behavioral.chain.bancomat.banknote.BanknoteHandler;

public class HundredEuroHandler extends EuroHandlerBase {

	private final int VALUE = 100;

	public HundredEuroHandler(BanknoteHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	protected int getValue() {
		return VALUE;
	}
}
