package edu.unapec.controladores;

import edu.unapec.entidades.Articulo;
import edu.unapec.entidades.ArticulosProceso;
import edu.unapec.servicios.implementaciones.ArticuloServImpl;
import edu.unapec.servicios.interfaces.ArticuloServIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by WillieManuel on 16/7/16.
 */
@Controller
public class ExcelControladora {

    @Autowired
    ApplicationContext applicationContext;
    private String _index = "/WEB-INF/index";

    @RequestMapping(value = "inicio", method = RequestMethod.GET)
    public ModelAndView inicio(Model model){
        model.addAttribute("articulosProceso", new ArticulosProceso());
        return new ModelAndView(_index);
    }

    @RequestMapping(value = "procesarExcel", method = RequestMethod.GET)
    public ModelAndView inicio2(Model model){
        ArticulosProceso articulosProceso = realizarProceso();
        model.addAttribute("articulosProceso", articulosProceso);
        return new ModelAndView(_index);
    }

    private ArticulosProceso realizarProceso(){

        ArticulosProceso articulosProceso = new ArticulosProceso();
        ArticuloServIF articuloServIF = (ArticuloServImpl) applicationContext.getBean("articuloServImpl");
        List<Articulo> articulos = articuloServIF.obtenerArticulos();

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

        articulosProceso.setCantidadArticulos(cantidadArticulos);
        articulosProceso.setCantidadArticulosGeneral(cantidadArticulosGeneral);
        articulosProceso.setIngresosNetos(ingresosNetos);
        articulosProceso.setImpuestos(impuestos);
        articulosProceso.setIngresosBrutos(ingresosBrutos);
        articuloServIF.escribirProcesoArticulos(articulosProceso);

        return articulosProceso;
    }
}
