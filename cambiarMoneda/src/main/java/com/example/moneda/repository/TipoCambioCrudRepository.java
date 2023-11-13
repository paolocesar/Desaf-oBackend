package com.example.moneda.repository;


import com.example.moneda.controller.web.dto.TipoCambio;
import com.example.moneda.controller.web.dto.TipoCambioRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCambioCrudRepository extends JpaRepository<TipoCambio, TipoCambioRequest> {
}
