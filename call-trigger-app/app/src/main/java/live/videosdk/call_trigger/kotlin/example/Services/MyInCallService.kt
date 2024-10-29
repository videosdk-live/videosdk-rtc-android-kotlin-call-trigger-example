package live.videosdk.call_trigger.kotlin.example.Services

import android.Manifest
import android.content.pm.PackageManager
import android.telecom.Call
import android.telecom.InCallService
import android.telecom.TelecomManager
import androidx.core.app.ActivityCompat

class MyInCallService : InCallService() {
    override fun onCallAdded(call: Call) {
        super.onCallAdded(call)
        call.registerCallback(object : Call.Callback() {
            override fun onStateChanged(call: Call, state: Int) {
                super.onStateChanged(call, state)
                if (state == Call.STATE_ACTIVE) {
                    // Handle the active call state
                }
            }
        })
        // Bring up the default UI for managing the call
        setUpDefaultCallUI(call)
    }

    override fun onCallRemoved(call: Call) {
        super.onCallRemoved(call)
        // Clean up call-related resources
    }

    private fun setUpDefaultCallUI(call: Call) {
        // Start the default in-call UI
        val telecomManager = getSystemService(TELECOM_SERVICE) as TelecomManager
        if (telecomManager != null) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_PHONE_STATE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return
            }
            telecomManager.showInCallScreen(true)
        }
    }
}
