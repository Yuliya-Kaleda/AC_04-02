package nyc.c4q.yuliyakaleda;
/**
 * Created by Yuliya Kaleda on 4/2/15.
 * Practice on HashSets by creating sets of friends
 */
import java.util.HashSet;

public class SocialNetwork {

    public static void main(String[] args) {
        HashSet<String> yours = new HashSet();
        yours.add("Yelena");
        yours.add("Jamal");
        yours.add("Eve");
        HashSet<String> mine = new HashSet();
        mine.add("Sebastian");
        mine.add("Mala");
        mine.add("Eve");

        // You should be able to run all of these in a row:
        System.out.println( allFriends(yours, mine) );
        System.out.println( mutualFriends(yours, mine) );
        System.out.println( justYourFriends(yours, mine) );
        System.out.println( justMyFriends(yours, mine) );
        System.out.println( exclusiveFriends(yours, mine) );
        System.out.println( yourFriendsAreMine(yours, mine) );
        System.out.println( youHaveFriends(yours) );
        System.out.println( matchmaker(yours, mine) );
    }

    public static HashSet<String> allFriends(HashSet<String> yours, HashSet<String> mine) {
        HashSet<String> allFriends = new HashSet<String>();
        allFriends.addAll(yours);
        allFriends.addAll(mine);
        return allFriends;
        // Yelena, Jamal, Eve, Sebastian, Mala
    }

    public static HashSet<String> mutualFriends(HashSet<String> yours, HashSet<String> mine) {
        HashSet<String> mutualFriends = new HashSet<String>();
        for (String n : yours) {
            if (mine.contains(n))
                mutualFriends.add(n);
        }
        return mutualFriends;
        //Eve
    }

    public static HashSet<String> justYourFriends(HashSet<String> yours, HashSet<String> mine) {
        HashSet<String> justYourFriends = new HashSet<String>();
        justYourFriends.addAll(yours);
        justYourFriends.removeAll(mutualFriends(yours, mine));
        return justYourFriends;
        // Yelena, Jamal
    }

    public static HashSet<String> justMyFriends(HashSet<String> yours, HashSet<String> mine) {
        HashSet<String> justMyFriends = new HashSet<String>();
        justMyFriends.addAll(mine);
        justMyFriends.removeAll(mutualFriends(yours, mine));
        return justMyFriends;
        // Sebastian, Mala
    }

    public static HashSet<String> exclusiveFriends(HashSet<String> yours, HashSet<String> mine) {
        HashSet<String > exclusiveFriends = new HashSet<String>();
        exclusiveFriends.addAll(justMyFriends(yours, mine));
        exclusiveFriends.addAll(justYourFriends(yours, mine));
        return exclusiveFriends;
        // Yelena, Jamal, Sebastian, Mala
    }

    public static boolean yourFriendsAreMine(HashSet<String> yours, HashSet<String> mine) {
        return ((mutualFriends(yours, mine)==yours) && (mutualFriends(yours, mine)==mine));
        // true if all your friends are also my friends
    }

    public static boolean youHaveFriends(HashSet<String> yours) {
        return (yours.size()!=0);
        // true if you have any friends
    }

    public static HashSet<HashSet<String>> matchmaker(HashSet<String> yours, HashSet<String> mine) {
        HashSet<HashSet<String>> matchmaker = new HashSet<HashSet<String>>();
        for (String n : yours) {
            for (String name : mine) {
                if (n!=name)
                {
                    HashSet<String> evePlus = new HashSet<String>();
                    evePlus.add(n);
                    evePlus.add(name);
                    matchmaker.add(evePlus);
                }
            }
        }
        return matchmaker;
        // should return these sets:
        // Sebastian, Jamal
        // Jamal, Mala
        // Jamal, Eve
        // Sebastian, Yelena
        // Yelena, Mala
        // Yelena, Eve
        // Sebastian, Eve
        // Mala, Eve
    }
}