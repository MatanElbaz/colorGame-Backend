package com.intango.colorGame.controllers;

import com.intango.colorGame.models.Color;
import com.intango.colorGame.repositories.ColorRepository;
import com.intango.colorGame.services.ColorService;
import com.intango.colorGame.services.ex.ColorDoestExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
//@CrossOrigin
@RestController
public class ColorController {

    private ColorService colorService;
    private ColorRepository colorRepository;

    @Autowired
    public ColorController(ColorService colorService,ColorRepository colorRepository) {
        this.colorService = colorService;
        this.colorRepository = colorRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Color>> getAllColors(){
        List<Color> allColors = colorService.findAllColors();
        if (allColors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allColors);
    }

    @PutMapping("/add-vote/{id}")
    public ResponseEntity<Color> addVote(@PathVariable long id) throws ColorDoestExistsException {
        colorService.increaseVote(id);
        Optional<Color> byId = colorRepository.findById(id);
        return ResponseEntity.ok(byId.get());
    }
    
}
