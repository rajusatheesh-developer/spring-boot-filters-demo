package com.example.springbootfiltersdemo;

import javax.servlet.ServletOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

public class ByteArrayPrinter {

    private ByteArrayOutputStream baos = new ByteArrayOutputStream();

    private PrintWriter pw = new PrintWriter(baos);

    private ServletOutputStream sos = new ByteArrayServletStream(baos);

    public PrintWriter getWriter() {
        return pw;
    }

    public ServletOutputStream getStream() {
        return sos;
    }

    byte[] toByteArray() {
        return baos.toByteArray();
    }
}