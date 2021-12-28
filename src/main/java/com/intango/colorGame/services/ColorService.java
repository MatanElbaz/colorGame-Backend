package com.intango.colorGame.services;


import com.intango.colorGame.models.Color;
import com.intango.colorGame.services.ex.ColorDoestExistsException;

import java.util.List;

public interface ColorService {

    /**
     * Find all colors from data base.
     *
     * @return List of all colors .
     */
    List<Color> findAllColors();

    /**
     * increase the vote number by 1 of the color by id.
     *
     * @param id the id to color.
     * @return List of all colors .
     */
    void increaseVote(long id) throws ColorDoestExistsException;
}
