package com.selfcompany.faizf.newbase.utils

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.google.android.gms.maps.model.LatLng

/**
 * Created by faizf on 4/12/2017.
 */
object MapsUtil {

    fun getCurLocation(act: Activity): LatLng {
        val manager = act.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            val loc = getLastKnownLocation(act)
            if (loc != null) {
                return LatLng(loc.latitude, loc.longitude)
            }
        } else {
            buildAlertMessageNoGps(act)
        }
        return LatLng(0.0, 0.0)
    }

    fun getLastKnownLocation(act: Activity): Location? {
        val mLocationManager = act.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val providers = mLocationManager.getProviders(true)
        var bestLocation: Location? = null
        for (provider in providers) {
            if (ActivityCompat.checkSelfPermission(act, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(act, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
            }
            val l = mLocationManager.getLastKnownLocation(provider) ?: continue
            if (bestLocation == null || l.accuracy < bestLocation.accuracy) {
                // Found best last known location: %s", l);
                bestLocation = l
            }
        }
        return bestLocation
    }

    private fun buildAlertMessageNoGps(act: Activity) {
        val builder = AlertDialog.Builder(act)
        builder.setMessage("Your GPS seems to be disabled, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id -> act.startActivity(Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS)) }
                .setNegativeButton("No") { dialog, id -> dialog.cancel() }
        val alert = builder.create()
        alert.show()
    }

    fun buildAlertMessageNoPermission(act: Activity) {
        val builder = AlertDialog.Builder(act)
        builder.setMessage("You must enabled premission location manually?")
                .setCancelable(false)
                .setPositiveButton("OK") { dialog, id -> }
        val alert = builder.create()
        alert.show()
    }

    fun askForPermission(activity: Activity, permission: String, requestCode: Int?): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                    //This is called if user has denied the permission before
                    //In this case I am just asking the permission again
                    ActivityCompat.requestPermissions(activity, arrayOf(permission), requestCode!!)
                    return false
                } else {
                    ActivityCompat.requestPermissions(activity, arrayOf(permission), requestCode!!)
                    return false
                }
            } else {
                //Toast.makeText(activity, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
                return true
            }
        }
        return true
    }

}
