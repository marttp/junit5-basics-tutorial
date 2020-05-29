import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    private MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

//    @BeforeAll
//    static void beforeAllInit() {
//        System.out.println("Start MathUtils Test");
//    }

    @BeforeEach
    void initEach(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
    }

//    @AfterEach
//    void cleanup() {
//        System.out.println("Cleaning up...");
//    }

    @Test
//    @RepeatedTest(3)
    @Tag("Circle")
    @DisplayName("Testing compute circle area method")
    void computeCircleArea() {
        assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
    }

    @Test
    @Tag("Math")
    @DisplayName("Testing divide method")
    void divide() {
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "Divide should throw ArithmeticException when denominator is zero");
    }

    @Test
    @Disabled
    @DisplayName("TDD method. Should not run")
    void testDisabled() {
        fail("This test should be disabled");
    }

    @Test
    @Tag("Math")
    @DisplayName("Testing multiple method")
    void multiply() {
        assertAll(
                () -> assertEquals(0, mathUtils.multiply(1, 0)),
                () -> assertEquals(1, mathUtils.multiply(1, 1)),
                () -> assertEquals(6, mathUtils.multiply(2, 3))
        );
    }

    @Nested
    @Tag("Math")
    class AddTest {
        @Test
        @DisplayName("Testing testAddingTwoPositives method")
        void testAddingTwoPositives() {
            assertEquals(2, mathUtils.add(1, 1),
                    "Add method should return the sum of two numbers");
        }

        @Test
        @DisplayName("Testing testAddingTwoNegatives method")
        void testAddingTwoNegatives() {
            assertEquals(-2, mathUtils.add(-1, -1),
                    "Add method should return the sum of two numbers");
        }

        @Test
        @DisplayName("Testing testAddingAPositiveAndNegative method")
        void testAddingAPositiveAndNegative() {
            assertEquals(0, mathUtils.add(-1, 1),
                    "Add method should return the sum of two numbers");
        }
    }
}