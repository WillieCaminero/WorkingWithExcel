package edu.unapec.servicios.interfaces;

import edu.unapec.entidades.Articulo;
import edu.unapec.entidades.ArticulosProceso;

import java.util.List;

/**
 * Created by WillieManuel on 16/7/16.
 */
public interface ArticuloServIF {

    List<Articulo> obtenerArticulos();

    void escribirProcesoArticulos(ArticulosProceso articulosProceso);
}
