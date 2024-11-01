package com.projetolistatarefas.model;

import java.util.Date;

public class Tarefa {
    private int id;
    private String nome;
    private double custo;
    private Date dataLimite;
    private int ordemApresentacao;

    // Construtor completo
    public Tarefa(int id, String nome, double custo, Date dataLimite, int ordemApresentacao) {
        this.id = id;
        this.nome = nome;
        this.custo = custo;
        this.dataLimite = dataLimite;
        this.ordemApresentacao = ordemApresentacao;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getCusto() { return custo; }
    public void setCusto(double custo) { this.custo = custo; }

    public Date getDataLimite() { return dataLimite; }
    public void setDataLimite(Date dataLimite) { this.dataLimite = dataLimite; }

    public int getOrdemApresentacao() { return ordemApresentacao; }
    public void setOrdemApresentacao(int ordemApresentacao) { this.ordemApresentacao = ordemApresentacao; }
}
