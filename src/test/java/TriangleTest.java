import hw_4.MyException;
import hw_4.TaskClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class TriangleTest {
        @Test
        void test() throws MyException {
            TaskClass taskClass = new TaskClass();
            Assertions.assertEquals( 290.4737509655563, taskClass.training(20,30,40));
            Assertions.assertThrows(MyException.class,() -> taskClass.training(7, -5, 9));
        }
    @ParameterizedTest
    @CsvSource({"20, 30, 40, 45, " })
    void testWithSource (double a, double b, double c, double p, double result) throws MyException{
            TaskClass taskClass = new TaskClass();
            Assertions.assertEquals(result, taskClass.training(a, b, c));
        }
                }

