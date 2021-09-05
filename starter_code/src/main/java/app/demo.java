package app;


import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import oracle.sql.TIMESTAMP;

public class demo {
    private static AtomicInteger ID_GENERATOR = new AtomicInteger();
    public static void main(String[] args) throws SQLException {
      Date date = new Date();
      Timestamp timestamp = new Timestamp(date.getTime());
      System.out.println(timestamp);
}
}
