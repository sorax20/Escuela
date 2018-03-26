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
public class Armadura 
{
    String nombre;
    int filo, contundente, penetracion, calor, electricidad, frio, energia;
    int requerimiento, penalizadorNatural, restriccionMovimiento, entereza, presencia;
    public Armadura(String nombre, int filo, int contundente, int penetracion, int calor, int electricidad, int frio, int energia, int requerimiento, int penalizadorNatura, int restriccionMovimiento, int entereza,int presencia)
    {
        this.nombre=nombre;
        this.filo=filo;
        this.penetracion=penetracion;
        this.calor=calor;
        this.frio=frio;
        this.energia=energia;
        this.requerimiento=requerimiento;
        this.penalizadorNatural=penalizadorNatura;
        this.restriccionMovimiento=restriccionMovimiento;
        this.entereza=entereza;
        this.presencia=presencia;
    }
    public int getFilo(){return filo;}
    public int getContundente(){return contundente;}
}
