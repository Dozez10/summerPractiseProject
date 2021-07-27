package game.util;

import java.util.Arrays;
import java.util.List;

public class HelperInterpreter {

    public static List<Integer> findClosestDivisors(int fn){
        int fD=fn,sD=1,fnAbsolute = Math.abs(fn);
        for (int i =fnAbsolute/2;i>0;i--){
            if(fnAbsolute%i==0){
                sD = fD;
                fD = fnAbsolute/i;
                if(fD>i)break;
            }
        }
        return Arrays.asList(sD,fn/sD);
    }
}
