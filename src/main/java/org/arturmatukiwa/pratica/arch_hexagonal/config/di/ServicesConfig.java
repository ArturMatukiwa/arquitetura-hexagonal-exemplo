package org.arturmatukiwa.pratica.arch_hexagonal.config.di;

import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.adapter.JpaCompradorAdapter;
import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.adapter.JpaIngressoAdapter;
import org.arturmatukiwa.pratica.arch_hexagonal.adapter.out.inmemory.jpa.adapter.JpaVendaAdapter;
import org.arturmatukiwa.pratica.arch_hexagonal.core.service.CadastrarCompradorService;
import org.arturmatukiwa.pratica.arch_hexagonal.core.service.ComprarIngressoService;
import org.arturmatukiwa.pratica.arch_hexagonal.core.service.ConsultaIngressoPorIdService;
import org.arturmatukiwa.pratica.arch_hexagonal.core.service.DisponibilizarIngressosService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

    @Bean
    public CadastrarCompradorService cadastrarCompradorService(JpaCompradorAdapter compradorRepositoryImplInjct) {
        return new CadastrarCompradorService(compradorRepositoryImplInjct);
    }

    @Bean
    public ComprarIngressoService comprarIngressoService(
               JpaIngressoAdapter ingressoRepositoryImplInjct,
               JpaCompradorAdapter compradorRepositoryImplInjct,
               JpaVendaAdapter vendaRepositoryImplInjct
    ) {
        return new ComprarIngressoService(ingressoRepositoryImplInjct, compradorRepositoryImplInjct, vendaRepositoryImplInjct);
    }

    @Bean
    public ConsultaIngressoPorIdService consultaIngressoPorIdService(JpaIngressoAdapter ingressoRepositoryImplInjct) {
        return new ConsultaIngressoPorIdService(ingressoRepositoryImplInjct);
    }

    @Bean
    public DisponibilizarIngressosService disponibilizarIngressosService(JpaIngressoAdapter ingressoRepositoryImplInjct) {
        return new DisponibilizarIngressosService(ingressoRepositoryImplInjct);
    }
}
