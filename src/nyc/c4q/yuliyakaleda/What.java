package nyc.c4q.yuliyakaleda;
/**
 * Created by July on 4/2/15.
 */

import java.util.HashSet;

public class What
{
    public static void main(String[] args)
    {
        HashSet<Integer> odd = new HashSet<Integer>();
        odd.add(1);
        odd.add(16);
        odd.add(3);
        odd.add(57);
        odd.remove(57);


        HashSet<Integer> even = new HashSet<Integer>();
        even.add(2);
        even.add(1);
        even.add(3);
        even.add(4);

        //odd.addAll(even);
        //odd-even
        odd.removeAll(even);

        for (Integer num : odd){
            System.out.println(num);

        }
    }
}
