package semestr2;

import java.util.function.Function;


public class LambdaDemo {
    public static final Function<String, Integer> getLength = String::length;
    public static final Function<String, Character> getFirstElem = string -> {
        if (string == null || string.length() == 0) {
            return null;
        }
        return string.charAt(0);
    };
    public static final Function<String, Boolean> checkSpaces = string -> string.contains(" ");
    public static final Function<String, Integer> numberWord = string -> {
        if (string.length() == 0) {
            return null;
        }
        String[] strings = string.split(",");
        return strings.length;
    };
    public static final Function<Human, Integer> getAgeHuman = Human::getAge;
    public static final HumanLambda<Human> sameSurname = (human1,human2) -> human1.getSurname().equals(human2.getSurname());
    public static final Function<Human, String> fullName = human ->
            human.getSurname() + " " + human.getName() + " " + human.getPatronymic();
    public static final Function<Human, Human> makeOneYearOlder = human ->
            new Human(human.getSurname(), human.getName(), human.getPatronymic(), human.getAge() + 1, human.getGender());
    public static final HumanCheckAge<Human,Human,Human,Integer> checkAge = (human1, human2, human3, maxAge) ->
            human1.getAge() < maxAge && human2.getAge() < maxAge && human3.getAge() < maxAge;
}
