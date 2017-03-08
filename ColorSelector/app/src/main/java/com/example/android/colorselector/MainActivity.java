package com.example.android.colorselector;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import static java.lang.Math.ceil;

public class MainActivity extends Activity implements OnSeekBarChangeListener {
    SeekBar seekBar1, seekBar2, seekBar3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar1.setOnSeekBarChangeListener(this);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar2.setOnSeekBarChangeListener(this);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar3.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int red, green, blue;
        double rr = (seekBar1.getProgress() * 2.55);
        red = (int) ceil(rr);
        double gg = (seekBar2.getProgress() * 2.55);
        green = (int) ceil(gg);
        double bb = (seekBar3.getProgress() * 2.55);
        blue = (int) ceil(bb);
        String r, g, b;

        String hexadecimal = "#";
        String decimal = "(" + red + ", " + green + ", " + blue + ")";
        r = Integer.toHexString(red);
        g = Integer.toHexString(green);
        b = Integer.toHexString(blue);

        if (r.length() != 2)
            r = "0" + r;
        if (g.length() != 2)
            g = "0" + g;
        if (b.length() != 2)
            b = "0" + b;

        hexadecimal += r + g + b;
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setBackgroundColor(Color.parseColor(hexadecimal));
        TextView hex = (TextView) findViewById(R.id.hexa);
        hex.setText(hexadecimal);
        TextView dec = (TextView) findViewById(R.id.deca);
        dec.setText(decimal);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

}

