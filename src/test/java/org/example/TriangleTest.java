package org.example;

import hw_4.MyException;
import hw_4.TaskClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class TriangleTest {
        @Test
        void test_1() throws MyException {
            TaskClass taskClass = new TaskClass();
            Assertions.assertEquals( 290.4737509655563, taskClass.training(20,30,40));
            Assertions.assertThrows(MyException.class,() -> taskClass.training(7, -5, 9));
            Assertions.assertThrows(MyException.class,() -> taskClass.training(7, 0, 9));
            Assertions.assertThrows(MyException.class,() -> taskClass.training(7, 3, 2));

        }
//    @ParameterizedTest
//    @CsvSource({"30, 15, 20, 133.31705629813464"})
//    void testWithSource (double a, double b, double c, double result) throws MyException{
//           TaskClass taskClass2 = new TaskClass();
//            Assertions.assertEquals(result, taskClass2.training(a, b, c));
//        }

                }

