import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

/**
 * Esta classe fornece um métodos utilitários
 */
public class Utilss {

    /**
     * Salva uma string no arquivo de texto especificado.
     *
     * @param dadosParaAcrescentar A string a ser salva no arquivo.
     * @throws IOException Se ocorrer um erro de E/S durante a operação.
     */
    public static void salvarNoArquivoTxt(String dadosParaAcrescentar) throws IOException {
        String caminhoDoArquivo = "Relatorio.txt"; // Corrigido o caminho do arquivo

        try {
            // Verifique se o arquivo existe, crie-o se não existir
            if (Files.notExists(Path.of(caminhoDoArquivo))) {
                Files.createFile(Path.of(caminhoDoArquivo));
                // Se o arquivo foi criado, escreva o cabeçalho
                BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoDoArquivo, true));
                writer.write(
                        "array length;array id;Sort type;start time;comparisons;swaps;end time;duration (milliseconds)");
                writer.newLine();
                writer.close();
            }

            // Abra o arquivo no modo de anexação (append) para adicionar dados ao final
            BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoDoArquivo, true));
            writer.write(dadosParaAcrescentar);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados no arquivo: " + e.getMessage());
        }
    }

    public static void salvarNoArquivoCSV(String dadosParaAcrescentar) throws IOException {
        String caminhoDoArquivo = "Relatorio.csv";

        try {
            // Verifique se o arquivo existe, crie-o se não existir
            if (Files.notExists(Path.of(caminhoDoArquivo))) {
                Files.createFile(Path.of(caminhoDoArquivo));

                // Se o arquivo foi criado, escreva o cabeçalho
                BufferedWriter headerWriter = new BufferedWriter(new FileWriter(caminhoDoArquivo));
                headerWriter.write(
                        "array length;array id;Sort type;start time;comparisons;swaps;end time;duration (milliseconds)");
                headerWriter.newLine();
                headerWriter.close();
            }

            // Abra o arquivo no modo de anexação (append) para adicionar dados ao final
            BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoDoArquivo, true));
            writer.write(dadosParaAcrescentar);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados no arquivo CSV: " + e.getMessage());
        }
    }

    public static void salvarNoArquivoCSV(String dadosParaAcrescentar, String path) throws IOException {
        String caminhoDoArquivo = path;

        try {
            // Verifique se o arquivo existe, crie-o se não existir
            if (Files.notExists(Path.of(caminhoDoArquivo))) {
                Files.createFile(Path.of(caminhoDoArquivo));

                // Se o arquivo foi criado, escreva o cabeçalho
                BufferedWriter headerWriter = new BufferedWriter(new FileWriter(caminhoDoArquivo));
                headerWriter.write(
                        "array length;array id;Sort type;start time;comparisons;swaps;end time;duration (milliseconds)");
                headerWriter.newLine();
                headerWriter.close();
            }

            // Abra o arquivo no modo de anexação (append) para adicionar dados ao final
            BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoDoArquivo, true));
            writer.write(dadosParaAcrescentar);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados no arquivo CSV: " + e.getMessage());
        }
    }

    /**
     * Gera um número aleatório no intervalo [1, 2147483].
     *
     * @return Um número aleatório no intervalo [1, 2147483].
     */
    public static int gerarNumeroAleatorio() {
        int min = 1;
        int max = 2147483;
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
