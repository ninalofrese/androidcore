package com.example.seuimc;

public class Opcao {
    private int imagem;
    private Pessoa pessoa;

    public Opcao(int imagem, Pessoa pessoa) {
        this.imagem = imagem;
        this.pessoa = pessoa;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
