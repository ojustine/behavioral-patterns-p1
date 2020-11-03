package ru.iteco.behavioral.chain.bancomat.euro;

import ru.iteco.behavioral.chain.bancomat.banknote.BanknoteHandler;

public class FiftyEuroHandler extends EuroHandlerBase {

	private final int VALUE = 50;

	public FiftyEuroHandler(BanknoteHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	protected int getValue() {
		return VALUE;
	}
}
