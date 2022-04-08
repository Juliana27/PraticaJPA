package com.br.meli.storage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class Endereco {

    private String logradouro;
    private String complemento;
    private int num;
    private String bairro;
    private String cep;
    private String municipio;
    @Enumerated(EnumType.STRING)
    private UF uf;
}
