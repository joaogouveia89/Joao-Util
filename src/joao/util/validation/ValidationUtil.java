package joao.util.validation;

public class ValidationUtil {
	
	public static boolean validarCPF(String cpf){
		String regexString;
		int referencia = 0;
		int number;
		int primeiroDigitoCalculado;
		int segundoDigitoCalculado;
		int primeiroDigitoCalculadoFornecido;
		int segundoDigitoCalculadoFornecido;
		int t1 = 0;
		int t2 = 0;
		
		//O numero de digitos do CPF deve ser igual a 11
		if(cpf.length() == 11){
			//Todo o CPF deve conter apenas numeros
			if(cpf.matches("[0-9]+")){
				//Os números não podem ser iguais
				for(int n = 0; n<10; n++){
					regexString = n+"{11}";
					if(cpf.matches(regexString)){
						return false;
					}
				}
				
				//Cálculo do DV
				
				//Digito 1
				for(int n = 10; n>=2; n--){
					number = Character.getNumericValue(cpf.charAt(referencia));
					t1 += (number*n);
					referencia++;					
				}
				primeiroDigitoCalculado = 11-(t1%11);
				if(primeiroDigitoCalculado > 9){
					primeiroDigitoCalculado = 0;
				}
				
				//Dígito 2
				
				referencia = 0;
				for(int n = 11; n>=2; n--){
					number = Character.getNumericValue(cpf.charAt(referencia));
					t2 += (number*n);
					referencia++;					
				}
				segundoDigitoCalculado = 11-(t2%11);
				if(segundoDigitoCalculado > 9){
					segundoDigitoCalculado = 0;
				}
				
				//Comparando digitos verificadores fornecidos com os calculados
				primeiroDigitoCalculadoFornecido = Character.getNumericValue(cpf.charAt(9));
				segundoDigitoCalculadoFornecido = Character.getNumericValue(cpf.charAt(10));
				if(primeiroDigitoCalculadoFornecido == primeiroDigitoCalculado && segundoDigitoCalculadoFornecido == segundoDigitoCalculado){
					return true;
				}
				else{
					return false;
				}				
			}
		}
		else{
			return false;
		}
		return false;
	}
	
	/**
	 * Método validarCNPJ - Validação do DV do CNPJ
	 * @param cnpj String com o CNPJ
	 * @return true para CNPJ com DV correto
	 */
	public static boolean validarCNPJ(String cnpj){
		
		int T1 = 0;
		int primeiroDigitoFornecido;
		int primeiroDigitoCalculado;
		int T2 = 0;
		int segundoDigitoFornecido;
		int segundoDigitoCalculado;
		int referencia = 0;
		int number;
		
		//O numero de digitos do CPF deve ser igual a 14
		if(cnpj.length() == 14){
			//Todo CNPJ deve conter apenas números
			if(cnpj.matches("[0-9]+")){
				
				//Digito 1
				for(int n=5 ; n>=2; n--){
					number = Character.getNumericValue(cnpj.charAt(referencia));
					T1 += number*n;
					referencia++;
				}
				for(int n=9; n>=2; n--){
					number = Character.getNumericValue(cnpj.charAt(referencia));
					T1+=number*n;
					referencia++;
				}
				primeiroDigitoCalculado = 11-(T1%11);
				if(primeiroDigitoCalculado > 9){
					primeiroDigitoCalculado = 0;
				}
				
				//Digito 2
				referencia = 0;
				for(int n=6 ; n>=2; n--){
					number = Character.getNumericValue(cnpj.charAt(referencia));
					T2 += number*n;
					referencia++;
				}
				for(int n=9; n>=2; n--){
					number = Character.getNumericValue(cnpj.charAt(referencia));
					T2+=number*n;
					referencia++;
				}
				segundoDigitoCalculado = 11-(T2%11);
				if(segundoDigitoCalculado > 9){
					segundoDigitoCalculado = 0;
				}
				
				primeiroDigitoFornecido = Character.getNumericValue(cnpj.charAt(12));
				segundoDigitoFornecido = Character.getNumericValue(cnpj.charAt(13));
				
				if(primeiroDigitoCalculado == primeiroDigitoFornecido && segundoDigitoCalculado == segundoDigitoFornecido){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Método validarEmail - Validação básica de E-mail
	 * @param email String com o E-mail
	 * @return true para E-mail válido
	 */
	
	public static boolean validarEmail(String email){
		/*
		 * Explicação:
		 * A expressão regular abaixo procura no começo da string (^) ou (|) no
		 * fim da string ($) os caracteres do conjunto [@.], ou seja será buscada
		 * uma correspondencia desses caracteres no começo e no fim da string
		 */
		if(!email.matches(".*(^[@.]|[@.]$).*")){
			/*
			 * Explicação:
			 * A expressão regular abaixo procura na string dois pontos seguidos
			 */
				if(!email.matches(".*[.]{2,}.*")){
					/*
					 * Explicação:
					 * A expressão regular abaixo procura no final da string um
					 * ponto seguido de no mínimo 2 e no máximo 3 caracteres [2.3]
					 */
					if(email.matches(".*[.]{1}[a-z]{2,3}$.*")){
						return true;
					}
				}
		}
		return false;
	}
	
	/**
	 * Método validarData - Validação básica de data
	 * @param s String com a data
	 * @return true para data válida ou false para data inválida
	 */
	
	public static boolean validarData(String s){
		if(s.length() == 10 && s.charAt(2) == '/' && s.charAt(5) == '/'){
			String dataSplit[] = s.split("/");
			int dia = Integer.parseInt(dataSplit[0]);
			int mes = Integer.parseInt(dataSplit[1]);
			
			if(mes == 2){
				if(dia <= 28 && dia >= 1){
					return true;
				}
			}
			else if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
				if(dia <= 30 && dia >= 1){
					return true;
				}
			}
			else{
				if(dia <= 31 && dia >= 1){
					return true;
				}
			}
		}
		return false;
	}

}
