package com.venkat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ReplacementTag {

    private static String empTag = "<contact-info>\n" +
            "   <address category = \"residence\">\n" +
            "      <name>Venkatram Veerareddy</name>\n" +
            "      <company>Sagarsoft</company>\n" +
            "      <phone><home>(111) 123-4567</home><office>(222) 123-4567</office></phone>\n" +
            "   </address>\n" +
            "</contact-info>";

    private static String officeTag = "<office>(111) 222-3333</office>";

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("MMMyy");
        Date d = new Date();
        System.out.println(sdf.format(d));
        empTag = empTag.replaceFirst("<office>", officeTag + "<office>" );
        System.out.println(empTag);
    }
}
