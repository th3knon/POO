package com.mycompany.provauniversidade;

public class ProvaUniversidade {
    protected double notaAV1;
    protected double notaAV2;

    // Construtor da superclasse
    public ProvaUniversidade(double notaAV1, double notaAV2) {
        this.notaAV1 = notaAV1;
        this.notaAV2 = notaAV2;
    }

    // Método para calcular a média
    public double calcularMedia() {
        return (notaAV1 + notaAV2) / 2;
    }
}
