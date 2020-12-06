import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Day3
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        List<String> lines = br.lines().collect(Collectors.toList());

        treeEncounterCount(lines);
    }

    public static void treeEncounterCount(List<String> lines)
    {
        int firstAns = treeEncounterCountCustom(3, 1, lines);
        int secondAns = firstAns * treeEncounterCountCustom(1, 1, lines)
                                * treeEncounterCountCustom(5, 1, lines)
                                * treeEncounterCountCustom(7, 1, lines)
                                * treeEncounterCountCustom(1, 2, lines);

        System.out.println(firstAns);
        System.out.println(secondAns);
    }

    public static int treeEncounterCountCustom(int right, int down, List<String> lines)
    {
        int count = 0;

        int idx = right;
        final int MAX_IDX = 30;
        for(int i = down, lSize = lines.size(); i < lSize; i += down)
        {
            if(lines.get(i).charAt(idx) == '#')
            {
                ++count;
            }

            idx += right;
            if(idx > MAX_IDX)
            {
                idx %= MAX_IDX;
                --idx;
            }
        }

        return count;
    }
}
