import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        List<Integer> nums = br.lines().collect(Collectors.toList())
                            .stream().map(Integer::parseInt).collect(Collectors.toList());

        find2020TwoNums(nums);
        find2020ThreeNums(nums);
    }

    public static void find2020TwoNums(List<Integer> nums)
    {
        System.out.println(twoSum(nums, 2020));
    }

    public static void find2020ThreeNums(List<Integer> nums)
    {
        for(int num : nums)
        {
            int target = 2020 - num;
            int value = twoSum(nums, target);
            if(value != -1)
            {
                System.out.println(value * num);
                break;
            }
        }
    }

    public static int twoSum(List<Integer> nums, int target)
    {
        Set<Integer> seenNums = new HashSet<>();

        for(int num : nums)
        {
            int missingNum = target - num;
            if(seenNums.contains(missingNum))
            {
                return num * missingNum;
            }
            else
            {
                seenNums.add(num);
            }
        }

        return -1;
    }
}
