/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;

/**
 *
 * @author jrs
 */
public class Arma
{
    String nombre, tipo, critPrimario, critSecundario;
    int danyo, velocidad, entereza, rotura, fuerzaRequerida, presencia;
    String [] especial;
    public Arma(String nombre, String tipo, String critPrimario, String critSecundario, int danyo, int velocidad, int entereza, int rotura, int fuerzaRequerida, int presencia, String [] especial)
    {
        this.nombre=nombre;
        this.tipo=tipo;
        this.critPrimario=critPrimario;
        this.critSecundario=critSecundario;
        this.danyo=danyo;
        this.velocidad=velocidad;
        this.entereza=entereza;
        this.rotura=rotura;
        this.fuerzaRequerida=fuerzaRequerida;
        this.presencia=presencia;
        this.especial=especial;
    }
}
