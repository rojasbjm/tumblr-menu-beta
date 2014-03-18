package android.view.ext;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;

/**
 * Menu Item. 
 *
 * TODO: tell about usage
 * 
 * @author Siyamed SINIR
 *
 */
public class SatelliteMenuItem {
    private int id;
    private int imgResourceId;
    private Drawable imgDrawable;
    private ImageButton view;
    private View cloneView;
    private Animation outAnimation;
    private Animation inAnimation;
    private Animation clickAnimation;

    public SatelliteMenuItem(int id, int imgResourceId) {
        this.imgResourceId = imgResourceId;
        this.id = id;
    }    
    
    public SatelliteMenuItem(int id, Drawable imgDrawable) {
        this.imgDrawable = imgDrawable;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImgResourceId() {
        return imgResourceId;
    }

    public void setImgResourceId(int imgResourceId) {
        this.imgResourceId = imgResourceId;
    }

    public Drawable getImgDrawable() {
        return imgDrawable;
    }

    public void setImgDrawable(Drawable imgDrawable) {
        this.imgDrawable = imgDrawable;
    }    
    
    void setView(ImageButton view) {
        this.view = view;
    }
    
    ImageButton getView() {
        return view;
    }
    
    void setCloneView(View cloneView) {
        this.cloneView = cloneView;
    }
    
    View getCloneView() {
        return cloneView;
    }
    
    void setInAnimation(Animation inAnimation) {
        this.inAnimation = inAnimation;
    }
    
    Animation getInAnimation() {
        return inAnimation;
    }
    
    void setOutAnimation(Animation outAnimation) {
        this.outAnimation = outAnimation;
    }
    
    Animation getOutAnimation() {
        return outAnimation;
    }

	void setClickAnimation(Animation clickAnim) {
		this.clickAnimation = clickAnim;		
	}    
	
	Animation getClickAnimation() {
		return clickAnimation;
	}
}