import java.util.ArrayList;

public abstract class Usuario {
    private String nome;
    private String sobrenome;
    private String contaUsuario;
    private String genero;
    private String senha;
    private Publicacao<Usuario> publicacao;
    private ArrayList<Publicacao> listaPublicacoes  = new ArrayList<>();

    public Usuario(String nome, String sobrenome, String contaUsuario, String genero, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.contaUsuario = contaUsuario;
        this.genero = genero;
        this.senha = senha;
    }

    public abstract String publicar(String necessidade, String mensagem) throws StringException;
    public abstract String apagarPublicacao(int indexPublicacao);

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getContaUsuario() {
        return contaUsuario;
    }

    public String getGenero() {
        return genero;
    }

    public String getSenha() {
        return senha;
    }

    public Publicacao<Usuario> getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao<Usuario> publicacao) {
        this.publicacao = publicacao;
    }

    public void setListaPublicacoes(ArrayList<Publicacao> listaPublicacoes) {
        this.listaPublicacoes = listaPublicacoes;
    }

    public ArrayList<Publicacao> getListaPublicacoes() {
        return listaPublicacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setContaUsuario(String contaUsuario) {
        this.contaUsuario = contaUsuario;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", contaUsuario='" + contaUsuario + '\'' +
                ", genero='" + genero + '\'' +
                ", senha='" + senha + '\'' +
                ", publicacao=" + publicacao +
                ", listaPublicacoes=" + listaPublicacoes +
                '}';
    }
}
