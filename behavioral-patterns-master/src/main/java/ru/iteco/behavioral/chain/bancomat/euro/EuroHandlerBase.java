package ru.iteco.behavioral.chain.bancomat.euro;

import ru.iteco.behavioral.chain.bancomat.banknote.Banknote;
import ru.iteco.behavioral.chain.bancomat.banknote.BanknoteHandler;
import ru.iteco.behavioral.chain.bancomat.banknote.CurrencyType;

import java.util.Map;

public abstract class EuroHandlerBase extends BanknoteHandler {

	private static final CurrencyType CURRENCY = CurrencyType.EUR;

	protected EuroHandlerBase(BanknoteHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public boolean validate(Banknote banknote) {
		if (banknote.getCurrency() == EuroHandlerBase.CURRENCY && banknote.getValue() == this.getValue()) {
			return true;
		}
		return super.validate(banknote);
	}

	@Override
	public boolean cash(int sum, CurrencyType currency, Map<Integer, Banknote> cashBox) {

		if (currency == EuroHandlerBase.CURRENCY) {
			int banknoteCount = sum / getValue();
			sum %= getValue();

			if (banknoteCount > 0) {
				cashBox.put(banknoteCount, new Banknote(EuroHandlerBase.CURRENCY, getValue()));
			}
			if (sum == 0) {
				return true;
			}
		}
		return super.cash(sum, currency, cashBox);
	}

	protected abstract int getValue();
}
