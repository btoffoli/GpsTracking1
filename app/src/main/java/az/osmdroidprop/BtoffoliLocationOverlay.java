package az.osmdroidprop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Location;

import org.osmdroid.ResourceProxy;
import org.osmdroid.api.IMapController;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.mylocation.IMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

/**
 * Created by bruno on 27/11/17.
 */

public class BtoffoliLocationOverlay extends MyLocationNewOverlay {
    // TODO: use dynamic calculation?
    private final static int PADDING_ACTIVE_ZOOM     = 50;

    private IMapController mc;
    private Bitmap           marker;
    private Point currentPoint            = new Point();

    private boolean          centerOnCurrentLocation = true;

    private int              height;
    private int              width;

    public BtoffoliLocationOverlay(Context context, MapView mapView) {
        super(context, mapView);
        this.mc = mapView.getController();
        this.marker = BitmapFactory.decodeResource(context.getResources(), R.drawable.barco2);
    }



    @Override
    protected void drawMyLocation(Canvas canvas, MapView mapView, Location lastFix) {
//        super.drawMyLocation(canvas, mapView, lastFix);
        // TODO: find a better way to get height/width once the mapView is layed out correctly
        if (this.height == 0) {
            this.height = mapView.getHeight();
            this.width = mapView.getWidth();
        }
        mapView.getProjection().toPixels(getMyLocation(), currentPoint);
        canvas.drawBitmap(marker, currentPoint.x, currentPoint.y - 40, null);
    }

    //    @Override
//    protected void drawMyLocation(Canvas canvas, MapView mapView, Location lastFix, GeoPoint myLocation, long when) {
//
//    }

//    @Override
//    public synchronized void onLocationChanged(Location location) {
//        super.onLocationChanged(location);
//        // only move to new position if enabled and we are in an border-area
//        if (mc != null && centerOnCurrentLocation && inZoomActiveArea(currentPoint)) {
//            mc.animateTo(getMyLocation());
//        }
//    }

    private boolean inZoomActiveArea(Point currentPoint) {
        if ((currentPoint.x > PADDING_ACTIVE_ZOOM && currentPoint.x < width - PADDING_ACTIVE_ZOOM)
                && (currentPoint.y > PADDING_ACTIVE_ZOOM && currentPoint.y < height - PADDING_ACTIVE_ZOOM)) {
            return false;
        }
        return true;
    }

    public void setCenterOnCurrentLocation(boolean centerOnCurrentLocation) {
        this.centerOnCurrentLocation = centerOnCurrentLocation;
    }
}
