import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MinPricePerInterval {

    public static class PI {
        private int _start;
        private int _end;
        private int _price;

        public PI(int start, int end, int price) {
            this._start = start;
            this._end = end;
            this._price = price;
        }

        public int getStart() {
            return this._start;
        }

        public int getEnd() {
            return this._end;
        }

        public int getPrice() {
            return this._price;
        }

        public void setStart(int _start) {
            this._start = _start;
        }

        public void setEnd(int _end) {
            this._end = _end;
        }

        public void setPrice(int _price) {
            this._price = _price;
        }

        public String toString() { 
            return "Start: '" + this._start + "', End: '" + this._end + "', Price: '" + this._price + "'";
        } 
    }

    public static void main(String[] args) {
        List<PI> input = new ArrayList<PI>() {
            {
                add(new PI(0, 4, 5));
                add(new PI(2, 8, 3));
                add(new PI(7, 11, 10));
            }
        };
        // result new PI(0, 2, 5), new PI(2, 8, 3), new PI(8, 11, 10)
        GetMinPricePerInterval(input).stream().forEach(System.out::println);
        List<PI> input2 = new ArrayList<PI>() {
            {
                add(new PI(0, 8, 5));
                add(new PI(2, 4, 3));
                add(new PI(7, 11, 10));
            }
        };
        // result new PI(0, 2, 5), new PI(2, 4, 3), new PI(4, 8, 5) new PI(8, 11, 10)
        GetMinPricePerInterval(input2).stream().forEach(System.out::println);
        List<PI> input3 = new ArrayList<PI>() {
            {
                add(new PI(0, 3, 5));
                add(new PI(1, 2, 3));
            }
        };
        // result new PI(0, 1, 5), new PI(1, 2, 3), new PI(2, 3, 5)
        GetMinPricePerInterval(input3).stream().forEach(System.out::println);
    }

    public static List<PI> GetMinPricePerInterval(List<PI> priceIntervals)
    {

        var result = new ArrayList<PI>();

        var map = new TreeMap<Integer, Integer>();

        for (PI pi : priceIntervals) {
            var currentPrice = pi.getPrice();
            for (int i = pi.getStart(); i < pi.getEnd(); i++) {
                if (map.containsKey(i)) {
                    var currentVal = map.get(i);
                    if (currentVal < currentPrice) {
                        map.put(i, currentVal);
                    } else {
                        map.put(i, currentPrice);
                    }
                } else {
                    map.put(i, currentPrice);
                }
            }
        }

        // map.entrySet().stream().forEach(System.out::println);

        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (result.size() > 0) {
                PI latestItem = result.get(result.size() - 1);
                if (latestItem.getPrice() != item.getValue()) {
                    latestItem.setEnd(item.getKey());
                    result.add(new PI(item.getKey(), item.getKey() + 1, item.getValue()));
                } else {
                    latestItem.setEnd(item.getKey() + 1);
                }

            } else {
                result.add(new PI(item.getKey(), item.getKey() + 1, item.getValue()));
            }
        }

        return result;
    }
}
