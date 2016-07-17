package edu.unapec.entidades;

/**
 * Created by WillieManuel on 16/7/16.
 */
public class ArticulosProceso {

    private int cantidadArticulos;
    private int cantidadArticulosGeneral;
    private double ingresosNetos;
    private double impuestos;
    private double ingresosBrutos;

    public int getCantidadArticulos() {
        return cantidadArticulos;
    }

    public void setCantidadArticulos(int cantidadArticulos) {
        this.cantidadArticulos = cantidadArticulos;
    }

    public int getCantidadArticulosGeneral() {
        return cantidadArticulosGeneral;
    }

    public void setCantidadArticulosGeneral(int cantidadArticulosGeneral) {
        this.cantidadArticulosGeneral = cantidadArticulosGeneral;
    }

    public double getIngresosBrutos() {
        return ingresosBrutos;
    }

    public void setIngresosBrutos(double ingresosBrutos) {
        this.ingresosBrutos = ingresosBrutos;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getIngresosNetos() {
        return ingresosNetos;
    }

    public void setIngresosNetos(double ingresosNetos) {
        this.ingresosNetos = ingresosNetos;
    }
}
