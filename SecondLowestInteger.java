
/*
Maintain two numbers (lowest, secondLowest)
if (newElem < lowest) lowest = newElem; secondLowest= lowest;
else if (newElem < secondLowest) secondLowest = newElem;
*/

class SecondLowestInteger {
    public static void main(String[] args) {
        System.out.println("Hello world");
        int[] elements = { 0, -1, 2, 10, 3, -3 };
        System.out.println(findSecondLowestInteger(elements));
    }

    public static int findSecondLowestInteger(int[] elements) {
        int lowest = Integer.MAX_VALUE;
        int secondLowest = Integer.MAX_VALUE;
        for (int i = 0; i < elements.length; i++) {
            int element = elements[i];
            if (element < lowest) {
                secondLowest = lowest;
                lowest = element;
            } else if (element < secondLowest) {
                secondLowest = element;
            }
        }
        return secondLowest;
    }
}