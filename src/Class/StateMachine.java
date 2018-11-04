package Class;

/**
 * @author Érick Kenji Sugahara
 * @since 2018-11-04
 */
public class StateMachine 
{
	/**
	 * Valid part of string
	 */
	public static String TextoSaida = "";
	
	enum eEstado
	{
		Sinais,
		Digitos,
		PontoDigitos,
		EstE,
		Sinais2,
		Digitos2,
		Valido;
	}
	
	private eEstado estado;
	public eEstado getEstado() 
	{
		return estado;
	}
	public void setEstado(eEstado estado) 
	{
		this.estado = estado;
	}

	private String texto;
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) 
	{
		this.texto = texto;
	}
	
	public StateMachine()
	{
		this.estado = eEstado.Sinais;
	}
	
	/**
	 * @return Boolean, identifiy a valid String
	 */
	public boolean MudancaEstado()
	{
		if (this.estado == null) return false;
		if (this.texto == null || this.texto.length() == 0) return false;
		TextoSaida = "";
		char[] caracteres = texto.toCharArray();
		boolean valido = true;
		for(char c : caracteres)
		{
			if (valido == false) continue;
			switch(estado)
			{
				case Sinais:
					if (c == '+' || c == '-')
					{
						this.estado = eEstado.Digitos;
						TextoSaida += c;
					}
					else if (Character.isDigit(c))
					{
						this.estado = eEstado.Digitos;
						TextoSaida += c;
					}
					else
					{
						valido = false;
					}
					break;
				case Digitos:
					if (c == '.')
					{
						this.estado = eEstado.PontoDigitos;
						TextoSaida += c;
					}
					else if (Character.isDigit(c)) 
					{
						this.estado = eEstado.Digitos;
						TextoSaida += c;
					}
					else if (c == 'E') 
					{
						this.estado = eEstado.EstE;
						TextoSaida += c;
					}
					else
					{
						valido = false;
					}
					break;
				case PontoDigitos:
					if (Character.isDigit(c)) 
					{
						this.estado = eEstado.PontoDigitos;
						TextoSaida += c;
					}
					else if (c == 'E')
					{
						this.estado = eEstado.EstE;
						TextoSaida += c;
					}
					else 
					{
						valido = false;
					}
					break;
				case EstE:
					if (c == '+' || c == '-')
					{
						this.estado = eEstado.Sinais2;
						TextoSaida += c;
					}
					else
					{
						valido = false;
					}
					break;
				case Sinais2:
					if (Character.isDigit(c)) 
					{
						this.estado = eEstado.Digitos2;
						TextoSaida += c;
					}
					else
					{
						valido = false;
					}
					break;
				case Digitos2:
					if (Character.isDigit(c)) 
					{
						this.estado = eEstado.Digitos2;
						TextoSaida += c;
					}
					else
					{
						valido = false;
					}
					break;
				default:
					continue;
			}
		}
		return valido;
	}
}
