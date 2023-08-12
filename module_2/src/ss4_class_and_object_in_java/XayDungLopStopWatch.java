package ss4_class_and_object_in_java;

public class XayDungLopStopWatch {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i=0; i<arr.length; i++) {
            arr[i] = (int)Math.floor(Math.random() * (100000-0+1))+0;
        }
        StopWatch watch = new StopWatch();
        watch.start();
//        System.out.println("Array includes 100000 numbers: ");
//        for (int element: arr) {
//            System.out.print(element + " ");
//        }
        sortNums(arr);
//        System.out.println("");
//        System.out.println("Array after sort: ");
//        for (int element: arr) {
//            System.out.print(element + " ");
//        }
        watch.stop();
        System.out.println("");
        System.out.println("Sort time is " + watch.getElapsedTime() + " ms");
    }
    public static void sortNums(int[] arr){
        int currentNum, tempIndex;
        for (int i=0; i<arr.length-1; i++) {
            currentNum = arr[i];
            tempIndex = i;
            for (int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[tempIndex]) {
                    tempIndex = j;
                }
            }
            arr[i] = arr[tempIndex];
            arr[tempIndex] = currentNum;
        }
    }
}

class StopWatch {
    private long startTime, endTime;
    StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.endTime-this.startTime;
    }
}
