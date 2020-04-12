import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.*;
import java.util.*;
import java.io.*;




/******************************************************************************
 *  Author : bal15b Ben Lamont
 *  Class  : Spring 2020 Dr. Reeves CS374
 *  Task   : Do Somehting test
 ******************************************************************************/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GoogleHappyTest
{
    @Test
    public void atest1()  throws FileNotFoundException
    {
    	//Test 1 By Ben Lamont
		System.out.println("\n------TEST 1------");
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "A,B\nB,E\nC,A,B,D,E\nD,C,E\nE,D";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction("f");

        int t = (int)(g.p.pagerank[1] * 100);
        assertEquals(t,17);

        t = (int)(g.p.pagerank[2] * 100);
        assertEquals(t,21);

        t = (int)(g.p.pagerank[3] * 100);
        assertEquals(t,25);

        t = (int)(g.p.pagerank[4] * 100);
        assertEquals(t,46);

        t = (int)(g.p.pagerank[5] * 100);
        assertEquals(t,49);
    }

    @Test
    public void btest2()  throws FileNotFoundException
    {
    	//Test 2 By Ben Lamont
		System.out.println("\n------TEST 2------");
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "Calvin,Bubba,Blinkendorfer,Suzie\nBubba,Snoopie,Donald\nBlinkendorfer,Bubba,Billy,Ivanka\nSuzie,Ivanka,Donald\nDonald,Bubba,Ivanka,Mitch\nMitch,Snoopie,Bubba,Suzie,Ivanka,Donald\nSnoopie,Bubba\nBilly,Donald,Blinkendorfer\nIvanka,Donald,Billy,Suzie";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction("f");

		int t = (int)(g.p.pagerank[1] * 100);
        assertEquals(t,15);

        t = (int)(g.p.pagerank[2] * 100);
        assertEquals(t,31);

        t = (int)(g.p.pagerank[3] * 100);
        assertEquals(t,18);

        t = (int)(g.p.pagerank[4] * 100);
        assertEquals(t,19);

        t = (int)(g.p.pagerank[5] * 100);
        assertEquals(t,37);

        t = (int)(g.p.pagerank[6] * 100);
        assertEquals(t,21);

        t = (int)(g.p.pagerank[7] * 100);
        assertEquals(t,26);

        t = (int)(g.p.pagerank[8] * 100);
        assertEquals(t,21);

        t = (int)(g.p.pagerank[9] * 100);
        assertEquals(t,28);
    }

    //test 3 makes sure the matrix is alligned correctly
    @Test
    public void ctest3()  throws FileNotFoundException
    {
    	//Test 3 By Nic Fornicola
		System.out.println("\n------TEST 3------");
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "Calvin,Bubba,Blinkendorfer,Suzie\nBubba,Snoopie,Donald\nBlinkendorfer,Bubba,Billy,Ivanka\nSuzie,Ivanka,Donald\nDonald,Bubba,Ivanka,Mitch\nMitch,Snoopie,Bubba,Suzie,Ivanka,Donald\nSnoopie,Bubba\nBilly,Donald,Blinkendorfer\nIvanka,Donald,Billy,Suzie";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
        g.primaryFunction("f");
		
		assertEquals(g.p.path[1][1],0);
		assertEquals(g.p.path[1][2],1);
		assertEquals(g.p.path[1][3],1);
		assertEquals(g.p.path[1][4],1);
		assertEquals(g.p.path[1][5],0);
		assertEquals(g.p.path[1][6],0);
		assertEquals(g.p.path[1][7],0);
		assertEquals(g.p.path[1][8],0);
		assertEquals(g.p.path[1][9],0);

		assertEquals(g.p.path[2][1],0);
		assertEquals(g.p.path[2][2],0);
		assertEquals(g.p.path[2][3],0);
		assertEquals(g.p.path[2][4],0);
		assertEquals(g.p.path[2][5],1);
		assertEquals(g.p.path[2][6],0);
		assertEquals(g.p.path[2][7],1);
		assertEquals(g.p.path[2][8],0);
		assertEquals(g.p.path[2][9],0);

		assertEquals(g.p.path[3][1],0);
		assertEquals(g.p.path[3][2],1);
		assertEquals(g.p.path[3][3],0);
		assertEquals(g.p.path[3][4],0);
		assertEquals(g.p.path[3][5],0);
		assertEquals(g.p.path[3][6],0);
		assertEquals(g.p.path[3][7],0);
		assertEquals(g.p.path[3][8],1);
		assertEquals(g.p.path[3][9],1);

    }
	
    //test 4 makes sure the matrix is alligned correctly
    @Test
    public void dtest4()  throws FileNotFoundException
    {
    	//Test 4 By Nic Fornicola
		System.out.println("\n------TEST 4------");
    	GoogleHappy g = new GoogleHappy();

	//different preferences
    	String prefs = "Calvin,Bubba,Suzie,Billy,Ivanka,Snoopie,Donald\nBubba,Snoopie,Suzie,Donald,Billy,\nBlinkendorfer,Billy,Ivanka\nSuzie,Donald,Blinkendorfer,Bubba\nDonald,Bubba,Ivanka,Mitch\nMitch,Bubba,Suzie,Ivanka,Donald\nSnoopie,Bubba\nBilly,Donald,Blinkendorfer,Snoopie\nIvanka,Donald,Suzie";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);
		
        g.primaryFunction("f");
		
		assertEquals(g.p.path[1][1],0);
		assertEquals(g.p.path[1][2],1);
		assertEquals(g.p.path[1][3],0);
		assertEquals(g.p.path[1][4],1);
		assertEquals(g.p.path[1][5],1);
		assertEquals(g.p.path[1][6],0);
		assertEquals(g.p.path[1][7],1);
		assertEquals(g.p.path[1][8],1);
		assertEquals(g.p.path[1][9],1);

		assertEquals(g.p.path[2][1],0);
		assertEquals(g.p.path[2][2],0);
		assertEquals(g.p.path[2][3],0);
		assertEquals(g.p.path[2][4],1);
		assertEquals(g.p.path[2][5],1);
		assertEquals(g.p.path[2][6],0);
		assertEquals(g.p.path[2][7],1);
		assertEquals(g.p.path[2][8],1);
		assertEquals(g.p.path[2][9],0);

		assertEquals(g.p.path[3][1],0);
		assertEquals(g.p.path[3][2],0);
		assertEquals(g.p.path[3][3],0);
		assertEquals(g.p.path[3][4],0);
		assertEquals(g.p.path[3][5],0);
		assertEquals(g.p.path[3][6],0);
		assertEquals(g.p.path[3][7],0);
		assertEquals(g.p.path[3][8],1);
		assertEquals(g.p.path[3][9],1);
		
    }

    //makes sure matrix includes people who are only mentioned
    @Test
    public void etest5()  throws FileNotFoundException
    {
    	//Test 5 By Ben Lamont
		System.out.println("\n------TEST 5------");
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "A,B\nB,C,D,E\nE,D,A";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction("f");

       	assertEquals(g.p.path[1][1],0);
       	assertEquals(g.p.path[2][2],0);
       	assertEquals(g.p.path[3][3],0);
       	assertEquals(g.p.path[4][4],0);
       	assertEquals(g.p.path[5][5],0);

       	assertEquals(g.p.path[1][2],1);
       	assertEquals(g.p.path[2][3],1);
       	assertEquals(g.p.path[2][4],1);
       	assertEquals(g.p.path[2][5],1);
       	assertEquals(g.p.path[3][1],1);
       	assertEquals(g.p.path[3][5],1);
    }


    //test to see if it breaks with no people
    @Test
    public void ftest6()  throws FileNotFoundException
    {
    	//Test 6 By Ben Lamont
		System.out.println("\n------TEST 6------");
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction("f");

        assertEquals(g.count,0);

    }

    //makes sure the weighted values are entered into the array correctly
    @Test
    public void gtest7()  throws FileNotFoundException
    {
    	//Test 7 By Ben Lamont
		System.out.println("\n------TEST 7------");
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "A,B,C\nB,C\nC,B,A,D";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction("t");

        assertEquals(g.p.path[1][1],0);
        assertEquals(g.p.path[2][2],0);
        assertEquals(g.p.path[3][3],0);
        assertEquals(g.p.path[4][4],0);

        assertEquals(g.p.path[1][2],1);
        assertEquals(g.p.path[1][3],2);

        assertEquals(g.p.path[2][3],1);

        assertEquals(g.p.path[3][2],1);
        assertEquals(g.p.path[3][1],2);
        assertEquals(g.p.path[3][4],3);

    }


    //tests to make sure you can't vote for yourself
    @Test
    public void htest8()  throws FileNotFoundException
    {
    	//Test 8 By Ben Lamont
		System.out.println("\n------TEST 8------");
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "A,A,A,A\nB,B,B,B\nC,C,C,C\nD,D,D,D";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction("f");

        for (int i = 1; i <= 4; i++)
        {
        	for (int j = 1; j <= 4; j++)
        	{
        		assertEquals(g.p.path[i][j],0);
        	}
        }


    }


    //tests to make sure it doesn't break on an empty preference
    @Test
    public void itest9()  throws FileNotFoundException
    {
    	//Test 9 By Ben Lamont
		System.out.println("\n------TEST 9------");
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "A,B,C\nB,C\nC,B,,D";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction("f");

        assertEquals(g.p.path[3][4],1);
    }


    //tests to make sure weighted prefs are distributed properly
    @Test
    public void jtest10()  throws FileNotFoundException
    {
    	//Test 10 By Ben Lamont
		System.out.println("\n------TEST 10------");
    	GoogleHappy g = new GoogleHappy();

    	String prefs = "1,2,3,4,5,6,7,8,9\n2,1,3,4,5,6,7,8,9\n3,1,2,4,5,6,7,8,9\n4,1,2,3,5,6,7,8,9\n5,1,2,3,4,6,7,8,9\n6,1,2,3,4,5,7,8,9\n7,1,2,3,4,5,6,8,9\n8,1,2,3,4,5,6,7,9\n9,1,2,3,4,5,6,7,8";

    	ByteArrayInputStream in = new ByteArrayInputStream(prefs.getBytes());
        System.setIn(in);

        g.primaryFunction("t");


        for (int i = 1; i < 9; i++)
        {
        	assertTrue(g.p.pagerank[i] > g.p.pagerank[i+1]);
        }

    }
	
	@Test
    public void ktest11()  throws FileNotFoundException
    {
		
		//Test 11 By Nic Fornicola
		System.out.println("\n------TEST 11------");
    	GoogleHappy g = new GoogleHappy();
		
		
		HashMap<String, Integer> testHash = new HashMap<String, Integer>();
		testHash.put("AA",0);
		testHash.put("BB",1);
		testHash.put("CC",2);
		testHash.put("DD",3);
		testHash.put("EE",4);
		String allNames[] = new String [5];
		
		//See keys and values
		//System.out.println(testHash.entrySet());
		
		allNames = g.getKeys(testHash, 1);
		
		assertEquals(allNames[0],"AA");
		assertEquals(allNames[1],"BB");
		assertEquals(allNames[2],"CC");
		assertEquals(allNames[3],"DD");
		assertEquals(allNames[4],"EE");
		System.out.println("Test11 Passed");
		

    }
	
	@Test
    public void ltest12()  throws FileNotFoundException
    {
		
		//Test 12 By Nic Fornicola
		System.out.println("\n------TEST 12------");
    	GoogleHappy g = new GoogleHappy();
		
		
		HashMap<String, Integer> testHash = new HashMap<String, Integer>();
		testHash.put("CC",0);
		testHash.put("EE",0);
		testHash.put("AA",0);
		testHash.put("DD",0);
		testHash.put("BB",0);
		String allNames[] = new String [5];
		
		//See keys and values
		//System.out.println(testHash.entrySet());
		
		allNames = g.getKeys(testHash, 0);
		
		assertEquals(allNames[0],"CC");
		assertEquals(allNames[1],"EE");
		assertEquals(allNames[2],"AA");
		assertEquals(allNames[3],"DD");
		assertEquals(allNames[4],"BB");
		System.out.println("Test12 Passed");	

    }
}
