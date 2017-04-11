import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import static org.junit.Assert.*;

import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.rules.ErrorCollector;

public class TestField {

  @Rule
  public ErrorCollector collector= new ErrorCollector();

  public static void main(String[] args) {
    System.out.println("Test Innitialised");
    method();
    System.out.println("Test end");
  }

  @Test
  public void setUp()
  {
    System.out.println(new Label("my label").getImage());
    System.out.println(new Label("my label2").getImage());
    System.out.println(new Attribute("my attribute").getImage());
    System.out.println(new Description("my description").getImage());
  }

  private void method() {
    collector.assertEquals(false, 1);
  }
}