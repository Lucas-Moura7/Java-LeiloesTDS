/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class ProdutosDTO {
    private Integer id;
    private String nome;
    private double valor;

    public ProdutosDTO() {
    }

    public ProdutosDTO(Integer id, String nome, double valor, String status) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.status = status;
    }
    
    
    
    private String status;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
