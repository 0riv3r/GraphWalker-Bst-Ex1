
package com.cyberark;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
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

public class BstTest extends ExecutionContext implements BstModel {

  public final static Path MODEL_PATH = Paths.get("com/cyberark/BstModel.json");
  private Bst<Integer> bst;
  private ArrayList<Integer> vals;
  private HashSet<Integer> inTree;
  private Random rand;
  private boolean result;

  @Override
  public void e_Add()
  {
    System.out.println( "e_Add" );
    int val = vals.get(rand.nextInt(vals.size()));
    bst.add(val);
    inTree.add(val);
  }


  @Override
  public void e_Find()
  {
    System.out.println( "e_Find" );
    //convert HashSet to an array to fetch element by random index
    Integer[] arrInTreeVals = inTree.toArray( new Integer[inTree.size()] );
    int randomIndex = rand.nextInt(inTree.size());
    result = bst.find(arrInTreeVals[randomIndex]);
  }


  @Override
  public void e_Init()
  {
    System.out.println( "e_Init" );
    bst = new Bst<Integer>();
    vals = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 6, 7, 8, 10, 13, 14));
    inTree = new HashSet<Integer>();
    rand = new Random();
    result = false;
  }


  @Override
  public void v_Added()
  {
    System.out.println( "v_Added" );
    assertEquals(inTree.size(), bst.nodes().size());
  }


  @Override
  public void v_Found()
  {
    System.out.println( "v_Found" );
    assertTrue(result, "Find failed!");
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

