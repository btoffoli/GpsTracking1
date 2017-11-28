package az.osmdroidprop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;

import org.osmdroid.ResourceProxy;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.mylocation.IMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

/**
 * Created by bruno on 27/11/17.
 */

public class BtoffoliLocationOverlay extends MyLocationNewOverlay {
    Drawable barco;

    public BtoffoliLocationOverlay(Context context, MapView mapView) {
        super(context, mapView);
        barco = context.getDrawable(R.drawable.barco);
    }

    public BtoffoliLocationOverlay(Context context, IMyLocationProvider myLocationProvider, MapView mapView) {
        super(context, myLocationProvider, mapView);
    }

    public BtoffoliLocationOverlay(IMyLocationProvider myLocationProvider, MapView mapView, ResourceProxy resourceProxy) {
        super(myLocationProvider, mapView, resourceProxy);
    }

    @Override
    protected void drawMyLocation(Canvas canvas, MapView mapView, Location lastFix) {
        barco.
        super.drawMyLocation(canvas, mapView, lastFix);
    }
}
