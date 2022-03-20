package me.xlucash.dzien8;

import java.util.ArrayList;

public class CodeKeeper {
    ArrayList list;
    String[] codes = {"alfa","lambda","gamma","delta","zeta"};

    public CodeKeeper(String[] userCodes) {
        list = new ArrayList();

        for(int i = 0; i<codes.length;i++){
            addCode(codes[i]);
        }

        for(int j = 0;j<userCodes.length;j++){
            addCode(userCodes[j]);
        }

        for (Object o : list) {
            String output = (String) o;
            System.out.println(output);
        }
    }

    private void addCode(String code){
        if(!list.contains(code))
            list.add(code);
    }
    public static void main(String[] arguments) {
        CodeKeeper keeper = new CodeKeeper(arguments);
    }
}
