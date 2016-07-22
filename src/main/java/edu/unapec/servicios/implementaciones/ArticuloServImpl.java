package edu.unapec.servicios.implementaciones;

import edu.unapec.entidades.Articulo;
import edu.unapec.repositorios.interfaces.ArticuloRepIF;
import edu.unapec.respuestas.RespuestaProcesoExcel;
import edu.unapec.servicios.interfaces.ArticuloServIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by WillieManuel on 16/7/16.
 */
@Service("articuloServImpl")
public class ArticuloServImpl implements ArticuloServIF {

    private ArticuloRepIF articuloRepIF;

    @Override
    public List<Articulo> obtenerArticulos() {
        return articuloRepIF.obtenerArticulos();
    }

    @Override
    public void escribirProcesoArticulos(RespuestaProcesoExcel articulosProceso) {
        articuloRepIF.escribirProcesoArticulos(articulosProceso);
    }

    @Override
    public RespuestaProcesoExcel procesarValoresExcel(){

        RespuestaProcesoExcel respuesta = new RespuestaProcesoExcel();
        List<Articulo> articulos = this.obtenerArticulos();

        int cantidadArticulos = 0;
        int cantidadArticulosGeneral = 0;
        double ingresosNetos = 0.0;
        double impuestos = 0.0;
        double ingresosBrutos = 0.0;

        for (Articulo articulo : articulos){
            cantidadArticulos += 1;
            cantidadArticulosGeneral += articulo.getCantidad();
            ingresosNetos += articulo.getSubTotal();
            impuestos += articulo.getImpuesto();
            ingresosBrutos += articulo.getTotal();
        }

        respuesta.setCantidadArticulos(cantidadArticulos);
        respuesta.setCantidadArticulosGeneral(cantidadArticulosGeneral);
        respuesta.setIngresosNetos(ingresosNetos);
        respuesta.setImpuestos(impuestos);
        respuesta.setIngresosBrutos(ingresosBrutos);
        this.escribirProcesoArticulos(respuesta);

        return respuesta;
    }

    @Autowired
    public void setArticuloRepIF(ArticuloRepIF articuloRepIF) {
        this.articuloRepIF = articuloRepIF;
    }
}
