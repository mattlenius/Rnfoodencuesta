package com.robinfood.encuesta.util;

import java.sql.Timestamp;

public class DateFecha {

    public Timestamp date() {
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        return timestamp;
    }
}
