package com.parroquias.parroquia_ws.parroquia_ws.baptism.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.parroquias.parroquia_ws.parroquia_ws.baptism.entities.Baptism;

public interface BaptismRepository extends JpaRepository<Baptism, Long> {

    Page<Baptism> findAll(Pageable pageable);
}
