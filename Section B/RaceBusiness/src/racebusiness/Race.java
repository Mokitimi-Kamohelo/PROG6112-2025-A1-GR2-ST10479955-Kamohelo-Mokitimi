/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package racebusiness;

import java.util.Arrays;

public class Race {
    private final String raceName;
    private final Car[] participants;
    private final Driver[] drivers;
    private final double[][] lapTimes;

    public Race(String raceName, Car[] participants, Driver[] drivers, int laps) {
        if (raceName == null || raceName.isBlank()) throw new IllegalArgumentException("raceName required");
        if (participants == null || drivers == null) throw new IllegalArgumentException("null arrays");
        if (participants.length != drivers.length) throw new IllegalArgumentException("participants and drivers must align");
        if (participants.length == 0) throw new IllegalArgumentException("no participants");
        if (laps <= 0) throw new IllegalArgumentException("laps must be > 0");

        this.raceName = raceName;
        this.participants = Arrays.copyOf(participants, participants.length);
        this.drivers = Arrays.copyOf(drivers, drivers.length);
        this.lapTimes = new double[participants.length][laps];
    }

    public String getRaceName() { return raceName; }
    public int getParticipantCount() { return participants.length; }
    public int getLapCount() { return lapTimes[0].length; }

    public void recordLapTime(int participantIndex, int lapIndex, double seconds) {
        if (participantIndex < 0 || participantIndex >= participants.length) throw new IndexOutOfBoundsException();
        if (lapIndex < 0 || lapIndex >= lapTimes[0].length) throw new IndexOutOfBoundsException();
        if (seconds <= 0) throw new IllegalArgumentException("time must be > 0");
        lapTimes[participantIndex][lapIndex] = seconds;
    }

    public double[] averageLapTimes() {
        double[] avgs = new double[participants.length];
        for (int i = 0; i < participants.length; i++) {
            double sum = 0;
            for (int j = 0; j < lapTimes[i].length; j++) {
                sum += lapTimes[i][j];
            }
            avgs[i] = sum / lapTimes[i].length;
        }
        return avgs;
    }

    public int winnerIndexByAverage() {
        double[] avgs = averageLapTimes();
        int bestIdx = 0;
        for (int i = 1; i < avgs.length; i++) {
            if (avgs[i] < avgs[bestIdx]) bestIdx = i;
        }
        return bestIdx;
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Race Report: ").append(raceName).append(" ===\n\n");
        sb.append("Participants (Car -> Driver):\n");
        for (int i = 0; i < participants.length; i++) {
            sb.append(String.format("%d) %s -> %s%n", i + 1, participants[i].summary(), drivers[i].summary()));
        }
        sb.append("\nLap Times (seconds):\n");
        for (int i = 0; i < participants.length; i++) {
            sb.append(participants[i].getBrand())
              .append(" (").append(drivers[i].getName()).append("): ");
            sb.append(Arrays.toString(lapTimes[i])).append("\n");
        }
        double[] avgs = averageLapTimes();
        sb.append("\nAverage Lap Times:\n");
        for (int i = 0; i < avgs.length; i++) {
            sb.append(String.format("%s (%s): %.3f s%n", participants[i].getBrand(), drivers[i].getName(), avgs[i]));
        }
        int winnerIdx = winnerIndexByAverage();
        sb.append("\nWinner: ")
          .append(participants[winnerIdx].getBrand())
          .append(" (").append(drivers[winnerIdx].getName()).append(")")
          .append(" with average lap time ")
          .append(String.format("%.3f s", avgs[winnerIdx]))
          .append("\n");
        return sb.toString();
    }
}
