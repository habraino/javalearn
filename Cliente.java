public class Cliente {
	private String nome = null;
	private double saldo = 0.0;
	private double reputacao = 100;
	//private String[] colecao = new String[100];

	public boolean AdCliente(String n, double s) {
		if(n.length() > 1 && s > 0) {
			this.nome = n;
			this.saldo = s;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean AdArtigo(String n, double v) {
		if(n.length() > 1 && v > 0) {
			return true;
		}
		return false;
	}

	public void addSaldo(double valor) {
		if (valor > 0) {
			this.saldo += valor;
		}
	}

	public double mostraSaldo() {
		return this.saldo;
	}

	public String getNome() {
		return this.nome;
	}

	public double getSaldo() {
		return this.saldo;
	}

	@Override
	public String toString() {
		return "Nome: "+ this.nome +"\nSaldo: " + this.saldo + "\nReputação: "+ this.reputacao;
	}
}
	