package io.github.cd871127.conceal.huawei;

import java.util.*;

public class Main {

    private static Map<String, Integer> curMap = new HashMap<>();
    private static Map<Integer, String> reCurMap = new HashMap<>();
    private static Set<String> typeSet = new HashSet<>();
    private static int[][] matrix = new int[4][4];

    static {
        curMap.put("HKD", 0);
        curMap.put("CNY", 1);
        curMap.put("USD", 2);
        curMap.put("GBP", 3);
        reCurMap.put(3, "HKD");
        reCurMap.put(2, "CNY");
        reCurMap.put(1, "USD");
        reCurMap.put(0, "GBP");
        typeSet.addAll(Arrays.asList("MIN", "MAX"));
        for (int i = 0; i < 4; ++i) {
            matrix[i][i] = 1;
        }
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String[] inputArr = check(scanner.nextLine());
//            if (inputArr != null) {
//                System.out.println(go(inputArr));
//            }
//        }
        System.out.println(go(check("2 8 2 1 CNY MAX")));
    }

//System.out.println(go(check("2 8 2 127 HKD MAX")));
//    System.out.println(go(check("2 8 2 1200 CNY MAX")));

    /**
     * 检查输入异常
     *
     * @param input
     * @return 输入数据的数组
     */
    private static String[] check(String input) {
        String[] inputArr = input.split(" ");
        if (inputArr.length != 6) {
            System.out.println("ERROR");
            return null;
        }
        for (int i = 0; i < 4; ++i) {
            try {
                int num = Integer.valueOf(inputArr[i]);
                if (num <= 0) {
                    System.out.println("ERROR");
                    return null;
                }
            } catch (Exception e) {
                System.out.println("ERROR");
                return null;
            }
        }
        if (!curMap.keySet().contains(inputArr[4]) || !typeSet.contains(inputArr[5])) {
            System.out.println("ERROR");
            return null;
        }
        return inputArr;
    }


    /**
     * @param inputArr 输入数组
     * @return
     */
    private static String go(String[] inputArr) {
        //构造一个二维4乘4的矩阵,只需要用到矩阵又下半部分
        matrix[1][0] = Integer.valueOf(inputArr[0]);
        matrix[2][1] = Integer.valueOf(inputArr[1]);
        matrix[3][2] = Integer.valueOf(inputArr[2]);

        matrix[2][0] = matrix[1][0] * matrix[2][1];
        matrix[3][1] = matrix[3][2] * matrix[2][1];

        matrix[3][0] = matrix[1][0] * matrix[2][1] * matrix[3][2];
        int count = Integer.valueOf(inputArr[3]);
        int source = curMap.get(inputArr[4]);
        ArrayList<Integer> resList = new ArrayList<>(4);
        StringBuilder stringBuilder = new StringBuilder();
        if ("MAX".equals(inputArr[5])) {
            exchange(count, source, 3, resList);
            for (int i = 0; i != resList.size(); ++i) {
                if (resList.get(i) != 0) {
                    stringBuilder.append(resList.get(i));
                    stringBuilder.append(" ");
                    stringBuilder.append(reCurMap.get(i));
                    if (i != resList.size() - 1) {
                        stringBuilder.append(" ");
                    }
                }
            }

        } else {
            stringBuilder.append(count * matrix[source][0]);
            stringBuilder.append(" HKD");
        }

        return stringBuilder.toString();
    }


    private static void exchange(int count, int source, int target, ArrayList<Integer> resList) {
        resList.add(count / matrix[target][source]);
        int tmp = count % matrix[target][source];
        if (tmp == 0) {
            return;
        }
        exchange(tmp, source, target - 1, resList);
    }

}

//2 8 2 127 HKD MAX
//1 6 1 127 HKD Min
