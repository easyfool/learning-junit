package com.wangfengbabe.learning;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by wangfeng on 09/02/2017.
 */
public class MapTest {

  @Test
  public void testMap() {
    Map<String, String> map = new HashMap<String, String>();
    map.put("j", "java");
    map.put("c", "c++");
    map.put("p", "python");
    map.put("n", "node");

    Map<String, String> expected = new HashMap<String, String>();
    expected.put("j", "java");
    expected.put("c", "c++");
    expected.put("p", "python");
    expected.put("n", "node");

    //all passed /true
    //1 .test equal
    assertThat(map, is(expected));

    //2. test size
    assertThat(map.size(), is(4));

    //3. test map entry
    assertThat(map, IsMapContaining.hasEntry("n", "node"));

    assertThat(map, not(IsMapContaining.hasEntry("r", "ruby")));

    //4. test map key
    assertThat(map, IsMapContaining.hasKey("j"));

    //5.test map value
    assertThat(map, IsMapContaining.hasValue("java"));


  }
}
