package com.venkat.myCollections;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PersonDriver {

    public static void optionalM(){
        Optional<Integer> intValue = Optional.<Integer>empty();
         intValue = Optional.of(45);

        System.out.println(intValue.map(i -> i * 10 + " Lines").orElse("No lines"));

        System.out.println(intValue.filter(i -> i == 47).orElse(100));
        intValue.ifPresent(i -> System.out.println("If Present: " + i));
    }

    public static void main(String[] args) {
        optionalM();
        Optional<Person> person = getPersonByIndex(2);
        System.out.println("Age is: " + person.get().getAge());

        Person filteredP = person.filter(p -> p.getAge() >= 25)
                .orElse(new Person("Ram", 19));
        System.out.println("Filtered person: " + filteredP);
    }

    static Optional<Person> getPersonByIndex(int position){
        Optional<Person> person = Optional.<Person>empty();

        List<Person> personList = Arrays.asList(
                new Person("Venkatram", 57),
                new Person("Srijan", 20),
                new Person("Vinny", 25)

        );
        if(position >= 0 && position < personList.size()){
            person = Optional.ofNullable(personList.get(position));//Optional.of(personList.get(position));
        }
        return person;
    }
}
