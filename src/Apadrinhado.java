import java.util.ArrayList;

public class Apadrinhado extends Usuario implements ValidadorString{

    public Apadrinhado(String nome, String sobrenome, String contaUsuario, String genero, String senha) throws StringException {
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

    @Override
    public String publicar(String necessidade, String mensagem) throws StringException{
//        Instancia uma publicação caso esteja tudo correto e a adiciona ao array de publicações do usuário
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
            resultado = "Algo inesperado aconteceu.";

        return resultado;
    }

    public String solicitarAjuda(Padrinho padrinho, int indexPublicacao) {//método de solicitação de ajuda onde é
        // escolhido um padrinho para pedir ajuda e informada qual a publicação será enviada como uma causa a esse
        // padrinho.
        ArrayList<Publicacao> listaPublicacao = this.getListaPublicacoes();
        if (listaPublicacao.contains(listaPublicacao.get(indexPublicacao))) {
            Publicacao<Usuario> publicacao = listaPublicacao.get(indexPublicacao);
            String habilidadeSolicitada = publicacao.getNecessidade();
            ArrayList<String> habilidadesDoPadrinho = padrinho.getListaHabilidades();
            if (habilidadesDoPadrinho.contains(habilidadeSolicitada)) {
                Causa causa = new Causa(publicacao);
                padrinho.setCausa(causa);
                return "Solicitação de ajuda enviada com sucesso!";
            } else
                return "Infelizmente o padrinho contatado não pode te ajudar com essa necessidade: (" + publicacao.getNecessidade() + ")";
        }
        return "Publicação informada não encontrada! Por favor, informe uma publicação existente.";
    }
    @Override//método de validar entradas
    public boolean validarString(String campo) {
        return campo.toLowerCase().matches("^[[ ]|\\p{L}*]+$");
    }


    @Override
    public String toString() {
        return "Apadrinhado{" +
                "nome='" + super.getNome()+ '\'' +
                ", sobrenome='" + super.getSobrenome() + '\'' +
                ", contaUsuario='" + super.getContaUsuario() + '\'' +
                ", genero='" + super.getGenero() + '\'' +
//                ", senha='" + super.getSenha() + '\'' + (linha comentada para não exibir senha indevidamente) ;)
                '}';
    }
}
