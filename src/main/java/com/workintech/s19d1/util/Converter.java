package com.workintech.s19d1.util;

import com.workintech.s19d1.dto.ActorResponse;
import com.workintech.s19d1.entity.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Converter {

    public static List<ActorResponse> actorResponseConvert(List<Actor> actors) {
        List<ActorResponse> actorResponses = new ArrayList<>();
        for(Actor actor: actors) {
            actorResponses.add(new ActorResponse(actor.getId(), actor.getFirstName(), actor.getBirthDate(),actor.getMovies()));
        }
        return actorResponses;
    }

    public static ActorResponse actorResponseConvert(Actor actor) {
        return new ActorResponse(actor.getId(), actor.getFirstName(), actor.getBirthDate(),actor.getMovies());
    }
}
