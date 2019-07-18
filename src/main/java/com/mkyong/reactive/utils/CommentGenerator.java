package com.mkyong.reactive.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CommentGenerator {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    private static final List<String> COMMENT_AUTHOR =
            Arrays.asList(
                    "ACCP", "APCP", "BPCP", "CMCP", "IRCP",
                    "SDCP", "SCCP", "RVCP", "TBMS", "TPHK");


    private static final List<String> COMMENT_MESSAGE =
            Arrays.asList(
                    "35",
                    "40",
                    "16",
                    "0",
                    "13",
                    "1");
    
    private static final List<String> COMMENT_CLOSED =
            Arrays.asList(
                    "15",
                    "5",
                    "12",
                    "30",
                    "24",
                    "19");

    public static String randomAuthor() {
        return COMMENT_AUTHOR.get(RANDOM.nextInt(COMMENT_AUTHOR.size()));
    }

    public static String randomMessage() {
        return COMMENT_MESSAGE.get(RANDOM.nextInt(COMMENT_MESSAGE.size()));
    }
    
    public static String randomClosedMessage() {
        return COMMENT_CLOSED.get(RANDOM.nextInt(COMMENT_CLOSED.size()));
    }
    

    public static String getCurrentTimeStamp() {
        return dtf.format(LocalDateTime.now());
    }
}
