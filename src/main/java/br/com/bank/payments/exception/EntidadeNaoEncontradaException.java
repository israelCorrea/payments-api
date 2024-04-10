package br.com.bank.payments.exception;

public class EntidadeNaoEncontradaException extends NegocioException {
	
	private static final long serialVersionUID = -7231262891603666165L;

	public EntidadeNaoEncontradaException(String message) {
		super(message);
	}

}
