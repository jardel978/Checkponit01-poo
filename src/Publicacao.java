import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Publicacao<Usuario> {
    private Random random = new Random();//para gerar um ID para a publicação
    private int id;
    private LocalDateTime dataTime;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");//definindo formato para data
    private String dataTimeFormatada;
    private Usuario criador;
    private String necessidade;
    private String mensagem;

    public Publicacao(Usuario criador, String necessidade, String mensagem) {
            this.dataTime = LocalDateTime.now();//pegando data local no momento da instanciação da publicação
            this.dataTimeFormatada = dataTime.format(formato);//formatando data
            this.id = random.nextInt(1700);
            this.criador = criador;
            this.necessidade = necessidade.toLowerCase();
            this.mensagem = mensagem;
    }


    public int getId() {
        return id;
    }

    public Usuario getCriador() {
        return criador;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public String getNecessidade() {
        return necessidade;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDataTimeFormatada() {
        return dataTimeFormatada;
    }

    @Override
    public String toString() {
        return "Publicacao{" +
                ", id=" + id +
                ", dataTimeFormatada='" + dataTimeFormatada + '\'' +
                ", criador=" + criador +
                ", necessidade='" + necessidade + '\'' +
                ", mensagem='" + mensagem + '\'' +
                '}';
    }
}
