package edu.unapec.servicios.implementaciones;

import edu.unapec.entidades.Articulo;
import edu.unapec.entidades.ArticulosProceso;
import edu.unapec.repositorios.interfaces.ArticuloRepIF;
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
    public void escribirProcesoArticulos(ArticulosProceso articulosProceso) {
        articuloRepIF.escribirProcesoArticulos(articulosProceso);
    }

    @Autowired
    public void setArticuloRepIF(ArticuloRepIF articuloRepIF) {
        this.articuloRepIF = articuloRepIF;
    }
}
