package de.neuefische;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void returnFalseWhenPasswordLessThan8Characters(){
        //GIVEN
        String inputPassword="Cat";
        //WHEN
        boolean actual=Main.checkValidLength(inputPassword);
        //THEN
        assertEquals(false,actual);

    }

    @Test
    public void returnTrueWhenPasswordBetween8And20Characters(){
        //GIVEN
        String inputPassword="12345678910";
        //WHEN
        boolean actual=Main.checkValidLength(inputPassword);
        //THEN
        assertEquals(true,actual);

    }
    @Test
    public void returnFalseWhenPasswordMoreThan20Characters(){
        //GIVEN
        String inputPassword="1234567891012345678910";
        //WHEN
        boolean actual=Main.checkValidLength(inputPassword);
        //THEN
        assertEquals(false,actual);

    }
    @Test
    public void returnTrueWhenContainNumber(){
        //GIVEN
        String inputPassword="Thanh1";
        //WHEN
        boolean actual=Main.containNumber(inputPassword);
        //THEN
        assertEquals(true,actual);
    }
    @Test
    public void returnFalseWhenNotContainNumber(){
        //GIVEN
        String inputPassword="Thanh";
        //WHEN
        boolean actual=Main.containNumber(inputPassword);
        //THEN
        assertEquals(false,actual);
    }

    @Test
    public void returnTrueWhenContainUpperCaseLetter(){
        //GIVEN
        String inputPassword="HHHHaaaa";
        //WHEN
        boolean actual=Main.containUpperCaseLetter(inputPassword);
        //THEN
        assertEquals(true,actual);
    }
    @Test
    public void returnFalseWhenNotContainUpperCaseLetter(){
        //GIVEN
        String inputPassword="aaa";
        //WHEN
        boolean actual=Main.containUpperCaseLetter(inputPassword);
        //THEN
        assertEquals(false,actual);
    }
    @Test
    public void returnTrueWhenContainBadPassword(){
        //GIVEN
        String[] input={"Hallopassword","123456HJs","Hj654321","abcdef123"};
        boolean[] expectedResults={true,true,true,true};
        //WHEN
        boolean[] actual=new boolean[input.length];
        for (int i=0;i<input.length;i++) {
            actual[i] = Main.containBadPassword(input[i]);
        }
        //THEN
        assertArrayEquals(expectedResults,actual);
    }

    @Test
    public void returnFalseWhenNotContainBadPassword(){
        //GIVEN
        String input="hahaha";
        //WHEN
        boolean actual=Main.containBadPassword(input);
        //THEN
        assertEquals(false,actual);
    }

    @Test
    public void returnTrueWhenContainSpecialCharacter(){
        //GIVEN
        String input="HaHa$";
        //WHEN
        boolean actual=Main.containSpecialCharacter(input);
        //THEN
        assertEquals(true,actual);
    }

    @Test
    public void returnFalseWhenNotContainSpecialCharacter(){
        //GIVEN
        String inputPassword="HaHa";
        //WHEN
        boolean actual=Main.containSpecialCharacter(inputPassword);
        //THEN
        assertEquals(false,actual);
    }
}