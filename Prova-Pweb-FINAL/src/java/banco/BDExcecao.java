package banco;

public class BDExcecao extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    public BDExcecao(String msg){
        super(msg);  
    }
    
    @Override
    public String toString() {
        return "Erro na conexão com o Banco de dados";
    }
}
