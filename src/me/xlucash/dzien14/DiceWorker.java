package me.xlucash.dzien14;

import javax.swing.*;

public class DiceWorker extends SwingWorker {
    int timesToRoll;

    public DiceWorker(int timesToRoll)
    {
        super();
        this.timesToRoll = timesToRoll;
    }

    @Override
    protected Object doInBackground() throws Exception {
        int[] result = new int[16];
        for(int i = 0;i<this.timesToRoll;i++)
        {
            int sum = 0;
            for(int j = 0;j<3;i++)
            {
                sum+=Math.floor(Math.random()*6);
            }
            result[sum]=result[sum]+1;
        }

        return result;
    }
}
