PACKAGE ME.XLUCASH.DZIEN15;

IMPORT JAVA.IO.*;
IMPORT JAVA.NIO.FILE.FILESYSTEM;
IMPORT JAVA.NIO.FILE.FILESYSTEMS;
IMPORT JAVA.NIO.FILE.FILES;
IMPORT JAVA.NIO.FILE.PATH;


PUBLIC CLASS ALLCAPSDEMO {
    PUBLIC STATIC VOID MAIN(STRING[] ARGS) {
        IF(ARGS.LENGTH<1)
        {
            SYSTEM.OUT.PRINTLN("MUSISZ WPISAĆ NAZWĘ PLIKU");
            SYSTEM.EXIT(-1);
        }
        ALLCAPS CAP = NEW ALLCAPS(ARGS[0]);
        CAP.CONVERT();

    }
}
CLASS ALLCAPS {
    STRING SOURCENAME;
    ALLCAPS(STRING SOURCEARG)
    {
        SOURCENAME= SOURCEARG;
    }
    VOID CONVERT()
    {
        TRY {
            FILESYSTEM FS = FILESYSTEMS.GETDEFAULT();
            PATH SOURCE = FS.GETPATH(SOURCENAME);
            PATH TEMP = FS.GETPATH("TMP_"+SOURCENAME);

            FILEREADER FR = NEW FILEREADER(SOURCE.TOFILE());
            BUFFEREDREADER IN = NEW BUFFEREDREADER(FR);

            FILEWRITER FW = NEW FILEWRITER(TEMP.TOFILE());
            BUFFEREDWRITER OUT = NEW BUFFEREDWRITER(FW);

            BOOLEAN EOF = FALSE;
            INT INCHAR;
            DO {
                INCHAR=IN.READ();
                IF(INCHAR!=-1)
                {
                    CHAR OUTCHAR = CHARACTER.TOUPPERCASE((CHAR) INCHAR);
                    OUT.WRITE(OUTCHAR);
                } ELSE
                    EOF = TRUE;
            } WHILE (!EOF);
            IN.CLOSE();
            OUT.CLOSE();

            FILES.DELETE(SOURCE);
            FILES.MOVE(TEMP, SOURCE);

        } CATCH (IOEXCEPTION|SECURITYEXCEPTION SE)
        {
            SYSTEM.OUT.PRINTLN("BŁĄD -- " + SE.TOSTRING());
        }
    }
}