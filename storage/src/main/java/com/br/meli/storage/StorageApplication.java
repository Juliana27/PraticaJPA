package com.br.meli.storage;

import com.br.meli.storage.model.*;
import com.br.meli.storage.ropository.AnuncioRepository;
import com.br.meli.storage.ropository.CarrinhoRepository;
import com.br.meli.storage.ropository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class StorageApplication implements CommandLineRunner {

    @Autowired
    private AnuncioRepository anuncioRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        criaAnuncio();
//        adicionaAnuncioAUmVendedorExistente();
//        alteraVendedorDoAnuncio();
//        salvandoCarrinho();
//        buscaAnuncioPorVendedor();

        anuncioRepository.retrieveBySellerUF(UF.GO).forEach(a -> System.out.println(a.getTitulo()));

    }

    private void buscaAnuncioPorVendedor() {
        List<Anuncio> anuncios = anuncioRepository.findByVendedor(Vendedor.builder().id(1).build());
        anuncios.forEach(a -> System.out.println(a.getTitulo()));
    }

    private void salvandoCarrinho() {
        Optional<Anuncio> opSandalia = anuncioRepository.findById(1);
        Optional<Anuncio> opBiquini = anuncioRepository.findById(5);

        Carrinho carrinho = Carrinho.builder().dataFechamento(LocalDate.now()).build();

        carrinho.setItens(Arrays.asList(
                ItemCarrinho.builder().preco(opSandalia.get().getPreco()).quantidade(1).carrinho(carrinho).anuncio(opSandalia.get()).build(),
                ItemCarrinho.builder().preco(opBiquini.get().getPreco()).quantidade(1).carrinho(carrinho).anuncio(opBiquini.get()).build()
                )
        );
        //ItemCarrinho.builder().preco(BigDecimal.valueOf(200)).quantidade(1).build()));

        carrinhoRepository.save(carrinho);
    }

    private void alteraVendedorDoAnuncio() {
        Optional<Anuncio> optAnuncio = anuncioRepository.findById(3);
        Anuncio a = optAnuncio.get();
        a.setVendedor(vendedorRepository.findById(2).get());
        anuncioRepository.save(a);
    }

    private void adicionaAnuncioAUmVendedorExistente() {
//        criaVendedor();

        Optional<Vendedor> opVendedor = vendedorRepository.findById(1);
        Vendedor vendedor = opVendedor.orElse(new Vendedor());
        Anuncio biquini = Anuncio.builder()
                .data(LocalDate.now())
                .preco(new BigDecimal(200))
                .titulo("bolsa de praia")
                .vendedor(vendedor)
                .build();
        anuncioRepository.save(biquini);
    }

    private void criaAnuncio() {
        Vendedor vendedor = Vendedor.builder().nome("kenyo").cpf("345.678.098-90")
                .dataNascimento(LocalDate.parse("1980-02-25")).sexo('m')
                .endereco(Endereco.builder().uf(UF.GO).municipio("goiania").cep("74233-909").bairro("centro")
                        .complemento("q. x lt. y").num(123).logradouro("rua 5").build())
                .build();
        vendedorRepository.save(vendedor); // levando a instancia do estado transient para o estado managed

        Anuncio sandalia = Anuncio.builder().data(LocalDate.now()).preco(new BigDecimal(200)).titulo("sandália")
                .vendedor(vendedor).build();
        Anuncio saida = Anuncio.builder().data(LocalDate.now()).preco(new BigDecimal(200)).titulo("saida de banho")
                .vendedor(vendedor).build();
        Anuncio chinelo = Anuncio.builder().data(LocalDate.now()).preco(new BigDecimal(200)).titulo("chinelo")
                .vendedor(vendedor).build();
        Anuncio creme = Anuncio.builder().data(LocalDate.now()).preco(new BigDecimal(200)).titulo("creme")
                .vendedor(vendedor).build();
        Anuncio biquini = Anuncio.builder().data(LocalDate.now()).preco(new BigDecimal(200)).titulo("biquini")
                .vendedor(vendedor).build();

        anuncioRepository.save(sandalia);
        anuncioRepository.save(saida);
        anuncioRepository.save(chinelo);
        anuncioRepository.save(creme);
        anuncioRepository.save(biquini);

    }

    private Vendedor criaVendedor() {
        Vendedor juliana = Vendedor.builder()
                .nome("Juliana")
                .cpf("xxx")
                .dataNascimento(LocalDate.parse("1992-12-27"))
                .sexo('f')
                .endereco(Endereco.builder()
                        .uf(UF.RJ)
                        .municipio("Osasco")
                        .cep("06660-040")
                        .bairro("Conceição")
                        .complemento("casa")
                        .num(123)
                        .logradouro("rua x").build())
                .build();

        Vendedor vitor = Vendedor.builder()
                .nome("Vitor")
                .cpf("xxx")
                .dataNascimento(LocalDate.parse("1992-08-09"))
                .sexo('f')
                .endereco(Endereco.builder()
                        .uf(UF.RJ)
                        .municipio("Osasco")
                        .cep("06660-040")
                        .bairro("Conceição")
                        .complemento("casa")
                        .num(123)
                        .logradouro("rua x").build())
                .build();
        vendedorRepository.save(vitor);
        vendedorRepository.save(juliana); //levando a instancia do estado transient para o estado managed
        return juliana;
    }
}
