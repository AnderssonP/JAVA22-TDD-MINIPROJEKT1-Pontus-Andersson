package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Triangle;

public class TriangleTest {
	
	@Test
	@DisplayName("Test triangle types")
	void testTriangle() {
		Triangle triangle = new Triangle(3, 3, 3);
        assertEquals(Triangle.TYPE.EQUILATERAL, triangle.getCurrent_type());
        
        Triangle triangle2 = new Triangle(3, 3, 4);
        assertEquals(Triangle.TYPE.ISOSCELES, triangle2.getCurrent_type());
        
        Triangle triangle3 = new Triangle(3, 4, 5);
        assertEquals(Triangle.TYPE.SCALENE, triangle3.getCurrent_type());
        
        Triangle triangle4 = new Triangle(1, 2, 3);
        assertNull(triangle4.getCurrent_type());
        
        Triangle triangle5 = new Triangle(0, 2, 3);
        assertNull(triangle5.getCurrent_type());
	}
	
	@Test
	@DisplayName("Test User Input: Scalene Triangle")
	void testInput() {
		String input = "3,4,5\n";
        InputStream originalInput = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOutput = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Triangle triangle = new Triangle();
            triangle.getUserInput();
            assertEquals("3, 4, 5, This is a Scalene triangle", outputStream.toString().trim());
        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
	}
	
	@Test
	@DisplayName("Test Invalid Input: Null Type")
	void testNull() {
		String[] invalidInput = {"a", "b", "c"};
        Triangle triangle = new Triangle(invalidInput);
        assertNull("Current_type should be null for invalid input",triangle.getCurrent_type());
		
	}

}
