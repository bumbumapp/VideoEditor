package com.zcw.togglebutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.appcompat.widget.SwitchCompat;

import com.bumbumapps.videoeditor.R;

/**
 * Minimal replacement for com.zcw:togglebutton-library (jcenter only, no longer resolvable),
 * keeping its API (setToggleOn/Off, setOnToggleChanged) on top of SwitchCompat.
 */
public class ToggleButton extends SwitchCompat {

    public interface OnToggleChanged {
        void onToggle(boolean on);
    }

    private OnToggleChanged listener;

    public ToggleButton(Context context) {
        this(context, null);
    }

    public ToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ToggleButton);
            try {
                if (a.hasValue(R.styleable.ToggleButton_tbOnColor)) {
                    int on = a.getColor(R.styleable.ToggleButton_tbOnColor, 0);
                    int off = a.getColor(R.styleable.ToggleButton_tbOffBorderColor, 0xFFDADBDA);
                    setTrackTintList(new ColorStateList(
                            new int[][]{new int[]{android.R.attr.state_checked}, new int[]{}},
                            new int[]{on, off}));
                }
                setChecked(a.getBoolean(R.styleable.ToggleButton_tbAsDefaultOn, false));
            } finally {
                a.recycle();
            }
        }
        setOnCheckedChangeListener((button, checked) -> {
            if (listener != null) {
                listener.onToggle(checked);
            }
        });
    }

    public void setOnToggleChanged(OnToggleChanged onToggleChanged) {
        this.listener = onToggleChanged;
    }

    public void setToggleOn() {
        setChecked(true);
    }

    public void setToggleOff() {
        setChecked(false);
    }

    public void setToggleOn(boolean animate) {
        setChecked(true);
    }

    public void setToggleOff(boolean animate) {
        setChecked(false);
    }

    public boolean isToggleOn() {
        return isChecked();
    }
}
