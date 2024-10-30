package com.mycompany.provauniversidade;

public class ProvaFafifo extends ProvaUniversidade {
    public ProvaFafifo(double notaAV1, double notaAV2) {
        super(notaAV1, notaAV2);
    }

    
    public boolean aprovado() {
        return calcularMedia() >= 6;
    }
}


