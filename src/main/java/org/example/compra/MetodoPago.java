package org.example.compra;

public class MetodoPago {
    private int id;
    private String tipo;
    private String titular;
    private String numeroEnmascarado;
    public MetodoPago(int id, String tipo, String titular, String numeroEnmascarado) {
        this.id = id;
        this.tipo = tipo;
        this.titular = titular;
        this.numeroEnmascarado = numeroEnmascarado;
    }
    public boolean verificarMetodo() {
        return titular != null && !titular.isBlank() && numeroEnmascarado != null && numeroEnmascarado.length() >= 4;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroEnmascarado() {
        return numeroEnmascarado;
    }

    public void setNumeroEnmascarado(String numeroEnmascarado) {
        this.numeroEnmascarado = numeroEnmascarado;
    }

}
