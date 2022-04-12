package com.br.meli.storage.es.repository;

import com.br.meli.storage.es.model.Ad;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdRepository extends ElasticsearchRepository<Ad, String> {

    List<Ad> findByTitle(String title);
    List<Ad> findByTitleOrTag(String termo);
    List<Ad> findByCodeOrTitle(String c, String t);
}
