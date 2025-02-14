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



class BankingAppTest {
	
	
	private BankingApp bankingApp;
	
	
	// Reference source  : https://howtodoinjava.com/junit5/before-all-annotation-example/; Class Lecture Video
	@BeforeAll
	public static void setUpBeforeAll() {
		System.out.println("Initializing all BankingApp tests.");
	}
	
	
	//Reference source  : https://howtodoinjava.com/junit5/before-each-annotation-example/; Class Lecture Video
	@BeforeEach
	public  void  SetUpBeforeEach () {
		bankingApp = new BankingApp();
		bankingApp.addAccount("Alice", 1000.0);
	    bankingApp.addAccount("Bob", 500.0);
	    System.out.println("Initializing each of BankingApp tests.");
	}
	
	
	@Test
	public void testFindAccount() {
		Account aliceAccount = bankingApp.findAccount("Alice");
		assertNotNull(aliceAccount); // "Alice's account should be found"
		assertEquals(1000.0, aliceAccount.getBalance()); // "Alice's balance should match initial deposit"
	}
	
	
	@Test
	public void testAddAccount() {
		bankingApp.addAccount("Alice", 1000.0);
		bankingApp.addAccount("Bob", 500.0);
		Account aliceAccount = bankingApp.findAccount("Alice");
		Account bobAccount = bankingApp.findAccount("Bob");
		assertNotNull(aliceAccount); // "Account should be created for Alice"
		assertEquals(1000.0, aliceAccount.getBalance()); // "Alice's initial deposit should match"
		assertNotNull(bobAccount); // "Account should be created for Bob"
		assertEquals(500.0, bobAccount.getBalance()); // "Bob's initial deposit should match"
	}
	
	
	
	@Test
	public void testDeposit() {
		bankingApp.deposit("Alice", 200.0);
		Account aliceAccount = bankingApp.findAccount("Alice");
		assertEquals(1200.0, aliceAccount.getBalance()); // "Alice's balance should be increased after deposit"
    }
	
	@Test
	public void testWithdraw() {
		bankingApp.withdraw("Bob", 300.0);
		Account bobAccount = bankingApp.findAccount("Bob");
		assertEquals(200.0, bobAccount.getBalance()); // "Bob's balance should decrease after withdrawal"
	}
	
	
	  
	@Test
	public void testApproveLoan() {
		bankingApp.approveLoan("Alice", 400.0);
		Account aliceAccount = bankingApp.findAccount("Alice");
		assertEquals(400.0, aliceAccount.getLoan()); // "Alice's loan amount should increase after loan approval"
	}
	
	
	
	@Test
	public void testRepayLoan() {
		bankingApp.approveLoan("Alice", 400.0);
		bankingApp.repayLoan("Alice", 200.0);
		Account aliceAccount = bankingApp.findAccount("Alice");
		assertEquals(200.0, aliceAccount.getLoan()); // "Alice's loan amount should decrease after loan repayments"
	}
	
	
	
	// Reference source  : Class Lecture Video
	@ParameterizedTest
	@ValueSource(doubles = {200.0, 0.0})
	public void testWithdrawAmount(double amount) {
		Account aliceAccount = bankingApp.findAccount("Alice");
		double initialBalance = aliceAccount.getBalance();
		bankingApp.withdraw("Alice", amount);
		if (amount <= initialBalance) {
			assertEuqals(initialBalance - amount, aliceAccount.getBalance(),
					"Valid withdrawal should decrease balance");
		
		}
	}
	
	private void assertEuqals(double d, double e, String string) {
		
	}
	
	
	
	// Reference source  : Class Lecture Video
		@ParameterizedTest
		@CsvSource ({"Alice, 5", "Bob, 3"})
		public void MySecondParameterizedTest (String word, int length) {
			assertEquals (word.length(), length);
		}


	
	@Test
	public void testTotalDeposits() {
		// Alice: 1000, Bob: 500
		bankingApp.deposit("Alice", 200.0); // Alice: 1200
		bankingApp.withdraw("Bob", 300.0); // Bob: 200
		bankingApp.getTotalDeposits();
	}
		
	
	// Reference source  : Class Lecture Video
		@Test
		public void TestException() {
			assertThrows (ArithmeticException.class, () ->{
				int j = 1/0;
			});
		}
		
		
		
		// Reference source  : Class Video
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
			System.out.println("Test completed for BankingApp.");
			
		}
		
		
		
		// Reference source: https://www.geeksforgeeks.org/junit-5-afterall-annotation-with-example/
		@AfterAll
		public static void testAfterAll() {
			System.out.println("All BankingApp Tests completed.");
			
		}	
	

}

    