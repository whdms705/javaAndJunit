package test.ch07.util;

import main.ch07.util.SparseArray;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import test.ch07.scratch.ExpectToFail;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class  SparseArrayTest{
    SparseArray<Object> array = null;

     @Before
     public void create(){
         array = new SparseArray<>();
     }


    @ExpectToFail
    @Ignore
    @Test
    public void handlesInsertionInDescendingOrder() {
        array.checkInvariants();
         array.put(7, "seven");
        array.checkInvariants();
        array.put(6, "six");
        array.checkInvariants();
        assertThat(array.get(6), equalTo("six"));
        assertThat(array.get(7), equalTo("seven"));
    }

}
