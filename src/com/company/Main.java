package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
        Album album = new Album("Ayaginda Kundura", "Ibrahim tatlises");
        album.addSong("Zalim",4.2);
        album.addSong("Sabuha",3.2);
        album.addSong("Sevgilim",6.2);
        album.addSong("Terk et",4.6);

        albums.add(album);

        album = new Album("Cihanda Firtina", "Mustafa Cihat");
        album.addSong("Keko",4.2);
        album.addSong("Umut Asisi",3.2);
        album.addSong("Zefkin adi",6.2);
        album.addSong("Sevk et",4.6);

        albums.add(album);

        LinkedList<Song> playList= new LinkedList<>();
        albums.get(0).addToPlayList("Sabuha",playList);
        albums.get(0).addToPlayList("Terk et",playList);
        albums.get(0).addToPlayList("Yatinalri et",playList);
        albums.get(0).addToPlayList(2,playList);
        albums.get(1).addToPlayList(3,playList);
        albums.get(1).addToPlayList(2,playList);
        albums.get(1).addToPlayList(11,playList);


        play(playList);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> here = playList.listIterator();
        if (playList.size() == 0){
            System.out.println("No song");
            return;
        }else{
            System.out.println("Playing "+here.next().toString());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action){
                case 0:
                    System.out.println("Playlist is complete");
                    System.exit(0);
                    break;
                case 1:
                    if (!forward){
                        if (here.hasNext()){
                            here.next();
                        }
                        forward = true;
                    }

                    if (here.hasNext()){
                        System.out.println("Now playing "+here.next().toString());
                    }else{
                        System.out.println("Reached the end of the playlist");
                        forward=false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (here.hasPrevious()){
                            here.previous();
                        }
                        forward = false;
                    }

                    if (here.hasPrevious()){
                        System.out.println("Now playing "+here.previous().toString());
                    }else{
                        System.out.println("Reached the begining of the playlist");
                        forward=true;
                    }
                    break;
                case 3:
                    if (forward){
                        if (here.hasPrevious()){
                            System.out.println("Now replaying "+here.previous().toString());
                            forward=false;
                        }else{
                            System.out.println("Reached the start");
                        }
                    }else{
                        if (here.hasNext()){
                            System.out.println("Now replaying "+here.next().toString());
                            forward =true;
                        }else{
                            System.out.println("Reached the end");
                        }
                    }
                    break;
                case 4:printList(playList);
                    break;
                case 5:printMenu();
                    break;
                case 6:
                    if (playList.size() > 0){
                        here.remove();
                        if(here.hasNext()){
                            System.out.println("Now replaying "+here.next().toString());
                        }else if(here.hasPrevious()){
                            System.out.println("Now replaying "+here.previous().toString());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options\nPress");
        System.out.println("0 - Quit\n" +
                "1 - Next Song\n" +
                "2 - Previous Song\n" +
                "3 - Replay Curent Song\n" +
                "4 - List Songs in the play list\n" +
                "5 - Available Actions\n" +
                "6 - Delete the current song");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> itireatorHere= playList.iterator();
        System.out.println("=====================");
        while (itireatorHere.hasNext()){
            System.out.println(itireatorHere.next().toString());
        }
        System.out.println("=====================");
    }
}
