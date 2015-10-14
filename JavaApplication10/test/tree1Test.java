/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EsferaDePandora
 */
public class tree1Test {
    
    public tree1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGet() {
        System.out.println("get");
        
        Word word1 = new Word("a",""); //Construyo una palabra con su tipo, ambos vacios
        tree1 instancia = new tree1();
        instancia.add(word1);
        
        Word word2 = new Word("a",""); //Construyo una palabra con su tipo, ambos vacios
        
        int expResult = 0;
        int result =1;
        if (word2.equals(instancia.get(word1))==true){
            result = 0;
        }

        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testAdd() {
        System.out.println("add");
        
        Word word = new Word("a",""); //Construyo una palabra con su tipo, ambos vacios
        tree1 instancia = new tree1();
        instancia.add(word);
        //fail("The test case is a prototype.");
    }
    
}
