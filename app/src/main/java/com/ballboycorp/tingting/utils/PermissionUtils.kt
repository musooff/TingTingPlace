package com.ballboycorp.tingting.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import java.util.HashMap

/**
 * Created by musooff on 03/01/2019.
 */

object PermissionUtils{

    private const val REQUEST_STORAGE = 1
    private const val REQUEST_CAMERA = 2
    private const val REQUEST_LOCATION = 3
    private val PERMISSIONS_STORAGE = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
    private val PERMISSION_CAMERA = arrayOf(Manifest.permission.CAMERA)
    private val PERMISSION_LOCATION = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)


    private var mCallbackMap: MutableMap<Int, OnPermissionResult> = HashMap()


    private fun requestPermissions(activity: Activity, requestCode: Int, permissions: Array<String>, cb: OnPermissionResult) {
        if (isGrantedPermission(activity, permissions)) {
            cb.onResult(requestCode, true, permissions)
        } else {
            ActivityCompat.requestPermissions(activity, permissions, requestCode)
            mCallbackMap[requestCode] = cb
        }
    }

    private fun isGrantedPermission(context: Context, permissions: Array<String>): Boolean {
        for (p in permissions) {
            if (ActivityCompat.checkSelfPermission(context, p) == PackageManager.PERMISSION_DENIED) {
                return false
            }
        }
        return true
    }

    interface OnPermissionResult {
        fun onResult(requestCode: Int, granted: Boolean, permissions: Array<out String>)
    }


    fun requestStorage(activity: Activity, cb: OnPermissionResult) {
        requestPermissions(activity, REQUEST_STORAGE, PERMISSIONS_STORAGE, cb)
    }

    fun requestCamera(activity: Activity, cb: OnPermissionResult) {
        requestPermissions(activity, REQUEST_CAMERA, PERMISSION_CAMERA, cb)
    }

    fun requestLocation(activity: Activity, cb: OnPermissionResult) {
        requestPermissions(activity, REQUEST_LOCATION, PERMISSION_LOCATION, cb)
    }

    fun checkLocation(context: Context): Boolean {
        return isGrantedPermission(context, PERMISSION_LOCATION)
    }

    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        val cb = mCallbackMap.remove(requestCode)
        var granted = true
        if (cb != null) {
            for (i in grantResults.indices) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    granted = false
                }
            }
            cb.onResult(requestCode, granted, permissions)
        }
    }

}