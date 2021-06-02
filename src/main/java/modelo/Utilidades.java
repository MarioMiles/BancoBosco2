/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author mario
 */
public class Utilidades {
    public static ArrayList<String> calculaMeses(){
        int mes = 0;
        ArrayList<String>listaMeses=new ArrayList<String>();
        for(int i=0;i<=15;i++){
            mes=mes+12;
            listaMeses.add(String.valueOf(mes));
        }
        return listaMeses;
        
    }
    public ArrayList<Cuota> listaCuotas(int numCuotas, double importeTotalPrestamo){
        ArrayList<Cuota> listaCuotas= new ArrayList<Cuota>();
        for(int i=1; i<=numCuotas; i++){
            int numeroCuota=1;
            double importeCuota=importeTotalPrestamo/numCuotas;
            double intereses = importeCuota-(importeCuota*(i-1))/numCuotas;
            double capital=importeCuota-intereses;
            
            Cuota cu= new Cuota(numeroCuota, importeCuota, intereses, capital);
            listaCuotas.add(cu);
        }
        return listaCuotas;
    }
    
}
