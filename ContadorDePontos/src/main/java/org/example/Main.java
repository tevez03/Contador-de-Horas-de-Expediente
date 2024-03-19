package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Seja bem vindo ao contador de pontos");
        LocalDate localDate = LocalDate.now();
        System.out.println("A data atual e: " + localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println("A hora atual e: " + localTime);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Qual e seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o horario da entrada (formato HH.MM): ");
        String entradaStr = scanner.nextLine();
        LocalTime entrada = converterParaLocalTime(entradaStr);

        System.out.println("Digite o horario da saída para o almoco (formato HH.MM): ");
        String saidaAlmocoStr = scanner.nextLine();
        LocalTime saidaAlmoco = converterParaLocalTime(saidaAlmocoStr);

        System.out.println("Digite o horario do retorno do almoco (formato HH.MM): ");
        String retornoAlmocoStr = scanner.nextLine();
        LocalTime retornoAlmoco = converterParaLocalTime(retornoAlmocoStr);

        System.out.println("Digite o horario da saida (formato HH.MM): ");
        String saidaStr = scanner.nextLine();
        LocalTime saida = converterParaLocalTime(saidaStr);

        long tempoTotalMinutos = calcularTempoTrabalhado(entrada, saidaAlmoco, retornoAlmoco, saida);

        long horas = tempoTotalMinutos / 60;
        long minutos = tempoTotalMinutos % 60;

        System.out.println("O tempo trabalhado foi: " + horas + " horas e " + minutos + " minutos");
        System.out.println("Ate amanha sr." + nome);
    }

    private static LocalTime converterParaLocalTime(String horaStr) {
        String[] partes = horaStr.split("\\.");
        int horas = Integer.parseInt(partes[0]);
        int minutos = Integer.parseInt(partes[1]);
        return LocalTime.of(horas, minutos);
    }

    private static long calcularTempoTrabalhado(LocalTime entrada, LocalTime saidaAlmoco, LocalTime retornoAlmoco, LocalTime saida) {
        long tempoTotalMinutos = saida.toSecondOfDay() - entrada.toSecondOfDay() -
                (retornoAlmoco.toSecondOfDay() - saidaAlmoco.toSecondOfDay());
        return tempoTotalMinutos / 60;
    }
}