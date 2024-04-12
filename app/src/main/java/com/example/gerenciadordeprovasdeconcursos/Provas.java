package com.example.gerenciadordeprovasdeconcursos;

public class Provas {
    private int id;
    private String empresa;
    private String orgaoPublico;
    private String estado;
    private String ano;
    private String nivel;
    private String cargo;

    // Construtor
    public Provas(int id, String empresa, String orgaoPublico, String estado, String ano, String nivel, String cargo) {
        this.id = id;
        this.empresa = empresa;
        this.orgaoPublico = orgaoPublico;
        this.estado = estado;
        this.ano = ano;
        this.nivel = nivel;
        this.cargo = cargo;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getOrgaoPublico() {
        return orgaoPublico;
    }

    public void setOrgaoPublico(String orgaoPublico) {
        this.orgaoPublico = orgaoPublico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
