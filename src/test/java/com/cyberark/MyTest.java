
package com.cyberark;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.graphwalker.core.condition.EdgeCoverage;
import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.generator.RandomPath;
import org.graphwalker.core.model.Edge;
import org.graphwalker.java.test.TestBuilder;
import org.graphwalker.core.condition.TimeDuration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/** 
* Set Class name
* Set Model name this class implements
* Set Model name in MODEL_PATH
* Set vertex name for the smoke-test to stop at
*/

/** *** Set Class & Model names *** */
public class MyTest extends ExecutionContext implements MyModel {

  public final static Path MODEL_PATH = Paths.get("com/cyberark/MyModel.json"); // *** Set model name ***


  @Override
  public void e_Add()
  {
    System.out.println( "e_Add" );
    // throw new RuntimeException( "e_Add is not implemented yet!" );
  }


  @Override
  public void e_Find()
  {
    System.out.println( "e_Find" );
    // throw new RuntimeException( "e_Find is not implemented yet!" );
  }


  @Override
  public void e_FindFakeVal()
  {
    System.out.println( "e_FindFakeVal" );
    // throw new RuntimeException( "e_FindFakeVal is not implemented yet!" );
  }


  @Override
  public void e_Init()
  {
    System.out.println( "e_Init" );
    // throw new RuntimeException( "e_Init is not implemented yet!" );
  }


  @Override
  public void v_Added()
  {
    System.out.println( "v_Added" );
    // throw new RuntimeException( "v_Added is not implemented yet!" );
  }


  @Override
  public void v_Found()
  {
    System.out.println( "v_Found" );
    // throw new RuntimeException( "v_Found is not implemented yet!" );
  }


  @Override
  public void v_NotFound()
  {
    System.out.println( "v_NotFound" );
    // throw new RuntimeException( "v_NotFound is not implemented yet!" );
  }


  @Override
  public void v_Start()
  {
    System.out.println( "v_Start" );
    // throw new RuntimeException( "v_Start is not implemented yet!" );
  }


  @Override
  public void v_VerifyInitialState()
  {
    System.out.println( "v_VerifyInitialState" );
    // throw new RuntimeException( "v_VerifyInitialState is not implemented yet!" );
  }



  /** *** Set the Class names in the tests *** */
  
  @Test
    public void runSmokeTest() {
        new TestBuilder()
                .addContext(new MyTest().setNextElement(new Edge().setName("e_Init").build()),
                        MODEL_PATH,
                        new AStarPath(new ReachedVertex("v_MyVertex"))) // *** Set vertex name of the vertex to stop at ***
                .execute();
    }

    @Test
    public void runFunctionalTest() {
        new TestBuilder()
                .addContext(new MyTest().setNextElement(new Edge().setName("e_Init").build()),
                        MODEL_PATH,
                        new RandomPath(new EdgeCoverage(100))) // cover all edges
                .execute();
    }

    @Test
    public void runStabilityTest() {
        new TestBuilder()
                .addContext(new MyTest().setNextElement(new Edge().setName("e_Init").build()),
                        MODEL_PATH,
                        new RandomPath(new TimeDuration(1, TimeUnit.SECONDS))) // run the test for 1 second
                .execute();
    }
}

