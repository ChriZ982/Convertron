/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertron.core;

import interlib.data.Lesson;

/**
 *
 * @author Mirko
 */
public interface Storage
{
    public void save(Lesson[] lessons);

    public Lesson[] load();
}
