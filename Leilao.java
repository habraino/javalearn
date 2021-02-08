class Leilao {
    private String nomeLeilao;
    private boolean estado = false;

    // atributos para artigos
    private String nLeilao = null;
    private String nArtigo = null;
    private String nVendedor = null;
    private double pArtigo = 0.0;

    // metodo para criar leilão
    public boolean criarLeilao(String n) {
        if (n.length() > 1) {
            this.nomeLeilao = n;
            return true;
        }
        return false;
    }

    // metodo para adicionar artigos
    public boolean AdArtigo(String nLeilao, String nArtigo, String nVendedor, double pArtigo) {
        if (nLeilao.length() > 1 && nLeilao.length() > 1 && nArtigo.length() > 1 && nVendedor.length() > 1 && pArtigo > 0) {
            this.nLeilao = nLeilao;
            this.nArtigo = nArtigo;
            this.nVendedor = nVendedor;
            this.pArtigo = pArtigo;
            return true;
        } 
        return false;
    }

    // metodo para abrir leilão
    public boolean AbLeilao(String n) {
        if (n.length() > 1) {
            if (this.estado == false) {
                this.estado = true;
            }
        }
        return this.estado;
    }

    public String getNomeLeilao() {
        return nomeLeilao;
    }

    public boolean getEstadoLeilao() {
        return estado;
    }    
}