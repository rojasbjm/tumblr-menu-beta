package android.view.ext;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.ext.SatelliteMenu.SateliteClickedListener;

public class SatelliteMenuActivity extends Activity {
	
	private BlurLinearLayout mFooterLayout;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        
        
        int maxBlur = getWindowManager().getDefaultDisplay().getWidth() / 8;
        mFooterLayout = (BlurLinearLayout)findViewById(R.id.footer_layout);
        mFooterLayout.setBlurRadius(maxBlur /14);
        
        
        SatelliteMenu menu = (SatelliteMenu) findViewById(R.id.menu);
        
//		  Set from XML, possible to programmatically set        
//        float distance = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 170, getResources().getDisplayMetrics());
//        menu.setSatelliteDistance((int) distance);
//        menu.setExpandDuration(500);
//        menu.setCloseItemsOnClick(false);
//        menu.setTotalSpacingDegree(60);
        
        List<SatelliteMenuItem> items = new ArrayList<SatelliteMenuItem>();
        items.add(new SatelliteMenuItem(1, R.drawable.status, "Status"));
        items.add(new SatelliteMenuItem(2, R.drawable.photo, "Photo"));
        items.add(new SatelliteMenuItem(3, R.drawable.feelings, "Feeling"));
        menu.addItems(items);        
        
        menu.setOnItemClickedListener(new SateliteClickedListener() {
			public void eventOccured(int id) {
				Log.i("sat", "Clicked on " + id);
				setContentView(R.layout.main);
			}
		});
    }
}