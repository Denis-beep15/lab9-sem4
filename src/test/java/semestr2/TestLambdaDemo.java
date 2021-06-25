package semestr2;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestLambdaDemo {
    private String str1 = "";
    private String str2 = "testString";
    private String str3 = "123456";
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
    public void testGetLength(){
        assertEquals(0, (int)LambdaDemo.getLength.apply(str1));
        assertEquals(10,(int)LambdaDemo.getLength.apply(str2));
        assertEquals(6, (int)LambdaDemo.getLength.apply(str3));
    }
    @Test
    public void testGetFirstElem(){
        assertNull(LambdaDemo.getFirstElem.apply(str1));
        assertEquals('t', (char)LambdaDemo.getFirstElem.apply(str2));
        assertEquals('1', (char)LambdaDemo.getFirstElem.apply(str3));
    }
    @Test
    public void testCheckSpaces(){
        assertTrue(LambdaDemo.checkSpaces.apply(str4));
        assertFalse(LambdaDemo.checkSpaces.apply(str1));
    }
    @Test
    public void testNumberWord(){
        assertEquals(4, (int)LambdaDemo.numberWord.apply(str5));
        assertEquals(1, (int)LambdaDemo.numberWord.apply(str2));
        assertNull(LambdaDemo.numberWord.apply(str1));
    }
    @Test
    public void testGetAgeHuman(){
        assertEquals(45, (int) LambdaDemo.getAgeHuman.apply(human1));
        assertEquals(20, (int) LambdaDemo.getAgeHuman.apply(student1));
    }
    @Test
    public void testSameSurname(){
        assertFalse(LambdaDemo.sameSurname.method(human1,human2));
        assertFalse(LambdaDemo.sameSurname.method(human1,student1));
        assertTrue(LambdaDemo.sameSurname.method(student1,student2));
    }
    @Test
    public void testFullName(){
        String expected1 = "Sidorov Ivan Petrovich";
        String expected2 = "Dyachenko Valeriia Vitalievna";
        assertEquals(expected1, LambdaDemo.fullName.apply(human1));
        assertEquals(expected2, LambdaDemo.fullName.apply(student1));
    }
    @Test
    public void testMakeOneYearOlder(){
        Human expected = new Human("Sidorov", "Ivan", "Petrovich", 46, Gender.MALE);
        assertEquals(expected, LambdaDemo.makeOneYearOlder.apply(human1));
    }
    @Test
    public void testCheckAge(){
        assertTrue(LambdaDemo.checkAge.checkAge(human1,human2,human3, 60));
        assertFalse(LambdaDemo.checkAge.checkAge(human1,human2,human3, 30));
    }
}
