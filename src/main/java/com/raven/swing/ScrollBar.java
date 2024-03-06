package com.raven.swing;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBar extends JScrollBar {

    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(14, 8));
        //setForeground(new Color(122,72,221));
        setForeground(new Color(75,55,110));
        setBackground(Color.WHITE);
    }
}