package com.mycompany.provauniversidade;

public class ProvaUCB extends ProvaUniversidade {
    public ProvaUCB(double notaAV1, double notaAV2) {
        super(notaAV1, notaAV2);
    }

    // Método para verificar se o aluno foi aprovado
    public boolean aprovado() {
        return calcularMedia() >= 7;
    }
}
