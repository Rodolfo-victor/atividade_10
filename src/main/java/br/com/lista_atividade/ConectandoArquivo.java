package br.com.lista_atividade;

import java.io.*;

public class ConectandoArquivo {
    public static void main(String[] args) {
        try (BufferedWriter writer1 = new BufferedWriter(new FileWriter("arquivo1.txt"))) {
            writer1.write("Viva java.");
        } catch (IOException e) {
            System.err.println("Erro ao tentar criar o primerio arquivo: " + e.getMessage());
        }

        try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("arquivo2.txt"))) {
            writer2.write("Viva java POO.");
        } catch (IOException e) {
            System.err.println("Erro ao tentar criar o segundo arquivo: " + e.getMessage());
        }

        try (BufferedWriter writer3 = new BufferedWriter(new FileWriter("arquivo_concatenado.txt"))) {
            try (BufferedReader reader1 = new BufferedReader(new FileReader("arquivo1.txt"))) {
                String line;
                while ((line = reader1.readLine()) != null) {
                    writer3.write(line);
                    writer3.newLine();
                }
            } catch (IOException e) {
                System.err.println("Erro ao ler o primeiro arquivo: " + e.getMessage());
            }

            try (BufferedReader reader2 = new BufferedReader(new FileReader("arquivo2.txt"))) {
                String line;
                while ((line = reader2.readLine()) != null) {
                    writer3.write(line);
                    writer3.newLine();
                }
            } catch (IOException e) {
                System.err.println("Erro ao ler o segundo arquivo: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Erro ao tentar criar o terceiro arquivo: " + e.getMessage());
        }

        System.out.println("O primeiro e segundo arquivos, foram conectados com sucesso!.");
    }
}
