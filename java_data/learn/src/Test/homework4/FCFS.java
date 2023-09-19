package Test.homework4;

import java.util.ArrayList;
import java.util.Random;

public class FCFS {
    static final int TRACK_NUM = 10;
    static final int INIT_TRACK = 100;
    public static void main(String[] args) {
        ArrayList<Integer> trackList;
        ArrayList<Integer> moveList;
        trackList = randomTrackList();
        moveList = calMoveDiscount(trackList);
        printViewTrack(trackList, moveList);
    }

    public static void printViewTrack(ArrayList<Integer> trackList, ArrayList<Integer> moveList) {
        double sum = 0;
        System.out.println("\t\t(从" + INIT_TRACK + "磁道开始)");
        System.out.println("被访问的下一个磁道号\t移动距离");
        for (int i = 0; i < trackList.size(); i++) {
            System.out.println("    " + trackList.get(i) + "\t\t\t\t " + moveList.get(i));
            sum += moveList.get(i);
        }
        System.out.println("\t平均寻道长度为: " + sum / TRACK_NUM);
    }

    private static ArrayList<Integer> calMoveDiscount(ArrayList<Integer> trackList) {
        ArrayList<Integer> moveList = new ArrayList<>();
        int currTrack = INIT_TRACK;
        int discount;
        for (int i = 0; i < trackList.size(); i++) {
            discount = Math.abs(currTrack - trackList.get(i));
            currTrack = trackList.get(i);
            moveList.add(discount);
        }
        return moveList;
    }

    private static ArrayList<Integer> randomTrackList() {
        ArrayList<Integer> trackList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < TRACK_NUM; i++) {
            int track = random.nextInt(200);
            if(!isAdded(track, trackList))
                trackList.add(track);
            else
                i--;
        }
        return trackList;
    }

    public static boolean isAdded(int track, ArrayList<Integer> trackList) {
        for (int i = 0; i < trackList.size(); i++) {
            if(trackList.get(i) == track)
                return true;
        }
        return false;
    }
}
