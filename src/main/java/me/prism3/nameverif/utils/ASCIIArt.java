package me.prism3.nameverif.utils;

import org.bukkit.ChatColor;

import static me.prism3.nameverif.utils.Data.pluginName;
import static me.prism3.nameverif.utils.Data.pluginVersion;


/**
 * Represents the ASCIIArt Logo
 */
public class ASCIIArt {

    private ASCIIArt() {}

    private static final String ASCII_ART ="\n&d&l|&b\n&d&l|&b\n" +
                    "&d&l|&b    ,ggg, ,ggggggg,                                        ,ggg,         ,gg                                 \n" +
                    "&d&l|&b   dP\"\"Y8,8P\"\"\"\"\"\"Y8b                                      dP\"\"Y8a       ,8P                           ,dPYb, \n" +
                    "&d&l|&b   Yb, `8dP'     `88                                      Yb, `88       d8'                           IP'`Yb \n" +
                    "&d&l|&b   \"`\"  88'       88                                           88       88                       gg   I8  8I \n" +
                    "&d&l|&b        88        88                                           88       88                       \"\"   I8  8' \n" +
                    "&d&l|&b        88        88    ,gggg,gg   ,ggg,,ggg,,ggg,    ,ggg,    I8       8I   ,ggg,    ,gggggg,   gg   I8 dP  \n" +
                    "&d&l|&b        88        88   dP\"  \"Y8I  ,8\" \"8P\" \"8P\" \"8,  i8\" \"8i   `8,     ,8'  i8\" \"8i   dP\"\"\"\"8I   88   I8dP   \n" +
                    "&d&l|&b        88        88  i8'    ,8I  I8   8I   8I   8I  I8, ,8I    Y8,   ,8P   I8, ,8I  ,8'    8I   88   I8P    \n" +
                    "&d&l|&b        88        88  d8,   ,d8b,,dP   8I   8I   Yb, `YbadP'     Yb,_,dP    `YbadP' ,dP     Y8,_,88,_,d8b,_  \n" +
                    "&d&l|&b        88        88   \"Y8888P\"`Y88P'   8I   8I   `Y8888P\"Y888     \"Y8P\"    888P\"Y8888P      `Y88P\"\"Y8PI8\"8888\n" +
                    "&d&l|&b                                                                                                      I8 `8, \n" +
                    "&d&l|&b                                                                                                      I8  `8,\n" +
                    "&d&l|&b                                                                                                      I8   8I\n" +
                    "&d&l|&b                                                                                                      I8   8I\n" +
                    "&d&l|&b                                                                                                      I8, ,8'\n" +
                    "&d&l|&b                                                                                                       \"Y8P'\n" +
                    "&d&l|\n" +
                    "&d&l|&b                                                                                                       " + pluginName + ": &a" + pluginVersion + "\n&d&l|&b\n&d&l|&b";

    /**
     * Method to execute the Art printing
     */
    public static void paint() {
        Log.info(ChatColor.translateAlternateColorCodes('&', ASCII_ART));
    }
}
