package com.example.mobilecrud.repository;

import com.example.mobilecrud.model.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<Mobile, Integer> {
}
