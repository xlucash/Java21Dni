package me.xlucash.dzien17;

import java.nio.*;
public class ReadTemps {
    public ReadTemps() {
        int[] temperatures = { 78, 80, 75, 70, 79, 85, 92, 99, 90 };
        IntBuffer tempBuffer = IntBuffer.wrap(temperatures);
        int[] moreTemperatures = { 65, 44, 71 };
        tempBuffer.put(moreTemperatures);
        System.out.println("Pierwszy int: " + tempBuffer.get());
    }
    // D is correct because the programme lacks the main() method
    public static void main(String[] args) {
        new ReadTemps();
    }
    //with main() method the answer C would be correct the output would be 70
}
