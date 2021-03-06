package com.jcerbito.battleofhogwarts.forbg.foreffects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jcerbito.battleofhogwarts.forbg.SizeEval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 11/01/2018.
 */

public class EffectTool {

    List<Effect> effects;

    public EffectTool() {
        effects = new ArrayList<Effect>();
    }

    public void add(Effect effect){
        effects.add(effect);
    }

    public void update(float delta){
        int i = 0;
        while (i < effects.size()){
            effects.get(i).update(delta);
            if (effects.get(i).isAvailable()){

                i++;
            }else {
                effects.get(i).release();
                effects.remove(i);
            }
        }
    }

    public void draw(SpriteBatch batch, SizeEval sizeEval){
        for (int i = 0; i < effects.size(); i++){

            effects.get(i).draw(batch, sizeEval);
        }
    }

    public void clear(){
        while (effects.size() > 0){
            effects.get(0).release();
            effects.remove(0);
        }
    }

}
