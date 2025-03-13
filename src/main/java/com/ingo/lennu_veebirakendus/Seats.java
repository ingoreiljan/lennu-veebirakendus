package com.ingo.lennu_veebirakendus;

import java.util.*;

public class Seats {

    private static final int TOTAL_SEATS = 48;

    private final Set<Integer> occupiedSeats;
    private final List<Integer> recommendedSeats;

    public Seats(Boolean windowPref, Boolean legroomPref, Set<Integer> existingOccupiedSeats) {
        this.occupiedSeats = (existingOccupiedSeats != null) ? existingOccupiedSeats : generateOccupiedSeats();
        this.recommendedSeats = new ArrayList<>();

        generateRecommendedSeats(windowPref, legroomPref);
    }

    private Set<Integer> generateOccupiedSeats() {
        Set<Integer> occupied = new HashSet<>();
        Random random = new Random();

        // Randomly occupy seats (between 5 and 30)
        int seatsToOccupy = random.nextInt(26) + 5;

        while (occupied.size() < seatsToOccupy) {
            occupied.add(random.nextInt(TOTAL_SEATS));
        }

        return occupied;
    }

    private void generateRecommendedSeats(Boolean windowPref, Boolean legroomPref) {
        for (int i = 0; i < TOTAL_SEATS; i++) {
            boolean isWindow = (i % 6 == 0 || i % 6 == 5);
            boolean isLegroom = (i < 6);

            if (!occupiedSeats.contains(i)) {
                if ((Boolean.TRUE.equals(windowPref) && Boolean.TRUE.equals(legroomPref) && isWindow && isLegroom) ||
                        (Boolean.TRUE.equals(windowPref) && !Boolean.TRUE.equals(legroomPref) && isWindow) ||
                        (!Boolean.TRUE.equals(windowPref) && Boolean.TRUE.equals(legroomPref) && isLegroom)) {
                    recommendedSeats.add(i);
                }
            }
        }
    }

    public Map<String, Object> getSeatData() {
        Map<String, Object> seatData = new HashMap<>();
        seatData.put("occupiedSeats", occupiedSeats);
        seatData.put("recommendedSeats", recommendedSeats);
        return seatData;
    }

    public Set<Integer> getOccupiedSeats() {
        return occupiedSeats;
    }
}
