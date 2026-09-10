package Objetos;
import java.time.LocalDate; 
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Relatorio {
    

    private LocalDate dataGeracao; 
    private Estufa estufa;
    private double mediaTemperatura;
    private double mediaUmidade;
    private double mediaLuminosidade;
    private ArrayList<String> alertasGerados;

    public Relatorio(LocalDate dataGeracao, Estufa estufa, double mediaTemperatura, double mediaUmidade,
            double mediaLuminosidade, ArrayList<String> alertasGerados) {
        this.dataGeracao = dataGeracao;
        this.estufa = estufa;
        this.mediaTemperatura = mediaTemperatura;
        this.mediaUmidade = mediaUmidade;
        this.mediaLuminosidade = mediaLuminosidade;
        this.alertasGerados = alertasGerados;
    }

    public LocalDate getDataGeracao() {
        return dataGeracao;
    }

    public Estufa getEstufa() {
        return estufa;
    }

    public double getMediaTemperatura() {
        return mediaTemperatura;
    }

    public double getMediaUmidade() {
        return mediaUmidade;
    }

    public double getMediaLuminosidade() {
        return mediaLuminosidade;
    }

    public ArrayList<String> getAlertasGerados() {
        return alertasGerados;
    }

    public void setDataGeracao(LocalDate dataGeracao) {
        this.dataGeracao = dataGeracao;
    }

    public void setEstufa(Estufa estufa) {
        this.estufa = estufa;
    }

    public void setMediaTemperatura(double mediaTemperatura) {
        this.mediaTemperatura = mediaTemperatura;
    }

    public void setMediaUmidade(double mediaUmidade) {
        this.mediaUmidade = mediaUmidade;
    }

    public void setMediaLuminosidade(double mediaLuminosidade) {
        this.mediaLuminosidade = mediaLuminosidade;
    }

    public void setAlertasGerados(ArrayList<String> alertasGerados) {
        this.alertasGerados = alertasGerados;
    }

    public String gerarResumo() {
        return "Relatório da Estufa em " + dataGeracao.toString() +
               "\nMédia de Temperatura: " + mediaTemperatura +
               "\nMédia de Umidade: " + mediaUmidade +
               "\nMédia de Luminosidade: " + mediaLuminosidade +
               "\nAlertas Gerados: " + String.join(", ", alertasGerados);
    }

    public void salvarEmArquivo(String nomeArquivo) {
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(nomeArquivo));

            
            writer.write(gerarResumo());

            writer.newLine();
            writer.write("\nRelatório gerado automaticamente pelo sistema.");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o relatório em arquivo: " + e.getMessage());

        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (Exception e) {
                System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
            }
        }
    }

}
