public class Causa {
    private Publicacao<Usuario> publicacao;

    public Causa(Publicacao<Usuario> publicacao) {
        this.publicacao = publicacao;
    }

    public Publicacao<Usuario> getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao<Usuario> publicacao) {
        this.publicacao = publicacao;
    }

    @Override
    public String toString() {
        return "Causa{" +
                "Publicacao existente: " + publicacao +
                '}';
    }
}
