/*
int a=AGI;
while(a<0)
{
    a=a-5;
    if(a<5)bono+=(a/2)*5
    else{
        
    }
}
int bono
 */
package Elementos;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author jrs
 */
public class Personaje 
{
    public static final int GUERRERO=1;
    public static final int GUERREROACROBATA=2;
    public static final int PALADIN=3;
    public static final int PALADINOSCURO=4;
    public static final int MAESTROARMAS=5;
    public static final int TECNICISTA=6;
    public static final int TAOISTA=7;
    public static final int EXPLORADOR=8;
    public static final int SOMBRA=9;
    public static final int LADRON=10;
    public static final int ASESINO=11;
    public static final int HECHICERO=12;
    public static final int WARLOCK=13;
    public static final int ILUSIONISTA=14;
    public static final int HECHICEROMENTALISTA=15;
    public static final int CONJURADOR=16;
    public static final int GUERREROCONJURADOR=17;
    public static final int MENTALISTA=18;
    public static final int GUERREROMENTALISTA=19;
    public static final int NOVEL=20;
    String nombre;
    ArrayList <String> caracteristicas;
    TreeMap <String, Integer> valorCaracteristicas,valorBonificadores;
    int puntosVida, HA, HP, HE, llevarArmadura;
    int turno, cansancio, RF, RE, RV, RM, RP, advertir, movimiento, nivel;
    int ACT, zeon, proyeccionMagica;
    int CV, proyeccionMental;
    int categoria;
    public Personaje(String nombre, int categoria,
            int nivel, int AGI, int CON, int DES, int FUE, int INT, int PER, int POD, int VOL, 
            int HA, int HP, int HE, int llevarArmadura, int advertir,
            int ACT, int zeon, int proyeccionMagica,
            int CV, int proyeccionMental)
    {
        this.nombre=nombre;
        this.nivel=nivel;
        this.categoria=categoria;
        //rellenarMaps();
        valorCaracteristicas=new TreeMap();
        valorBonificadores=new TreeMap();
        valorCaracteristicas.put("AGI", AGI);
        valorCaracteristicas.put("CON", CON);
        valorCaracteristicas.put("DES", DES);
        valorCaracteristicas.put("FUE", FUE);
        valorCaracteristicas.put("INT", INT);
        valorCaracteristicas.put("PER", PER);
        valorCaracteristicas.put("POD", POD);
        valorCaracteristicas.put("VOL", VOL);
        valorBonificadores.put("AGI", calcularBono(AGI));
        valorBonificadores.put("CON", calcularBono(CON));
        valorBonificadores.put("DES", calcularBono(DES));
        valorBonificadores.put("FUE", calcularBono(FUE));
        valorBonificadores.put("INT", calcularBono(INT));
        valorBonificadores.put("PER", calcularBono(PER));
        valorBonificadores.put("POD", calcularBono(POD));
        valorBonificadores.put("VOL", calcularBono(VOL));
        this.HA=HA;
        this.HP=HP;
        this.HE=HE;
        this.llevarArmadura=llevarArmadura;
        this.advertir=advertir;
        this.ACT=ACT;
        this.zeon=zeon;
        this.proyeccionMagica=proyeccionMagica;
        this.CV=CV;
        this.proyeccionMental=proyeccionMental;
    }
    
    void rellenarMaps()
    {/*
        caracteristicas=new ArrayList(8);
        caracteristicas.add("AGI");
        caracteristicas.add("CON");
        caracteristicas.add("DES");
        caracteristicas.add("FUE");
        caracteristicas.add("INT");
        caracteristicas.add("PER");
        caracteristicas.add("POD");
        caracteristicas.add("VOL");*/
        valorCaracteristicas=new TreeMap();
        valorBonificadores=new TreeMap();
        for(int a=0;a<caracteristicas.size();a++)
        {
            valorCaracteristicas.put(caracteristicas.get(a), 0);
            valorBonificadores.put(caracteristicas.get(a), 0);
        }
    }
    void putVida(int multiplos)
    {
        int bonoPD=multiplos*valorCaracteristicas.get("CON");
        int base=calcularVidaBase();
        int bonoCat=calcularVidaCategoria();
        puntosVida=bonoPD+base+bonoCat;
    }
    int calcularVidaCategoria()
    {
        int res=0;
        switch(categoria)
        {
            case TECNICISTA:SOMBRA:LADRON:ASESINO:HECHICERO:ILUSIONISTA:HECHICEROMENTALISTA:CONJURADOR:MENTALISTA:NOVEL:res=nivel*5;break;
            case GUERREROACROBATA:TAOISTA:EXPLORADOR:WARLOCK:GUERREROCONJURADOR:GUERREROMENTALISTA:res=nivel*10;break;
            case GUERRERO:PALADIN:PALADINOSCURO:res=nivel*15;break;
            case MAESTROARMAS:res=nivel*20;break;
        }
        return res;
    }
    int calcularVidaBase()
    {
        int res=0;
        switch(valorCaracteristicas.get("CON"))
        {
            case 1:res=5;break;
            case 2:res=20;break;
            case 3:res=40;break;
            case 4:res=55;break;
            case 5:res=70;break;
            case 6:res=85;break;
            case 7:res=95;break;
            case 8:res=110;break;
            case 9:res=120;break;
            case 10:res=135;break;
            case 11:res=150;break;
            case 12:res=160;break;
            case 13:res=175;break;
            case 14:res=185;break;
            case 15:res=200;break;
            case 16:res=215;break;
            case 17:res=225;break;
            case 18:res=240;break;
            case 19:res=250;break;
            case 20:res=265;break;
        }
        return res;
    }
    static int calcularBono(int caracteristica)
    {
        int bono=0;
        int a=caracteristica;
        
        if(a<5)
        {
            switch(a)
            {
                case 1:bono=-30;break;
                case 2:bono=-20;break;
                case 3:bono=-10;break;
                case 4:bono=-5;break;
            }
        }
        a+=-5;
        
        while(a>0)
        {
            if(a<5)
            {
                int calculo=(int)Math.round(a/2.0);
                System.out.println("Division: "+calculo);
                calculo=calculo*5;
                System.out.println("Multiplicacion: "+calculo);
                
                bono+=calculo;
            }else bono+=15;
            a+=-5;
        }
        return bono;
    }
}
