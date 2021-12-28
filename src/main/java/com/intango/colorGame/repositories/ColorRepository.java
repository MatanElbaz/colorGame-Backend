package com.intango.colorGame.repositories;

import com.intango.colorGame.models.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
