
package com.cyberark;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.graphwalker.core.condition.ReachedVertex;
import org.graphwalker.core.generator.AStarPath;
import org.graphwalker.core.model.Edge;
import org.graphwalker.java.test.TestBuilder;
import org.junit.Test;

public class BstTest extends ExecutionContext implements BstModel {

  public final static Path MODEL_PATH = Paths.get("com/cyberark/BstModel.json");
  private Bst<Integer> bst;


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


  @Test
    public void runSmokeTest() {
        new TestBuilder()
                .addContext(new BstTest().setNextElement(new Edge().setName("e_Init").build()),
                        MODEL_PATH,
                        new AStarPath(new ReachedVertex("v_Found")))
                .execute();
    }
}

