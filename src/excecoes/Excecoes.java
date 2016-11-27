package excecoes;

public class Excecoes extends Exception{
    public Excecoes(){
     super("Ocorreu um erro na aplicação. Tente novamente");   
    }
    
    public Excecoes(String msg){
        super(msg);
    }
}
