import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class Day2
{
    public static void main(String[] args) throws FileNotFoundException
    {
        BufferedReader br = new BufferedReader(new FileReader("src/input.txt"));
        List<String> lines = br.lines().collect(Collectors.toList());
        
        validPasswords(lines);
        validPasswords2(lines);
    }

    public static void validPasswords(List<String> lines)
    {
        int validCount = 0;
        for(String s : lines)
        {
            String[] arr = parse(s);
            int min = Integer.parseInt(arr[0]);
            int max = Integer.parseInt(arr[1]);
            char elem = arr[2].charAt(0);

            int count = 0;
            for(int i = s.indexOf(':') + 2, strLen = s.length(); i < strLen; ++i)
            {
                if(s.charAt(i) == elem)
                {
                    ++count;
                }
            }

            if(count >= min && count <= max)
            {
                ++validCount;
            }
        }

        System.out.println(validCount);
    }

    public static void validPasswords2(List<String> lines)
    {
        int validCount = 0;
        for(String s : lines)
        {
            String[] arr = parse(s);
            String searchString = s.substring(s.indexOf(':') + 2);
            int firstPos = Integer.parseInt(arr[0]) - 1;
            int secondPos = Integer.parseInt(arr[1]) - 1;
            char elem = arr[2].charAt(0);

            char firstChar = searchString.charAt(firstPos);
            char secondChar = searchString.charAt(secondPos);

            if((firstChar == elem && secondChar != elem) || (secondChar == elem && firstChar != elem))
            {
                ++validCount;
            }
        }
        System.out.println(validCount);
    }

    //first element is min occurrences, middle is max occurrences, last is character for the rule
    public static String[] parse(String line)
    {
        String[] parsedInput = new String[3];

        int endIdx = 0;
        while(line.charAt(endIdx) != '-')
        {
            ++endIdx;
        }

        parsedInput[0] = line.substring(0, endIdx);

        ++endIdx;
        int startIdx = endIdx;
        while(line.charAt(endIdx) != ' ')
        {
            ++endIdx;
        }

        parsedInput[1] = line.substring(startIdx, endIdx);
        parsedInput[2] = line.substring(endIdx + 1, endIdx + 2);
        return parsedInput;
    }

}
