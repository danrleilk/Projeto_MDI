
public class Professor {

    private String cod_prof;
    private String nome_prof;
    private String senha_prof;

    public void set_data(String codigo, String nome, String senha) {
        this.cod_prof = codigo;
        this.nome_prof = nome;
        this.senha_prof = senha;
    }

    public String get_codigo() {
        return cod_prof;
    }

    public String get_nome() {
        return nome_prof;
    }

    // dont think this function should really exist ? can somebody look here?
    public String get_senha() {
        return senha_prof;
    }

}
