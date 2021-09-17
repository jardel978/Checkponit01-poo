import java.util.ArrayList;

public class Padrinho extends Usuario implements ValidadorString{
    private Causa causa;
    private ArrayList<String> listaHabilidades = new ArrayList<String>();//array para receber as habilidades do Padrinho
    //A habilidade é usada para comparar com a necessidade do Apadrinhado, assim saberemos se esse Padrinho pode
    // mesmo ajudar.

    public Padrinho(String nome, String sobrenome, String contaUsuario, String genero, String senha) throws StringException {
        super(nome, sobrenome, contaUsuario, genero, senha);
        boolean vNome = !validarString(nome) || nome.equals("");
        boolean vSobrenome = !validarString(sobrenome) || sobrenome.equals("");
        boolean vContaUsuario = contaUsuario.equals("");
        boolean vGenero = !validarString(genero) || genero.equals("");
        if (vNome || vSobrenome || vContaUsuario || vGenero) {
            throw new StringException("Certifique-se de que não têm campos vazios ou com dados não compatíveis com " +
                    "Strings" +
                    "(Letras)");
        }
        if (senha.equals("") || senha.length() < 6) {
            throw new StringException("O campo (Senha) não pode estar vazio e deve conter ao menos 6(seis) caracteres");
        }
    }

    @Override//método de validar entradas
    public boolean validarString(String campo) {
        return campo.toLowerCase().matches("^[[ ]|\\p{L}*]+$");
    }

    @Override
    public String publicar(String necessidade, String mensagem) throws StringException{//instancia uma Publicação caso esteja tudo
        // certo e
        // adiciona ela ao array de publicações do usuário
        String resultado = "";
        if(!necessidade.equals("") && !mensagem.equals("")){
            Publicacao publicacao = new Publicacao(this, necessidade.toLowerCase(), mensagem);
            this.getListaPublicacoes().add(publicacao);
            resultado = "Publicação realizada com sucesso! " + "\n" + "Mensagem da publicação: " + publicacao.getMensagem();
        } else
            throw new StringException("Impossível realizar publicação: existe um ou mais campos vazios!");
        return resultado;
    }

    @Override
    public String apagarPublicacao(int indexPublicacao) {//verifica a existência de uma publicação no array de
        // publicações do usuário e, caso exista ela é removida pelo seu index nesse array
        String resultado = "";
        ArrayList<Publicacao> listaPublicacao = this.getListaPublicacoes();
        if(indexPublicacao >= listaPublicacao.size())
            resultado = "Essa publicação não existe ou já foi excluída anteriormente!";
        else if(listaPublicacao.contains(listaPublicacao.get(indexPublicacao))){
            listaPublicacao.remove(indexPublicacao);
            resultado = "Publicação excluída com sucesso!";
        } else
            resultado = "Algo inesperado aconteceu";

        return resultado;
    }

    public String ajudar() {
        if(causa != null) {
            return "Parabéns!!! Você acaba de ajudar alguém e está contribuindo para fazer do Mundo um lugar melhor! ";
        } else
            return "Incrível sua proatividade em ajudar o próximo! Você ainda não tem solicitação de ajuda, mas jajá " +
                    "isso muda! Aguarde e logo " +
                    "alguém te solicitará!";
    }

    public String informarNovaHabilidade(String habilidade) {
        if(!habilidade.equals("")) {
            listaHabilidades.add(habilidade.toLowerCase());
            return "Habilidade guardada com sucesso!";
        } else
            return "Habilidade inválida!";
    }

    public Causa getCausa() {
        return causa;
    }

    public ArrayList<String> getListaHabilidades() {
        return listaHabilidades;
    }

    public void setCausa(Causa causa) {
        this.causa = causa;
    }

    public void setListaHabilidades(ArrayList<String> listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }

    @Override
    public String toString() {
        return "Padrinho{" +
                "nome='" + super.getNome()+ '\'' +
                ", sobrenome='" + super.getSobrenome() + '\'' +
                ", contaUsuario='" + super.getContaUsuario() + '\'' +
                ", genero='" + super.getGenero() + '\'' +
//                ", senha='" + super.getSenha() + '\'' + (linha comentada para não exibir senha indevidamente) ;)
                "causa=" + causa +
                ", listaHabilidades=" + listaHabilidades +
                '}';
    }
}