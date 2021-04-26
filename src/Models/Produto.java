/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


/**
 *
 * @author Dênis
 */
public class Produto {
    private int id;
    private String nome;
    private String marca;
    private String modelo;
    private String preco;

    public Produto(int id, String nome, String marca, String modelo, String preco) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
    }
    
    public Produto(String nome, String marca, String modelo, String preco) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
}
