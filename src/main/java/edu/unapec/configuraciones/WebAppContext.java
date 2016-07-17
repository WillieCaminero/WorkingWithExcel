package edu.unapec.configuraciones;

import edu.unapec.servicios.implementaciones.ArticuloServImpl;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan({"edu.unapec"})
@PropertySource("classpath:/propiedades/app.properties")
public class WebAppContext extends WebMvcConfigurerAdapter{


    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "articuloServImpl")
    @Scope("singleton")
    public ArticuloServImpl obtenerArticuloServImpl(){
        return new ArticuloServImpl();
    }

}
