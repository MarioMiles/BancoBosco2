/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author mario
 */
public class Prestamo {
    private double capital;
    private double interes;
    private int mesActual;
    private double importePrestamo;

    public Prestamo(double capital, double interes, int mesActual) {
        this.capital = capital;
        this.interes = interes;
        this.mesActual = mesActual;
        importePrestamo= ((capital*interes*mesActual)/1200)+capital;
        
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getMesActual() {
        return mesActual;
    }

    public void setMesActual(int mesActual) {
        this.mesActual = mesActual;
    }

    public double getImportePrestamo() {
        return importePrestamo;
    }

    public void setImportePrestamo(double importePrestamo) {
        this.importePrestamo = importePrestamo;
    }
    
    
    
}
