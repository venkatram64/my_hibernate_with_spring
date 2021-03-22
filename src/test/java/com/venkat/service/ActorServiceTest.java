package com.venkat.service;

import com.venkat.model.Actor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration({"classpath:my_hibernate_spring.xml"})
class ActorServiceTest {

    @Autowired
    private ActorService actorService;

    @Test
    public void getFilmFromStockTest(){
        Integer count = actorService.getFilmFromStock(1, 1);
        System.out.println("Count is " + count);
        Assertions.assertNotNull(count);
    }

    @Test
    public void getAllActorsTest(){
        List<Actor> list = actorService.getAllActors();
        System.out.println("Size is " + list.size());
        Assertions.assertTrue(list.size() > 0);
    }

}