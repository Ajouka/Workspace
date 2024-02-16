import java.util.Arrays;

public class Sort34 {

    public static int[] sort34(int[] nums) throws Wrong34Exception {
        int count3 = 0;
        int count4 = 0;
        boolean darf4 = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                if (i!= nums.length-1&&nums[i + 1] == 3) throw new Wrong34Exception("mehrere 3 nacheinander");
                else {
                    count3++;
                    darf4 = true;
                }
            }
            if (nums[i] == 4) {
                if (!darf4) throw new Wrong34Exception("ein 3 soll vor dem 4 erscheinen");
                else {
                    count4++;
                    darf4 = false;
                }
            }

        }
        if (count3 != count4) throw new Wrong34Exception("die 3 anzahl ungleich die 4");
        else {
            int[] res = new int[nums.length];
            int index = 0;
            for (int num : nums) {
                if (num == 3) {
                    res[index] = num;
                    index++;
                    res[index] = 4;
                    index++;

                } else if (num != 4) {
                    res[index] = num;
                    index++;
                }


            }


            return res;
        }

    }

    public static class Wrong34Exception extends Exception {
        public Wrong34Exception(String message) {
            super(message);
        }
    }


    public static void main(String[]args) throws Wrong34Exception {


        int[]a={3,4,5,6,6,6,6,6,6,3,4,3,4};
        int[]a1={3,4};
        int[]a2={4,3};
        int[]a3={3,1,2,4,3,1,2,3,4};

        System.out.println(Arrays.toString(sort34(a3)));




    }
}
