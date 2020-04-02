
package com.cyberark;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

import org.junit.Test;

public class BstTest extends ExecutionContext implements BstModel {

  public final static Path MODEL_PATH = Paths.get("com/cyberark/BstModel.json");
  private Bst<Integer> bst;
  ArrayList<Integer> vals;
  private int valsCounter;
  private boolean result;

  @Override
  public void e_Add()
  {
    System.out.println( "e_Add" );
    bst.add(vals.set(valsCounter, valsCounter++));
  }


  @Override
  public void e_Find()
  {
    System.out.println( "e_Find" );
    result = bst.find(vals.get(valsCounter-1));
  }


  @Override
  public void e_Init()
  {
    System.out.println( "e_Init" );
    bst = new Bst<Integer>();
    vals = new ArrayList<Integer>();
    for(int i=0;i<1000;++i){
      vals.add(i, i);
    }
    valsCounter = 0;
    result = false;
  }


  @Override
  public void v_Added()
  {
    System.out.println( "v_Added" );
    assertEquals(valsCounter, bst.nodes().size());
  }


  @Override
  public void v_Found()
  {
    System.out.println( "v_Found" );
    assertTrue("Find failed!", result);
  }


  @Override
  public void v_Start()
  {
    System.out.println( "v_Start" );
  }


  @Override
  public void v_VerifyInitialState()
  {
    System.out.println( "v_VerifyInitialState" );
    assertNotNull(bst);
  }

  
/** https://github.com/GraphWalker/graphwalker-project/wiki/Test-execution */

  @Test
    public void runSmokeTest() {
        new TestBuilder()
                .addContext(new BstTest().setNextElement(new Edge().setName("e_Init").build()),
                        MODEL_PATH,
                        new AStarPath(new ReachedVertex("v_Found")))
                .execute();
    }

    @Test
    public void runFunctionalTest() {
        new TestBuilder()
                .addContext(new BstTest().setNextElement(new Edge().setName("e_Init").build()),
                        MODEL_PATH,
                        new RandomPath(new EdgeCoverage(100)))
                .execute();
    }

    @Test
    public void runStabilityTest() {
        new TestBuilder()
                .addContext(new BstTest().setNextElement(new Edge().setName("e_Init").build()),
                        MODEL_PATH,
                        new RandomPath(new TimeDuration(1, TimeUnit.SECONDS)))
                .execute();
    }
}

