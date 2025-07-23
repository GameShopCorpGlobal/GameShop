package com.gameshopcorp.gameshop.gameshopui;

import com.gameshopcorp.gameshop.app.App;
import com.gameshopcorp.gameshop.graphics.ATMS;
import com.jme3.font.BitmapFont;
import com.jme3.font.BitmapText;

//import org.apache.fontbox.ttf.NameRecord;
//import org.apache.fontbox.ttf.NamingTable;
//import org.apache.fontbox.ttf.OTFParser;
//import org.apache.fontbox.ttf.OpenTypeFont;
//import org.apache.pdfbox.io.RandomAccessRead;
//import org.apache.pdfbox.io.RandomAccessReadBufferedFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//import io.github.jmecn.font.plugins.FtFontKey;
//import io.github.jmecn.font.plugins.FtFontLoader;

public class Alphabet {

    public char c;
    public ATMS atms;
    public Alphabet(char c){
        this.c = c;
        this.atms = new ATMS("Char " + c, 100, 100);

    }

    public void parser(){

    }

//    public void parser(){
//
//        // Replace with the actual path to your OTF font file
//        String otfFilePath = App.getInstance().app.getAssetManager().toString() + "/Fonts/TypeLightSans.otf";
//
//        try (FileInputStream fis = new FileInputStream(new File(otfFilePath))) {
//            OTFParser parser = new OTFParser();
//            OpenTypeFont otf = parser.parse(new RandomAccessReadBufferedFile(new File(otfFilePath)));
//
//            // Access some basic font information
//            System.out.println("Fonts Name: " + otf.getName());
//
//            // Get the Naming Table to extract specific name records
//            NamingTable namingTable = otf.getNaming();
//            if (namingTable != null) {
//                for (NameRecord nr : namingTable.getNameRecords()) {
//                    if (nr.getNameId() == NameRecord.NAME_POSTSCRIPT_NAME) {
//                        System.out.println("PostScript Name: " + nr.getString());
//                    } else if (nr.getNameId() == NameRecord.NAME_FONT_FAMILY_NAME) {
//                        System.out.println("Fonts Family Name: " + nr.getString());
//                    }
//                }
//            }
//
//            // Determine if the font uses CFF outlines
//            if (otf.isPostScript()) {
//                System.out.println("This is a CFF-based OpenType font.");
//            } else {
//                System.out.println("This is a TrueType-based OpenType font.");
//            }
//        } catch (IOException e) {
//            System.err.println("Error parsing font: " + e.getMessage());
//        }
//    }

    public void genChars(){

        if (c == 'A'){

           // this.atms.layer.drawLine(new Vector2f());
        }
    }
}
