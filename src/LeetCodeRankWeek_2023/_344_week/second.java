package LeetCodeRankWeek_2023._344_week;

// @date 2023/5/7
// @time 10:25
// @author zhangzhi
// @description

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class FrequencyTracker {

    private Set<Integer> set;
    private Map<Integer, Integer> map;

    public FrequencyTracker() {
        this.set = new HashSet<>();
        this.map = new HashMap<>();
    }

    public void add(int number) {
        if(set.add(number)) {
            map.put(number, map.get(number) + 1);
        }else{
            map.put(number, 1);
        }
    }

    public void deleteOne(int number) {
        if(set.contains(number)){
            Integer fre = map.get(number);
            if(fre == 1){
                map.remove(number);
                set.remove(number);
            }else{
                fre -= 1;
                map.put(number, fre);
            }
        }
    }

    public boolean hasFrequency(int frequency) {
        return false;
    }
}
public class second {

}
