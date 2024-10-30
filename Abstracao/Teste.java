package com.mycompany.provauniversidade;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Capturando notas para ProvaUCB
        System.out.print("Digite a nota AV1 do aluno UCB: ");
        double av1UCB = scanner.nextDouble();
        System.out.print("Digite a nota AV2 do aluno UCB: ");
        double av2UCB = scanner.nextDouble();
        
        ProvaUCB provaUCB = new ProvaUCB(av1UCB, av2UCB);
        System.out.println("Aluno UCB - Aprovado? " + (provaUCB.aprovado() ? "Sim" : "Não"));

        // Capturando notas para ProvaFafifo
        System.out.print("Digite a nota AV1 do aluno Fafifo: ");
        double av1Fafifo = scanner.nextDouble();
        System.out.print("Digite a nota AV2 do aluno Fafifo: ");
        double av2Fafifo = scanner.nextDouble();

        ProvaFafifo provaFafifo = new ProvaFafifo(av1Fafifo, av2Fafifo);
        System.out.println("Aluno Fafifo - Aprovado? " + (provaFafifo.aprovado() ? "Sim" : "Não"));

        scanner.close(); // Fechar o scanner
    }
}
