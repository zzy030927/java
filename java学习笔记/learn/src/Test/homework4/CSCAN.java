package Test.homework4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CSCAN {
    static final int TRACK_NUM = 10;
    static final int INIT_TRACK = 100;                          // ��ʼ����ǰ���ڵĴŵ�
    public static void main(String[] args) {
        ArrayList<Integer> randomTrackList;
        ArrayList<Integer> moveList;
        ArrayList<Integer> trackList;
        randomTrackList = randomTrackList();                    // ����һ������ŵ��б�
        trackList = cscan(randomTrackList);                     // CSCAN�㷨���������Ҫ���ʵĴŵ�
        moveList = calMoveDiscount(trackList);                  // ����ŵ��ľ���
        printViewTrack(trackList, moveList);
    }

    private static ArrayList<Integer> cscan(ArrayList<Integer> randomTrackList) {
        ArrayList<Integer> newTrackList = new ArrayList<>();
        int discount;
        for (int i = 0; i < randomTrackList.size(); i++) {
            discount = randomTrackList.get(i) - INIT_TRACK;
            if (discount > 0) {
                newTrackList.add(randomTrackList.get(i));
                randomTrackList.remove(i--);
            }
        }
        Collections.sort(newTrackList);
        Collections.sort(randomTrackList);
        newTrackList.addAll(randomTrackList);
        return newTrackList;
    }

    public static void printViewTrack(ArrayList<Integer> trackList, ArrayList<Integer> moveList) {
        double sum = 0;
        System.out.println("\t\t(��" + INIT_TRACK + "�ŵ���ʼ)");
        System.out.println("�����ʵ���һ���ŵ���\t�ƶ�����");
        for (int i = 0; i < trackList.size(); i++) {
            System.out.println("    " + trackList.get(i) + "\t\t\t\t " + moveList.get(i));
            sum += moveList.get(i);
        }
        System.out.println("\tƽ��Ѱ������Ϊ: " + sum / TRACK_NUM);
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
        System.out.print("���ڵ����Ĵŵ���: ");
        for (int i = 0; i < trackList.size(); i++) {
            System.out.print(trackList.get(i) + " ");
        }
        System.out.println();
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
