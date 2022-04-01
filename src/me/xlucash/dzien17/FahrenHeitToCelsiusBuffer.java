package me.xlucash.dzien17;

import java.nio.IntBuffer;

public class FahrenHeitToCelsiusBuffer {
    public static void main(String[] args) {
        int[] temps = { 90, 85, 87, 78, 80, 75, 70, 79, 85, 92, 99 };
        IntBuffer tempBuffer = IntBuffer.allocate(temps.length);
        for (int i = 0; i < temps.length; i++) {
            float celsius = ( (float) temps[i] - 32 ) / 9 * 5;
            tempBuffer.put( (int) celsius );
        }
        tempBuffer.position(0);
        for (int i = 0; tempBuffer.remaining() > 0; i++) {
            System.out.println(tempBuffer.get());
        }
    }
}
