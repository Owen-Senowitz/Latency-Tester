package com.company;

public class Output {

    private int bytes;
    private int time;
    private int ttl;

    public Output (int bytes, int time, int ttl)
    {
        this.bytes = bytes;
        this.time = time;
        this.ttl = ttl;
    }

    public int getBytes() {
        return bytes;
    }

    public int getTime() {
        return time;
    }

    public int getTtl() {
        return ttl;
    }

    @Override
    public String toString() {
        return "Output{" +
                "bytes=" + bytes +
                ", time=" + time +
                ", ttl=" + ttl +
                '}';
    }
}
