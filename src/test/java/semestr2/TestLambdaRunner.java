package semestr2;

import org.junit.Test;

import static org.junit.Assert.*;
import static semestr2.LambdaRunner.*;
import static semestr2.LambdaDemo.*;

public class TestLambdaRunner {
    private String str2 = "testString";
    private String str4 = "1 234 56";
    private String str5 = "10,abc,1,abcd";
    private Human human1 = new Human("Sidorov", "Ivan", "Petrovich", 45, Gender.MALE);
    private Human human2 = new Human("Petrov", "Andrey", "Ivanovich", 27, Gender.MALE);
    private Human human3 = new Human("Ananieva", "Elena", "Victorovna", 15, Gender.FEMALE);
    private Student student1 = new Student("Dyachenko","Valeriia","Vitalievna", 20, Gender.FEMALE,
            "OmSU", "Math","Math");
    private Student student2 = new Student("Dyachenko","Valeriia","Vitalievna", 25, Gender.FEMALE,
            "OmSU", "Math","Math");

    @Test
    public void testRunner1(){
        Human expected = new Human("Sidorov", "Ivan", "Petrovich", 46, Gender.MALE);
        assertEquals(10, (int)runner1(getLength,str2));
        assertEquals('t', (char)runner1(getFirstElem,str2));
        assertFalse(runner1(checkSpaces,str2));
        assertTrue(runner1(checkSpaces,str4));
        assertEquals(4, (int)runner1(numberWord, str5));
        assertEquals(1, (int)runner1(numberWord, str2));
        assertEquals(45, (int)runner1(getAgeHuman, human1));
        assertEquals(20, (int)runner1(getAgeHuman, student1));
        assertEquals("Sidorov Ivan Petrovich", runner1(fullName, human1));
        assertEquals("Dyachenko Valeriia Vitalievna", runner1(fullName, student1));
        assertEquals(expected, runner1(makeOneYearOlder, human1));
    }
    @Test
    public void testRunner2(){
        assertFalse(runner2(sameSurname,human1,human2));
        assertFalse(runner2(sameSurname,human1,student1));
        assertTrue(runner2(sameSurname,student1,student2));
    }
    @Test
    public void testRunner3(){
        assertTrue(runner3(checkAge, human1,human2,human3, 60));
        assertFalse(runner3(checkAge, human1,human2,human3, 30));
    }
}
