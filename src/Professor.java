
public class Professor {

    private String codigo;
    private String nome;
    private String senha;

    public void set_data(String codigo, String nome, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.senha = senha;
    }

    public String get_codigo() {
        return codigo;
    }

    public String get_nome() {
        return nome;
    }

    // dont think this function should really exist ? can somebody look here?
    public String get_senha() {
        return senha;
    }

}
