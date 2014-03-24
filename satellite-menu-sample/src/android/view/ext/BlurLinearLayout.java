/*
   Copyright 2013 Harri Smatt

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package android.view.ext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ext.R;
import android.widget.LinearLayout;

/**
 * LinearLayout which applies blur effect into its background
 */
public class BlurLinearLayout extends LinearLayout {

    // Blur renderer instance
    private BlurRenderer mBlurRenderer;

    /**
     * Default constructor
     */
    public BlurLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        mBlurRenderer = new BlurRenderer(this);

        // Read blur radius from the layout parameters
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.BlurView);
        for (int i = 0; i < a.getIndexCount(); ++i) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.BlurView_radius) {
                int radius = a.getDimensionPixelSize(attr, 1);
                mBlurRenderer.setBlurRadius(radius);
            }
        }
        a.recycle();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mBlurRenderer.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mBlurRenderer.onDetachedFromWindow();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        // If this is off-screen pass apply blur only
        if (mBlurRenderer.isOffscreenCanvas(canvas)) {
            mBlurRenderer.applyBlur();
        }
        // Otherwise draw blurred background image and continue to child views
        else {
            mBlurRenderer.drawToCanvas(canvas);
            super.dispatchDraw(canvas);
        }
    }

    /**
     * Set blur radius in pixels
     */
    public void setBlurRadius(int radius) {
        mBlurRenderer.setBlurRadius(radius);
        invalidate();
    }

}
