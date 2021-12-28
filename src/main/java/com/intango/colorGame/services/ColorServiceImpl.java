package com.intango.colorGame.services;

import com.intango.colorGame.models.Color;
import com.intango.colorGame.repositories.ColorRepository;
import com.intango.colorGame.services.ex.ColorDoestExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> findAllColors() {
        return colorRepository.findAll();
    }

    @Override
    public void increaseVote(long id) throws ColorDoestExistsException {
        Optional<Color> colorById = colorRepository.findById(id);
        if (!colorById.isPresent()) {
            throw new ColorDoestExistsException(String.format("Color with id %d does not exists.", id));
        }
        Color color = colorById.get();
        int updatedVotes = color.getColorVotes() + 1;
        color.setColorVotes(updatedVotes);
        colorRepository.save(color);
    }
}
