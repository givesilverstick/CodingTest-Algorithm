import java.util.*;

class Solution {
    
    class Song {
        int id;
        int plays;
        Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<Song>> genreSong = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            genreTotal.put(genres[i], genreTotal.getOrDefault(genres[i], 0) + plays[i]);
            genreSong.putIfAbsent(genres[i], new ArrayList<>());
            genreSong.get(genres[i]).add(new Song(i, plays[i]));
        }        
        
        List<String> genreOrder = new ArrayList<>(genreTotal.keySet());
        genreOrder.sort((a,b) -> genreTotal.get(b) - genreTotal.get(a));
        
        List<Integer> answerList = new ArrayList<>();
        for (String genre : genreOrder) {
            List<Song> songs = genreSong.get(genre);
            songs.sort((s1, s2) -> {
                if (s1.plays == s2.plays) return s1.id - s2.id;
                return s2.plays - s1.plays;
            });
            for (int i=0; i<Math.min(2, songs.size()); i++) {
                answerList.add(songs.get(i).id);
            }
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}