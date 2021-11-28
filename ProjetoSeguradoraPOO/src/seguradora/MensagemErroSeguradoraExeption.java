package seguradora;

public class MensagemErroSeguradoraExeption extends RuntimeException  {
	 
	private static final long serialVersionUID = 1L;

	public MensagemErroSeguradoraExeption(String message) {
        super(message);
    }
	
    public MensagemErroSeguradoraExeption(Throwable t) {
        super(t);
    }
	
}
