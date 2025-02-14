package ie.gmit.dip;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class AccountTest {

	
	public static  Account account;
	
	
	// Reference source  : https://howtodoinjava.com/junit5/before-all-annotation-example/; Class Lecture Video
	@BeforeAll
	public static void  SetUpBeforeAll () {
		 account = new Account ("Alice", 1000.0);
		 account  = new Account ("Bob", 500.0);
		 System.out.println("Initializing all Account tests.");
	}
	
	
	
	// Reference source  : https://howtodoinjava.com/junit5/before-each-annotation-example/; Class Lecture Video
	@BeforeEach
	public  void  SetUpBeforeEach () {
		 account = new Account ("Alice", 1000.0);
		 account  = new Account ("Bob", 500.0);
		System.out.println("Initializing each of Account tests");
	}
	
	
	
	// Reference source: https://www2.cs.arizona.edu/~mercer/Book/03.pdf
	// Class Lecture Video
 @Test
 public void testAccount() {
	 Account acc1= new Account ("Alice", 1000.0); // Alice's account
	 Account acc2 = new Account ("Bob", 500.0); // Bob's account
	 assertEquals ("Alice", acc1.getAccountHolder());
	 assertEquals ("Bob", acc2.getAccountHolder());
 }
 
 
	@Test
	public void testDeposit() {
		Account acc = new Account ("Alice", 1000.0);
		acc.deposit(200.0);
		assertEquals(1200.0, acc.getBalance(), 0.001); // "Alice's balance should be increased after deposit"
	}
	
	
  
	@Test
	public void testWithdraw() {
		Account acc = new Account ("Bob", 500.0);
	    acc.withdraw(300.0);
		assertEquals(200.0, acc.getBalance(), 0.001);  // "Bob's balance should decrease after withdrawal"
		
	}
	
	
	
	@Test
	public void testApproveLoan() {
		Account acc = new Account ("Alice", 400.0);
		acc.approveLoan(400.0);
		assertEquals(400.0, acc.getBalance(), 0.001); // "Alice's loan amount should increase after loan approval"
		
	}
	
	
	
	@Test
	public void testRepayLoan() {
		Account acc = new Account ("Alice", 1200.0);
		acc.approveLoan(400.0);
		acc.repayLoan(200.0);                    // "Alice's loan amount should decrease after loan repayments"
		assertEquals(1200.0, acc.getBalance());
		
	}
	
	
	
	// Reference source  : Class Lecture Video
	@ParameterizedTest
	@ValueSource(strings = {"Alice", "Bob"})
	public void MyParameterizedTest(String message) {
		assertNotNUll (message);
		
	}
	
	
	private void assertNotNUll(String message) {
		
	}
	
	
	
	// Reference source  : Class Lecture Video
	@ParameterizedTest
	@CsvSource ({"Alice, 5", "Bob, 3"})
	public void MySecondParameterizedTest (String word, int length) {
		assertEquals (word.length(), length);
	}
	
	
	
	// Reference source  : Class Lecture Video
	@Test
	public void TestException() {
		assertThrows (ArithmeticException.class, () ->{
			int j = 1/0;
		});
	}
	
	
	
	// Reference source  : Class Lecture Video
	@Test
	public void TestSecondException() {
		assertThrows (NullPointerException.class, () ->{
			String strTest = null;
			if(strTest == null) {
				throw new NullPointerException();
			}
		});
	}
	
	
	
	// Reference source  : Class Lecture Video
	
	@Timeout(value = 1)
	@Test
	public void testTimeout() {
		Account acc = new Account ("Alice", 1000.0);
		acc.deposit(200.0);
		assertEquals(1200.0, acc.getBalance(), 0.001);
		
	}
	
	
	// Reference source: https://www.geeksforgeeks.org/junit-5-aftereach/
	@AfterEach
	public void testAfterEach () {
		System.out.println("Test completed for Account.");
		
	}
	
	
	
	// Reference source: https://www.geeksforgeeks.org/junit-5-afterall-annotation-with-example/
	@AfterAll
	public static void testAfterAll() {
		System.out.println("All Account Tests completed.");
		
	}	
}