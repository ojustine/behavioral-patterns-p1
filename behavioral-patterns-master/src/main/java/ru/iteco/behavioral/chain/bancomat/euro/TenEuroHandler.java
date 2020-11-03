package ru.iteco.behavioral.chain.bancomat.euro;

import ru.iteco.behavioral.chain.bancomat.banknote.BanknoteHandler;

public class TenEuroHandler extends EuroHandlerBase {

	private final int VALUE = 10;

	public TenEuroHandler(BanknoteHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	protected int getValue() {
		return VALUE;
	}
}
